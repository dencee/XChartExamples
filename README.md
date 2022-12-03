## Java Charts Using XChart

Examples of different charts in Java using XChart:

   * `https://knowm.org/open-source/xchart/xchart-example-code/`

To add these charts to your Maven project in IntelliJ,
add the code below to the `<dependencies>` of your pom.xml file, then
right click on `pom.xml -> maven -> Reload Project`:
```
    <dependencies>
        <dependency>
            <groupId>org.knowm.xchart</groupId>
            <artifactId>xchart</artifactId>
            <version>3.8.2</version>
        </dependency>
        <dependency>
            <groupId>org.knowm.xchart</groupId>
            <artifactId>xchart-demo</artifactId>
            <version>3.8.2</version>
        </dependency>
    </dependencies>
```