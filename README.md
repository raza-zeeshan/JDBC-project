# JDBC Project

## Description
This JDBC Project demonstrates how to interact with a database using Java Database Connectivity (JDBC). It serves as a fundamental reference for developers looking to integrate Java applications with various databases.

## Setup Instructions
1. **Prerequisites**: Make sure you have the following installed:
   - Java Development Kit (JDK) 8 or higher
   - An IDE such as Eclipse or IntelliJ IDEA
   - MySQL or any other database server (make sure to have the JDBC driver for your database)

2. **Clone the repository**:
   ```bash
   git clone https://github.com/raza-zeeshan/JDBC-project.git
   cd JDBC-project
   ```

3. **Configure Database Connection**:
   - Locate the `config.properties` file in the project root and update it with your database URL, username, and password.

4. **Add JDBC Driver**: Ensure the JDBC driver (e.g., MySQL Connector/J) is included in your project dependencies. If using Maven, add the following to your `pom.xml`:
   ```xml
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.26</version>
   </dependency>
   ```

5. **Compile and Run**:
   - Use your IDE to compile the project or run:
   ```bash
   mvn clean install
   java -cp target/JDBC-project-1.0-SNAPSHOT.jar com.example.Main
   ```

## Project Structure
```
JDBC-project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── Main.java
│   │   │       └── DatabaseHandler.java
│   │   └── resources/
│   │       └── config.properties
│   └── test/
└── pom.xml
```

## Features
- **Connection Management**: Establish and close connections with the database.
- **CRUD Operations**: Perform Create, Read, Update, and Delete operations on database tables.
- **Prepared Statements**: Use prepared statements to prevent SQL injection.
- **Connection Pooling**: Implements connection pooling for better performance.

## Usage Examples
1. **Connecting to the Database**:
   ```java
   DatabaseHandler dbHandler = new DatabaseHandler();
   Connection connection = dbHandler.connect();
   ```

2. **Executing a Query**:
   ```java
   String query = "INSERT INTO users (name, email) VALUES (?, ?);";
   dbHandler.executeUpdate(query, "John Doe", "john@example.com");
   ```

3. **Fetching Data**:
   ```java
   ResultSet resultSet = dbHandler.executeQuery("SELECT * FROM users;");
   while (resultSet.next()) {
       System.out.println(resultSet.getString("email"));
   }
   ```

## License
This project is licensed under the MIT License.