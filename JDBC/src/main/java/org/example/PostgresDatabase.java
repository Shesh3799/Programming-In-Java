package org.example;

import com.google.inject.Inject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import com.google.inject.name.Named;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Slf4j
public class PostgresDatabase implements Database{


    private static final String className = "org.postgresql.Driver";
    private static final String jdbcURL = "jdbc:postgresql";
    private static final String basicSqlQuery = "select * from pg_extension";

    private final String hostAddress;
    private final String port;
    private final String databaseName;
    private final String userName;
    private final String password;

    private Connection connection;

    @Inject
    public PostgresDatabase(
            @Named("PostgresHostAddress") String hostAddress,
            @Named("PostgresPortNumber") String port,
            @Named("PostgresDatabaseName") String databaseName,
            @Named("PostgresUserName") String userName,
            @Named("PostgresPassword") String password) {
        this.hostAddress = hostAddress;
        this.port = port;
        this.databaseName = databaseName;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean connect() {
        try{
            Class.forName(className);
            String connectionString = String.format("%s://%s:%s/%s",jdbcURL, hostAddress, port,databaseName);
            log.info("Attempting to connect to databse with connection string : {}",connectionString);
            connection = DriverManager.getConnection(connectionString,userName,password);
            return true;
        }
        catch (ClassNotFoundException e){
            log.error("Failed to load postgresSQL driver", e);
            return false;
        }
        catch (SQLException e){
            log.error("Failed to obtain connection", e);
            return false;
        }
    }

    @Override
    public void executeBasicCommand() {
        executeGenericCommand(basicSqlQuery, QueryType.SELECT);
    }

    @Override
    public void executeGenericCommand(@NonNull final String sqlCommand, QueryType queryType) {
        try {
            Statement statement = connection.createStatement();

            switch (queryType){

                case SELECT -> {
                    ResultSet resultSet = statement.executeQuery(sqlCommand);
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    log.info("SQL query returned {} columns", resultSetMetaData.getColumnCount());
                    StringBuilder result = new StringBuilder();
                    result.append("Select Query Result is: \n");
                    while (resultSet.next()) {
                        for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
                            result.append(resultSet.getString(i)).append(" | ");
                        }
                        result.append("\n");
                    }
                    log.info(result.toString());
                }
                case CREATE, INSERT, DELETE-> {
                    int result = statement.executeUpdate(sqlCommand);
                    log.info("{} : {}",queryType, result);
                }
                default -> throw new IllegalStateException("Unexpected value: " + queryType);
            }
            statement.close();
        } catch (SQLException e) {
            log.error("Query execution failed {}", sqlCommand);
            throw new RuntimeException(e);
        }
    }


    @Override
    public void executeCRUDOperations(){
        final String createTable = "CREATE TABLE student (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "age INT NOT NULL);";
        executeGenericCommand(createTable, QueryType.CREATE);

        List<String> names = List.of("Ram", "Ravi", "Sita");
        final String insertStudent = "INSERT INTO student (name, age) VALUES (?, ?);";

        try (PreparedStatement stmt = connection.prepareStatement(insertStudent)) {
            for (int i = 0; i < names.size(); i++) {
                // Set the name (String) as the first parameter
                stmt.setString(1, names.get(i));
                // Set the age (Integer) as the second parameter (i + 18)
                stmt.setInt(2, i + 18);

                // Execute the insert statement
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        final String selectQuery = "select * from student";

        executeGenericCommand(selectQuery, QueryType.SELECT);

        final String deleteQuery = "DROP TABLE IF EXISTS student";

        executeGenericCommand(deleteQuery, QueryType.DELETE);

    }

    @Override
    public void cleanup(){
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
