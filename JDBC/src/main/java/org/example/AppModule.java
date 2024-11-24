package org.example;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Database.class).to(PostgresDatabase.class).in(Singleton.class);
        bind(String.class).annotatedWith(Names.named("PostgresHostAddress")).toInstance("localhost");
        bind(String.class).annotatedWith(Names.named("PostgresPortNumber")).toInstance("5432");
        bind(String.class).annotatedWith(Names.named("PostgresDatabaseName")).toInstance("postgres");
        bind(String.class).annotatedWith(Names.named("PostgresUserName")).toInstance("shesh");
        bind(String.class).annotatedWith(Names.named("PostgresPassword")).toInstance("");
    }
}
