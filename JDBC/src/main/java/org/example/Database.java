package org.example;

import java.sql.SQLException;

public interface Database {
    public boolean connect();
    public void executeBasicCommand();

    public void executeGenericCommand(String sqlCommand, QueryType queryType);

    public void executeCRUDOperations();

    public void cleanup();
}
