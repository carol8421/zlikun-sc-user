# zlikun-sc-user
用户基础数据微服务

#### [Service Discovery: Eureka Clients](Service Discovery: Eureka Clients)
> 配置注册中心
```
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
```

#### 测试服务
```
# http://192.168.0.9:9000/actuator/info
# http://192.168.0.9:9000/actuator/health
# http://192.168.0.9:9000/user/1

# 启动多个服务(通过端口指定 --server.port=9001 / --server.port=9002)，可以在注册中心看到成功注册了多个服务
# http://localhost:8761/
```