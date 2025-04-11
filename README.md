# Maven Playground

## Creating a Maven Project to Use the Math Library

### Step 1: Set up the Project Structure

Create a new directory for your application project. Let's call it math-app. Inside this directory, create the standard Maven project structure:

```
math-app/
├── src/
│   └── main/
│       └── java/
│           └── org/example/math/app
└── pom.xml
```

### Step 2: Create the Application Code (Java Code)

Inside the src/main/java/org/example/math/app/ directory, create a Java file named App.java:

```java
package org.example.math.app;

import org.example.math.libs.MathUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int x = 10;
        int y = 5;

        System.out.println("Sum : " + MathUtils.add(x,y));
        System.out.println("Subtract : " + MathUtils.subtract(x,y));
        System.out.println("Product : " + MathUtils.multiply(x,y));
    }
}
```

### Step 3: Create the Maven POM File (pom.xml)

Inside the math-app directory, create a file named pom.xml with the following content:

```XML
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>math-app</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>Math Application</name>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.example</groupId>
            <artifactId>math-lib</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
            </plugin>
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>3.3.0</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                        <configuration>
                            <archive>
                                <manifest>
                                    <mainClass>org.example.math.app.Main</mainClass>
                                </manifest>
                            </archive>
                            <descriptorRefs>
                                <descriptorRef>jar-with-dependencies</descriptorRef>
                            </descriptorRefs>
                            <appendAssemblyId>false</appendAssemblyId>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

:ledger: Explanation of pom.xml (for math-app):

Most of the basic elements (modelVersion, groupId, artifactId, version, packaging, name, properties, maven-compiler-plugin) are similar to the math-lib project.
```<dependencies>```: This section lists the external libraries that your project depends on.
```<dependency>```: Defines a single dependency.
```<groupId>org.example</groupId>```: The groupId of the Math Library.
```<artifactId>math-lib</artifactId>```: The artifactId of the Math Library.
```<version>1.0-SNAPSHOT</version>```: The version of the Math Library you want to use. Make sure this matches the version of the JAR you installed.
```<build> and <plugins>```:
```maven-compiler-plugin```: For compiling the application code.


:ledger: Explanation of the maven-assembly-plugin configuration:

```<artifactId>maven-assembly-plugin</artifactId>```: Specifies the plugin to use.
```<executions>```: Configures when and how the plugin should run.
```<execution>```: Defines a specific execution of the plugin.
```<phase>package</phase>```: The plugin will run during the package phase of the Maven build lifecycle.
```<goals><goal>single</goal></goals>```: The single goal tells the plugin to create a single assembled archive.
```<configuration>```: Configures the assembly process.
```<archive><manifest><mainClass>org.example.math.app.Main</mainClass></manifest></archive>```: Specifies the main class for the executable JAR.
```<descriptorRefs><descriptorRef>jar-with-dependencies</descriptorRef></descriptorRef>```: This tells the plugin to create a JAR that includes all the project's dependencies.
```<appendAssemblyId>false</appendAssemblyId>```: This prevents the plugin from appending an extra identifier to the output JAR name.

### Step 4: Build and Run the Application

:computer: Open your terminal or command prompt, navigate to the math-app directory, and run the following Maven commands:

```Bash
mvn clean package
java -jar target/math-app-1.0-SNAPSHOT.jar
```

#### Explanation of the commands:

```mvn clean package```: Cleans the target directory and then compiles the code and packages it into an executable JAR file (math-app-1.0-SNAPSHOT.jar) in the target directory. Maven will automatically download and include the math-lib-1.0-SNAPSHOT.jar from your local repository because you declared it as a dependency in the pom.xml.
```java -jar target/math-app-1.0-SNAPSHOT.jar```: Executes the JAR file of your application.

#### Expected Output:

```
Sum: 15
Difference: 5
Product: 50
```

:clap::beers: Congratulations! You have successfully created a simple Math Library JAR using Maven and then used it in another Maven project. This demonstrates the basic principles of creating and using Maven dependencies.