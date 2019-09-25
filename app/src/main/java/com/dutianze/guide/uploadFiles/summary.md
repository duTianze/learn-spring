## Uploading Files

## problem: can't find web page
solution:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```        
The `static` content in your templates directory should be moved to `src/main/resources/static`. 
The `templates` directory is meant for serving content that needs to be rendered on the server side (for example Thymeleaf).

## Java Files.walk examples
[https://www.mkyong.com/java/java-files-walk-examples/](https://www.mkyong.com/java/java-files-walk-examples/)
The Files.walk API is available in Java 8, it is recommended to use try-with-resources to close the Files.walk stream.
1. List all files.
```java_holder_method_tree
try (Stream<Path> walk = Files.walk(Paths.get("C:\\projects"))) {

    List<String> result = walk.filter(Files::isRegularFile)
            .map(x -> x.toString()).collect(Collectors.toList());

    result.forEach(System.out::println);

} catch (IOException e) {
    e.printStackTrace();
}
```

2. List all folders.
```java_holder_method_tree
try (Stream<Path> walk = Files.walk(Paths.get("C:\\projects"))) {

    List<String> result = walk.filter(Files::isDirectory)
            .map(x -> x.toString()).collect(Collectors.toList());

    result.forEach(System.out::println);

} catch (IOException e) {
    e.printStackTrace();
}
```

3. List all files end with .txt
```java_holder_method_tree
try (Stream<Path> walk = Files.walk(Paths.get("C:\\projects"))) {

    List<String> result = walk.map(x -> x.toString())
            .filter(f -> f.endsWith(".txt")).collect(Collectors.toList());

    result.forEach(System.out::println);

} catch (IOException e) {
    e.printStackTrace();
}
```
`References` [Java docs – Files.walk](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#walk-java.nio.file.Path-java.nio.file.FileVisitOption...-)

## Understanding java.nio.file.Path.relativize

```java_holder_method_tree
Path p1 = Paths.get("java/temp/zoo.txt");
Path p2 = Paths.get("java/bin/elephant.bin");

Path p1Top2 = p1.relativize(p2);
System.out.println(p1Top2);
```
return
```text
../../bin/elephant.bin
```


