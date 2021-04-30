# 一些开源中间件的使用


## consul
主要做配置中心跟服务注册发现

docker安装； docker-compose.yml 配置如下：
使用`docker-compose up` 命令启动
```
version: "3"
services:
  consul:
    container_name: consul
    image: consul:1.9.4
    ports:
      - 8500:8500
    volumes:
      - ./consul:/consul
    command: ["consul","agent","-server","-bootstrap","-data-dir","/consul/data","-config-dir","/consul/config","-ui","-client","0.0.0.0"]
```
consul 访问权限控制配置：
配置目录`./consul/config/acl.json`
```
{
        "datacenter": "test-dc",
        "acl_datacenter": "test-dc",
        "acl_master_token": "lemon",
        "acl_default_policy": "deny",
        "server": true,
        "log_level": "DEBUG",
        "client_addr": "0.0.0.0"
}
```
consul提供了管理端：
http://127.0.0.1:8500/ui
在ACL登录了输入配置的token：lemon

操作的话可以通过api：
官网api地址：https://www.consul.io/api-docs/agent/service

也可以通过客户端来操作