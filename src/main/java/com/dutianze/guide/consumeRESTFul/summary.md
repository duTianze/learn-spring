## Consuming a RESTful Web Service 
[https://spring.io/guides/gs/consuming-rest/](https://spring.io/guides/gs/consuming-rest/)

## Fetch a REST resource
If you request [https://gturnquist-quoters.cfapps.io/api/random](https://gturnquist-quoters.cfapps.io/api/random) through your web browser or curl, you'll receive a JSON document that looks something like this:
```json5
{
   type: "success",
   value: {
      id: 10,
      quote: "Really loving Spring Boot, makes stand alone Spring apps easy."
   }
}
```

## same
1. `object variable name` must same as `the key in the JSON Document returned from the API`.
2.  otherwise, you need to use `@JsonProperty` annotation to specify the exact key of JSON document.

## convert json to object
`RestTemplate` will use [message converter](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/converter/HttpMessageConverter.html) 
to convert the incoming JSON data into a `Quote` object.
From there, the contents of the `Quote` object will be logged to the console

## RestTemplate make http request
you can use `RestTemplate` to make HTTP `GET`、`POST`、`PUT`、`DELETE` request. 

## RestTemplateBuilder
The `RestTemplateBuilder` is injected by Spring, and if you use it to create a RestTemplate 
then you will benefit from all the autoconfigure that happens in Spring Boot with message converters and request factories. 
We also extract the RestTemplate into a @Bean.

## spring-javaconfig
`@Bean` is a method-level annotation and a direct analog of the XML <bean/> element. The annotation supports most of the attributes offered by <bean/>, such as: init-method, destroy-method, autowiring, lazy-init, dependency-check, depends-on and scope.

### Declaring a bean
To declare a bean, simply annotate a method with the @Bean annotation. 
When JavaConfig encounters such a method, it will execute that method and register the return value as a bean within a BeanFactory. By default, 
the bean name will be the same as the method name (see bean naming for details on how to customize this behavior). 
The following is a simple example of a @Bean method declaration:
```java
@Configuration
public class AppConfig {
    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl();
    }
}
```
                
For comparison sake, the configuration above is exactly equivalent to the following Spring XML:
```xml
<beans>
    <bean name="transferService" class="com.acme.TransferServiceImpl"/>
</beans>
```      
         
Both will result in a bean named transferService being available in the BeanFactory / ApplicationContext, 
bound to an object instance of type TransferServiceImpl:
```
transferService -> com.acme.TransferServiceImpl
```
         