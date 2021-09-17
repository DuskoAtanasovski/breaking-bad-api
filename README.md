# Breaking Bad API

## Built with
* 	[Maven](https://maven.apache.org/) - Dependency Management.
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit.
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications.
* 	[H2](https://www.h2database.com/html/main.html) - Open-source, in memory lightweight Java database.
* 	[Git](https://git-scm.com/) - Free and Open-Source distributed version control system.
* 	[Lombok](https://projectlombok.org/) - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.breakingbad.Application` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open IDE
    - File -> Import -> Navigate to the folder where you unzipped the zip
    - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Description

The Breaking Bad API is a collection of information on the Vince Gilligan series Breaking Bad, as well as his incredible spin-off Better Call Saul. This site is designed to make it easy on the developer to see what HTTP requests are possible, and what information is available.

The following information is provided through this API...

Characters <br />
Episodes <br />
Quotes <br />
Deaths <br />

Base Url: https://breakingbadapi.com/documentation

## Demo

After you start the application the server will listen on port 8080

- Get all characters <br />
HTTP GET localhost:8080/characters/all


- Get all deaths <br />
  HTTP GET localhost:8080/deaths/all


- Get all episodes <br />
  HTTP GET localhost:8080/episodes/all


- Get all quotes <br />
  HTTP GET localhost:8080/quotes/all


- Get character by id <br />
  HTTP GET localhost:8080/character/{id}


- Get character by name <br />
  HTTP GET localhost:8080/character/{name}


- Get random character <br />
  HTTP GET localhost:8080/character/random


- Get episode by id <br />
  HTTP GET localhost:8080/episode/{id}


- Get random episode <br />
  HTTP GET localhost:8080/episode/random


- Get quote by id <br />
  HTTP GET localhost:8080/quote/{id}


- Get random quote <br />
  HTTP GET localhost:8080/quote/random
