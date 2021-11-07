# Spring Boot Spring Native Example

Spring Native provides support for compiling Spring applications to native executables using the GraalVM native-image compiler.  
  
<img src="https://github.com/susimsek/spring-native-example/blob/main/images/spring-native-example.png" alt="Spring Boot Spring Native Example" width="100%" height="100%"/> 

## Prerequisites

* Docker 19.03+
* Docker Compose 1.25+

## Build Docker Image

```sh
mvn spring-boot:build-image
```

## Installation

```sh
docker-compose up -d 
```

## Used Technologies

* Spring Boot
* Spring Native
* H2
* GraalVM
* Swagger

### Used Libraries

* Java 11.0.13 
* GraalVM CE 21.3.0
* Spring Boot 2.5.6
* Spring Native 0.10.5
* Spring Boot Starter Web
* Spring Boot Starter Validation
* Spring Boot Starter Actuator
* Spring Boot Starter Jpa
* SpringDoc Openapi Ui
* Lombok
* H2

## Swagger Support

You can access the swagger ui from the following url.  

http://localhost:9090/swagger-ui.html

<img src="https://github.com/susimsek/spring-native-example/blob/main/images/swagger.png" alt="Swagger Documentation" width="100%" height="100%"/>