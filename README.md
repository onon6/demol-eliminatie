# De Mol - Eliminatie
**(Software under construction)**

This software recreates the elimination screen from the popular Belgian TV show De Mol. 
By entering names of candidates, the software will either show a green or a red screen.

In order for this software to work, the file "geelimineerden.txt" should be edited in order
to add the names of the people who should get a red screen. All other names will result in a 
green screen by default.


# Requirements
At minimum Java 17 is required. You can download the JRE (included in the JDK) at https://www.oracle.com/java/technologies/downloads/#jdk17-windows

# Building and deployment
Builds are performed by Maven.
```
mvn compiler:compile
```
You can then run the application by calling:
```
mvn javafx:run
```
Deployment creates a .jar file containing all necessary JavaFX modules. It should hence be sufficient
to run the jar file without installing any additional libraries.
```
mvn package
```