Integrate JUnit:

IntelliJ IDEA -> Create New Project -> Maven Project 

Go to https://mvnrepository.com/ -> 3. JUnit Jupiter (Aggregator) -> Can check all availabe versions ->
choose version 5.7.2 then copy :

<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.7.2</version>
    <scope>test</scope>
</dependency>

and paste it into pom file of maven project


Setup in VS code:
-----------------
Install Java Test Runner extension, Project Manager for java, Java Extension Pack.
Create a maven project ->
In main file :
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


