package com.loltoulan.websocket_demo.nativeWs;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

public class JdkNativeWebSocket {

    public static void main(String[] args) throws InterruptedException, IOException {
        int port = 8887; // 843 flash policy port

        SocketServer s = new SocketServer(port);
        s.start();
        System.out.println("ChatServer started on port: " + s.getPort());

        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = sysin.readLine();
            s.broadcast(in);
            if (in.equals("exit")) {
                s.stop(1000);
                break;
            }
        }
    }

}

class SocketServer extends WebSocketServer {

    public SocketServer(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
    }
    public SocketServer(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send("Welcome to the server!"); // This method sends a message to the new client
        broadcast("new connection: " + handshake
                .getResourceDescriptor()); // This method sends a message to all clients connected
        System.out.println(
                conn.getRemoteSocketAddress().getAddress().getHostAddress() + " entered the room!");

    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        broadcast(conn + " has left the room!");
        System.out.println(conn + " has left the room!");

    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        broadcast(message);
        System.out.println(conn + ": " + message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
        if (conn != null) {
            // some errors like port binding failed may not be assignable to a specific
            onClose(conn, -1, ex.getMessage(), false);
        }
    }

    @Override
    public void onStart() {
        System.out.println("Server started!");
        setConnectionLostTimeout(0);
        setConnectionLostTimeout(100);
    }
}