## testing-web

### `@SpringBootTest`
The `@SpringBootTest` annotation tells Spring Boot to go and look for a main configuration class (one with @SpringBootApplication for instance), 
and use that to start a Spring application context.

### `@Autowired`
The `@Autowired` annotation is interpreted by the Spring and the controller is injected before the test methods are run. 
We are using [AssertJ](https://joel-costigliola.github.io/assertj/) (`assertThat()` etc.) to express the test assertions.

### `@DirtiesContext`
A nice feature of the Spring Test support is that the application context is cached in between tests, 
so if you have multiple methods in a test case, or multiple test cases with the same configuration, 
they only incur the cost of starting the application once. You can control the cache using the @DirtiesContext annotation.

### `@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)`
Note the use of webEnvironment=RANDOM_PORT to start the server with a random port (useful to avoid conflicts in test environments)

### `@LocalServerPort`
injection of the port 

### `@AutoConfigureMockMvc`
To do use Spring’s `MockMvc` by using the `@AutoConfigureMockMvc` annotation on the test case

### `@WebMvcTest(HomeController.class)`
use this to instantiating the specify controllers which you want to be instantiated

### `@MockBean`
use `@MockBean` to create and inject a mock for the GreetingService (if you don’t do this the application context cannot start), 
and set its expectations using `Mockito`.