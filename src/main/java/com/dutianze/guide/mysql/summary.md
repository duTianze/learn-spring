### Difference between @RestController and @Controller Annotation in Spring MVC and REST
    
    Read more: https://javarevisited.blogspot.com/2017/08/difference-between-restcontroller-and-controller-annotations-spring-mvc-rest.html#ixzz60XRU8rkM
The `@RestController` annotation in Spring MVC is nothing but a combination of @Controller and `@ResponseBody` annotation. 
It was added into Spring 4.0 to make the development of RESTful Web Services in Spring framework easier. 
If you are familiar with the REST web services you know that the fundamental difference between a web application and a REST API is that 
the response from a web application is generally view (HTML + CSS + JavaScript) because they are intended for human viewers, 
while REST API just return data in form of JSON or XML because most of the REST clients are programs. 
This difference is also obvious in the `@Controller` and `@RestController` annotation.

The job of `@Controller` is to create a Map of model object and find a view,
but `@RestController` simply return the object and object data is directly written into HTTP response as JSON or XML.

This can also be done with traditional `@Controller` and use `@ResponseBody` annotation but since this is the default behavior of RESTful Web services, 
Spring introduced @RestController which combined the behavior of @Controller and @ResponseBody together.

In short, the following two code snippet are equal in Spring MVC:

```java_holder_method_tree

@Controller
@ResponseBody
public class MVCController { 
   .. your logic
}

@RestController
public class RestFulController { 
  .... your logic
}

```

Obviously, everybody would like to declare just one annotation instead of two. Also, the @RestController is more obvious and telling than the previous two. 