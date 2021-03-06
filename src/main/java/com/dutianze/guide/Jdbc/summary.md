## Accessing Relational Data using JDBC with Spring

## problem: can't create table 
solution:
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>
```         
## Tip
1. Spring Boot supports H2, an in-memory relational database engine, and automatically creates a connection. 
Because we are using spring-jdbc, Spring Boot automatically creates a JdbcTemplate. 
The `@Autowired` JdbcTemplate field automatically loads it and makes it available.

2. For single insert statements, JdbcTemplate’s `insert method is good. 
But for multiple inserts, it’s better to use batchUpdate.

3.  `jdbcTemplate.query` The last argument is a Java 8 lambda used to convert each result row into a new Customer object.

## Spring Boot Maven plugin 
[Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/)
1. It collects all the jars on the classpath and builds a single, runnable "über-jar", 
which makes it more convenient to execute and transport your service.

2. It searches for the public static void main() method to flag as a runnable class.

3. It provides a built-in dependency resolver that sets the version number to match Spring Boot dependencies. 
You can override any version you wish, but it will default to Boot’s chosen set of versions.

## The Spring Boot Plugin has the following goals.

`spring-boot:run` runs your Spring Boot application.
`spring-boot:repackage` repackages your jar/war to be executable.
`spring-boot:start` and `spring-boot:stop` to manage the lifecycle of your Spring Boot application (i.e. for integration tests).
`spring-boot:build-info` generates build information that can be used by the Actuator.