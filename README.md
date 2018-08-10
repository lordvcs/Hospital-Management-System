# Hospital-Management-System-
Hospital Management System in java

## Screenshot

## Installation
1. Clone or download zip from github repository
2. Install MySQL Connector/J [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/3.1.html). On Ubuntu/linux install MySQL connector by `apt-get install libmysql-java` and then add the path of `.jar` file to `CLASSPATH`. On Ubuntu/linux add the following to bashrc to add location of `.jar` file to `CLASSPATH` `export CLASSPATH=".:/usr/share/java/mysql.jar"`
3. Create database named `hms` and table `users` with columns `username`, `password`, table `doctors` with columns `DocName`, `Specialisation`, `Address`, `Pnumber`, table `Patients` with columns `Pname`, `Address`, `Pnumber`, `Age`, `Sex`, `Illness` and table `contactus` with columns `email`, `comments`
4. Navigate to the project folder and `javac HomePage.java` to compile and `java HomePage` to run the program
