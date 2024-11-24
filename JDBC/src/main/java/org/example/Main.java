package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new AppModule());

        Database database = injector.getInstance(Database.class);

        if(!database.connect())
            throw new RuntimeException("Database connection failed");

        database.executeBasicCommand();
        database.executeCRUDOperations();
    }
}