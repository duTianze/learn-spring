## Ref
* https://spring.io/guides/gs/rest-service/

## What is difference between RESTful and traditional MVC
* RESTful:  The object data will be written directly to the HTTP response as JSON.
* traditional MVC: Relying on a view technology to perform server-side rendering of the greeting data to HTML

## What you'll need
1. about 15 minutes
2. jdk 1.8+
3. maven 3.2+
4. idea

## Start 
* https://start.spring.io/
* idea spring project

## Note
1. `@RestController`
marks the class as a controller where every method returns a domain object instead of a view. 
It’s shorthand for @Controller and @ResponseBody rolled together.
Spring’s MappingJackson2HttpMessageConverter is automatically chosen to convert the Greeting instance to JSON.

2. `@RequestMapping`
ensures that HTTP requests to /greeting are mapped to the greeting() method. 
`@RequestMapping maps all HTTP operations by default. Use @RequestMapping(method=GET) to narrow this mapping`

3. `@RequestParam` annotation, binds the value of the query string parameter name into the name parameter of the greeting() method. 
If the name parameter is absent in the request, the defaultValue of "World" is used

## Make the application executable
`@SpringBootApplication` is a convenience annotation that adds all of the following:
* `@Configuration` tags the class as a source of bean definitions for the application context.
* `@EnableAutoConfiguration` tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
* `@ComponentScan` tells Spring to look for other components, configurations, and services in the hello package.

##  Build an executable JAR
* `./mvn spring-boot:run`
* `./mvn clean package` and then `java -jar target/gs-rest-service-0.1.0.jar`

## Test 
* http://localhost:8080/greeting
* http://localhost:8080/greeting?name=User

## End
Congratulations! You’ve just developed a RESTful web service with Spring.