# Maven Playground

## Creating a Maven Monorepo

### Step 1: Set up the Project Structure

Structuring a MonoRepo with `math-lib` and `math-app` Maven projects involves creating a parent Maven project that manages both as modules.

Recommended MonoRepo Structure:

```
math-mono-repo/
├── math-lib/
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/example/math/
│   └── pom.xml
├── math-app/
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/example/app/
│   └── pom.xml
└── pom.xml         (Parent POM)
```

#### Explanation:

* ```mono-repo/```: This is the root directory of the MonoRepo.
* ```math-lib/```: Existing Math Library project. Its internal structure `(src/main/java, pom.xml)` remains largely the same.
* ```math-app/```: Your existing application project. Its internal structure `(src/main/java, pom.xml)` also remains largely the same.
* ```pom.xml``` **(at the root)**: This will be the Parent POM file. It will define the common configurations and list `math-lib` and `math-app` as modules.

### Step 2: Create Parent POM (`math-mono-repo/pom.xml`):

```XML
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>math-mono-repo</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>

    <name>MonoRepo for Math Library and Application</name>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <modules>
        <module>math-lib</module>
        <module>math-app</module>
    </modules>

    <build>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.8.1</version>
                    <configuration>
                        <source>${maven.compiler.source}</source>
                        <target>${maven.compiler.target}</target>
                    </configuration>
                </plugin>
                <plugin>
                    <artifactId>maven-jar-plugin</artifactId>
                    <version>3.2.0</version>
                </plugin>
                <plugin>
                    <artifactId>maven-assembly-plugin</artifactId>
                    <version>3.3.0</version>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
</project>
```

:ledger: Explanation of the Parent POM:

* ```<packaging>pom</packaging>```: This indicates that this POM is for managing other Maven projects (modules) and doesn't produce an artifact itself.
* ```<modules>```: This section lists the sub-projects (modules) that are part of this MonoRepo. Here, we specify ```math-lib``` and ```math-app```. Maven will look for ```pom.xml``` files in these directories.
* ```<properties>```: You can define common properties here that can be inherited by the modules (like the Java source and target versions).
* ```<build><pluginManagement>```: This section allows you to define plugin configurations that will be used by the child modules unless they override them. This helps in maintaining consistent build configurations across your projects.

### Step 3: Updating Child Modules POM

`math-lib/pom.xml` **(Child Module):**

This file will be very similar to original `math-lib/pom.xml`, but we can remove the `<properties>` and `<build>` sections if we want to inherit them from the parent POM.

```XML
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.example</groupId>
        <artifactId>math-mono-repo</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

    <artifactId>math-lib</artifactId>
    <packaging>jar</packaging>
    <name>Math Library</name>
</project>
```

#### Key changes in `math-lib/pom.xml`:

* ```<parent>```: This section specifies the parent POM.
* ```<groupId>```, ```<artifactId>```, ```<version>```: Must match the parent POM.
* ```<relativePath>../pom.xml</relativePath>```: Specifies the relative path to the parent POM file from the current module's directory.

`math-app/pom.xml` **(Child Module):**

Similarly, let's update `math-app/pom.xml` to inherit from the parent and adjust the dependency on `math-lib`.

```XML

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.example</groupId>
        <artifactId>math-mono-repo</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

    <artifactId>math-app</artifactId>
    <packaging>jar</packaging>
    <name>Math Application</name>

    <dependencies>
        <dependency>
            <groupId>org.example</groupId>
            <artifactId>math-lib</artifactId>
            <version>${project.version}</version>
        </dependency>
    </dependencies>
</project>
```

#### Key changes in `math-app/pom.xml`:

* ```<parent>```: This section specifies the parent POM.
* ```<dependencies><dependency><version>${project.version}</version></dependency>```: Here, we use the `${project.version}` property, which will inherit the version defined in the parent POM. This helps keep the versions of related modules consistent.
* ```<build>```: This section for maven-jar-plugin and maven-assembly-plugin remains similar.

:clap::beers: Congratulations! You have successfully created a simple Math Library JAR using Maven and then used it in another Maven project. This demonstrates the basic principles of creating and using Maven dependencies.