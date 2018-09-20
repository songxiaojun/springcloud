# springcloud
### 使用技术

- 服务注册与发现 Eureka
- 服务消费者 Ribbon
- 服务消费者 Feign
- 分布式配置中心
- 服务容错保护 Hystrix
- 服务网关
### 项目结构说明

~~~java
```
springcloud  
   | -- springcloud-common  公共组件: 提供一系列工具类或方法
   | -- springcloud-consumer-movie  消费者
   | -- springcloud-consumer-movie-ribbon 消费者使用ribbon服务
   | -- springcloud-entity 实体
   | -- springcloud-eureka-8761 eureka的服务注册中心：eureka-server 端口号为8761
   | -- springcloud-eureka-8762 eureka的服务注册中心：eureka-server 端口号为8762
   | -- springcloud-provide-user user服务提供者
```
~~~

