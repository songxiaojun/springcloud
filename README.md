# springcloud

### 使用技术

- 服务注册与发现 Eureka
- 服务消费者 Ribbon
- 服务消费者 Feign
- 分布式配置中心
- 服务容错保护 Hystrix
- 服务网关
### 微服务及占用端口

| 微服务模块名称                        | 端口 | 功能描述                         |
| :------------------------------------ | ---- | -------------------------------- |
| springcloud-common                    | ---  | 公共组件: 提供一系列工具类或方法 |
| springcloud-consumer-movie            | 7901 | 消费者                           |
| springcloud-consumer-movie-ribbon     | 7902 | 消费者使用ribbon服务             |
| springcloud-consumer-movie-feign      | 7903 | 使用feign服务的消费者            |
| springcloud-eureka-8761               | 8761 | eureka的服务注册中心             |
| springcloud-eureka-8762               | 8762 | eureka的服务注册中心             |
| springcloud-provide-user              | 7900 | user服务提供者                   |
| springcloud-provide-user-7901         | 7901 | user服务提供者                   |
| springcloud-provide-user-hystrix-7902 | 7902 | 服务熔断                         |
| springcloud-zuul-gateway              | 7527 | 网关                            |




