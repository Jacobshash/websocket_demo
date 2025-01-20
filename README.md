# WebSocket Demo 项目

## 项目简介

这是一个使用Spring Boot和Java-WebSocket库实现的WebSocket示例项目。项目演示了如何使用原生Java WebSocket API创建一个简单的聊天服务器。

## 功能特性

- 使用Spring Boot Starter Actuator进行应用监控。
- 集成了Redis数据存储。
- 实现了一个基于Java-WebSocket库的WebSocket服务器。
- 提供了一个简单的REST控制器用于演示。

## 依赖库

- `spring-boot-starter-data-redis`: Redis数据访问支持。
- `spring-boot-starter-actuator`: 应用程序监控支持。
- `spring-boot-starter-web`: Spring MVC支持。
- `lombok`: 简化Java代码的开发库。
- `slf4j-api` 和 `logback-classic`: 日志记录支持。
- `Java-WebSocket`: WebSocket通信支持。

## 快速开始

### 环境准备

确保已安装以下工具：
- JDK 8 或更高版本
- Maven 3.5 或更高版本

### 运行项目

1. 克隆仓库并进入项目目录：
    git clone <repository-url> cd websocket_demo
2. 使用Maven构建项目： mvn spring-boot:run

4. WebSocket服务器将启动并在端口8887上监听连接。

### 示例代码

#### WebSocket服务器

在`com.loltoulan.websocket_demo.controller.JdkNativeWebSocket`类中实现了WebSocket服务器。该服务器会在有新客户端连接时发送欢迎消息，并广播所有客户端的消息。

#### REST控制器

`com.loltoulan.websocket_demo.controller.WebSocketDemoSimpleController`是一个简单的REST控制器，用于演示目的。

## 注意事项

- 当前WebSocket服务器运行在一个独立线程中，适用于小型测试或演示场景。
- 对于生产环境，请考虑使用更稳定的WebSocket实现如Spring WebSocket。

## 贡献

欢迎贡献代码！请先 fork 本仓库，然后提交 pull request。

## 许可证

本项目采用MIT许可证，详情参见 [LICENSE]() 文件。
