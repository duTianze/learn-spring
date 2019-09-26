## Accessing data with MySQL
[https://spring.io/guides/gs/accessing-data-mysql/](https://spring.io/guides/gs/accessing-data-mysql/)
### Create the Database

use the following command connects to MySQL as root and allows access to the user from all hosts.
`sudo mysql --password`

### Create a new database
```bash
 mysql> create database db_example; -- Creates the new database
 mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
 mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
```

### Create the `application.properties` File
Spring Boot gives you defaults on all things. For example, the default database is H2. Consequently, when you want to use any other database, 
you must define the connection attributes in the application.properties file.
```properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
spring.datasource.username=springuser
spring.datasource.password=ThePassword
```
Here, `spring.jpa.hibernate.ddl-auto` can be `none`, `update`, `create`, or `create-drop`. See the Hibernate documentation for details.

`none`: The default for MySQL. No change is made to the database structure.

`update`: Hibernate changes the database according to the given entity structures.

`create`: Creates the database every time but does not drop it on close.

`create-drop:` Creates the database and drops it when SessionFactory closes.

You must begin with either `create` or `update`, because you do not yet have the database structure. 
After the first run, you can switch it to `update` or `none`, according to program requirements. 
Use `update` when you want to make some change to the database structure.

The default for `H2` and other embedded databases is `create-drop`. For other databases, such as `MySQL`, the default is `none`.

It is good security practice to, after your database is in production state, set this to `none`, 
revoke all privileges from the MySQL user connected to the Spring application, 
and give the MySQL user only `SELECT`, `UPDATE`, `INSERT`, and `DELETE`. You can read more about this at the end of this guide.

### Make Some Security Changes

When you are on a production environment, you may be exposed to SQL injection attacks. 
A hacker may inject DROP TABLE or any other destructive SQL commands. 
So, as a security practice, you should make some changes to your database before you expose the application to your users.

revokes all the privileges from the user associated with the Spring application
```bash
mysql> revoke all on db_example.* from 'springuser'@'localhost';
```

Removing all privileges and granting some privileges gives your Spring application the privileges necessary 
to make changes to only the data of the database and not the structure (schema).

When you want to make changes to the database:

1. Regrant permissions.

2. Change the spring.jpa.hibernate.ddl-auto to update.

3. Re-run your applications.


### Difference between @RestController and @Controller Annotation in Spring MVC and REST
    
[Read more](https://javarevisited.blogspot.com/2017/08/difference-between-restcontroller-and-controller-annotations-spring-mvc-rest.html#ixzz60XRU8rkM)

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