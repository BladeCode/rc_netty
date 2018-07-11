# rc_netty
[Netty](https://github.com/netty/netty)：Netty is an asynchronous event-driven network application framework for rapid development of maintainable high performance protocol servers & clients.
![components](http://netty.io/images/components.png)

## Netty的使用场景
* 作为RPC通讯框架或通信协议，通讯的库，实现远程过程的调用（基于socket方式）
* 作为长连接的服务器，实现客户端和服务端的长连接通信
* 作为HTTP的服务器，类似Jetty，Tomcat

## Netty重要组件
* Channel（通道）
* ChannelHandler（通道处理器），类似过滤器，或者拦截器
* pipeline（管道），多个ChannelHandler构成

## Netty程序写法流程
1. 启动一个Bootstrap这样的服务器，服务器中关联两个事件循环组【死循环】（bossGroup：获取链接,workerGroup：真正来处理链接），服务器启动时关联一个处理器，处理器类似Initializer这样的处理器
2. 在initChannel中自定义添加若干个处理器
3. 按照流程走到提供的处理器中，在处理器中返回处理的结果

## Environment
* JDK Version 1.8.0_152
* DevTool：IDEA
* Netty Version：4.1.25.Final

> RoadMap 和其他知识请查看[Wiki](https://github.com/RootCluster/rc_netty/wiki)

## License
```
Copyright (c) 2018 Jerry xu.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```