## Authenticating a User with LDAP

## What is the use of `@EnableWebSecurity` in spring
The `@EnableWebSecurity` is a marker annotation. It allows Spring to find (it's a @Configuration and, therefore, @Component) 
and automatically apply the class to the global WebSecurity.

`If I don't annotate any of my class with @EnableWebSecurity still the application prompting for username and password.`

Yes, it is the default behavior. If you looked at your classpath, you could find other classes marked with that annotation (depends on your dependencies):

 * SpringBootWebSecurityConfiguration;
 * FallbackWebSecurityAutoConfiguration;
 * WebMvcSecurityConfiguration.
Consider them carefully, turn the needed configuration off, or override its behavior.

## Embedded ldap connection refused
`application.properties`
```text
spring.ldap.embedded.ldif=classpath:test-server.ldif
spring.ldap.embedded.base-dn=dc=springframework,dc=org
spring.ldap.embedded.port=8389
```

## account
user: ben
password: benspassword