<<<<<<< Updated upstream
# Maven Playground
=======
# maven-playground

## Creating the Math Library (Math Lib)

### Step 1: Set up the Project Structure

Create a new directory for your Math Library project. Let's call it math-lib. Inside this directory, create the standard Maven project structure:

```
math-lib/
├── src/
│   └── main/
│       └── java/
│           └── org/example/math/libs
└── pom.xml
```

### Step 2: Create the Math Functions (Java Code)

Inside the src/main/java/org/example/math/libs/ directory, create a Java file named MathUtils.java:

```java

package org.example.math.libs;

public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }
}
```

### Step 3: Create the Maven POM File (pom.xml)

Inside the math-lib directory, create a file named pom.xml with the following content:

```XML
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>math-lib</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>Math Library</name>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
            </plugin>
        </plugins>
    </build>
</project>
```
Explanation of pom.xml:

```<modelVersion>4.0.0</modelVersion>```: Specifies the Maven POM model version.
```<groupId>com.example</groupId>```: A unique identifier for your project's group (usually your organization or a logical grouping).
```<artifactId>math-lib</artifactId>```: A unique identifier for the artifact (the JAR file in this case).
```<version>1.0-SNAPSHOT</version>```: The version of your library. -SNAPSHOT indicates it's a development version.
```<packaging>jar</packaging>```: Specifies that the output of this project will be a JAR file.
```<name>Math Library</name>```: A human-readable name for your project.
```<properties>```: Defines properties that can be used in the POM. Here, we specify the source and target Java versions for compilation.
```<build> and <plugins>```: Configure the build process. We include the maven-compiler-plugin to ensure the Java code is compiled with the specified versions.

### Step 4: Build and Install the JAR

Open your terminal or command prompt, navigate to the math-lib directory, and run the following Maven command:

```Bash

mvn clean install
```

#### Explanation of the command:

```mvn clean```: Cleans the target directory (where build outputs are stored).

```mvn install```: Compiles the code, runs any tests (if you had them), packages the code into a JAR file, and installs the JAR into your local Maven repository (```~/.m2/repository```).

After successful execution, you will find the math-lib-1.0-SNAPSHOT.jar file in the math-lib/target directory, and it will also be installed in your local Maven repository.
>>>>>>> Stashed changes
