# Spring Boot Spring Native Example

Spring Native provides support for compiling Spring applications to native executables using the GraalVM native-image compiler.  
  
<img src="https://github.com/susimsek/spring-native-example/blob/main/images/spring-native-example.png" alt="Spring Boot Spring Native Example" width="100%" height="100%"/> 

## Build the native Application

### Prerequisites

* Java 11.0.13
* GraalVM CE 21.3.0
* Maven 3.x

### Build

The native application can be built as follows:

```sh
mvn -Pnative -DskipTests package
```

## Build Docker Image

### Prerequisites

* Docker 19.03+
* Maven 3.x

### Build

The docker image of native application can be built as follows:

```sh
mvn spring-boot:build-image
```

## Installation for Docker Compose Deployment

### Prerequisites

* Docker 19.03+
* Docker Compose 1.25+

### Installation

The native application can be installed as follows:

```sh
docker-compose up -d 
```

### Swagger

Swagger ui can be accessed from the following url

http://localhost:9090/swagger-ui.html

<img src="https://github.com/susimsek/spring-native-example/blob/main/images/swagger.png" alt="Swagger Documentation" width="100%" height="100%"/>

## Installation for Kubernetes Deployment

<img src="https://github.com/susimsek/spring-native-example/blob/main/images/app-k8s.png" alt="Spring Boot Spring Native Kubernetes Deployment" width="100%" height="100%"/> 

### Prerequisites for Kubernetes Deployment

* Kubernetes 1.12+
* Helm 3.x
* Ingress Controller
* PV provisioner support in the underlying infrastructure

### Installation

The native application can be installed as follows:

```sh
helm upgrade --install spring-native-example helm-chart/spring-native-example
```

### Swagger

Swagger ui can be accessed from the following url

http://susimsek.github.io/swagger-ui.html

<img src="https://github.com/susimsek/spring-native-example/blob/main/images/swagger.png" alt="Swagger Documentation" width="100%" height="100%"/>

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