# Proof-of-concept Quarkus Rest DB and H2 example application

Example application using Quarkus with similar functionality as the Spring example of my book 
["Getting Started with Java on Raspberry Pi"](https://webtechie.be/books/), see this 
[GitHub project which is part all the examples of the book](https://github.com/FDelporte/JavaOnRaspberryPi/tree/master/Chapter_10_Spring/java-spring-rest-db).

This project uses Quarkus, the Supersonic Subatomic Java Framework.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Web services

* [http://0.0.0.0:8080/hello](http://0.0.0.0:8080/hello)
* [http://0.0.0.0:8080/openapi](http://0.0.0.0:8080/openapi)
* [http://0.0.0.0:8080/swagger-ui](http://0.0.0.0:8080/swagger-ui)
* [http://0.0.0.0:8080/quarkus/arc/beans](http://0.0.0.0:8080/quarkus/arc/beans)
* [http://0.0.0.0:8080/quarkus/arc/observers](http://0.0.0.0:8080/quarkus/arc/observers)

## Inspired by

* [Quarkus - Simplified Hibernate ORM with Panache](https://quarkus.io/guides/hibernate-orm-panache)
* [Quarkus - Using OpenAPI and Swagger UI](https://quarkus.io/guides/openapi-swaggerui)

## Quarkus documentation

### Empty project

The initial code was created with

```
mvn io.quarkus:quarkus-maven-plugin:1.6.0.Final:create     
    -DprojectGroupId=be.webtechie.javaquarkusrestdb     
    -DprojectArtifactId=javaquarkusrestdb    
    -DclassName="be.webtechie.javaquarkusrestdb.resource.GreetingResource"     
    -Dpath="/hello"
```

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```
./mvnw quarkus:dev
```

### Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `getting-started-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/getting-started-1.0-SNAPSHOT-runner.jar`.

### Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/getting-started-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.