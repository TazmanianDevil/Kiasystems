package ru.kiasystems.model.database;

import ru.kiasystems.logic.beans.impl.ThemeEJB;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@DataSourceDefinition(
        className="com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
        name = "java:global/jdbc/KiaTest",
        user = "root",
        password = "rootpass",
        databaseName = "kiasystems_test",
        serverName = "localhost",
        portNumber = 3306,
        properties = {"connectionAttributes=;create=true"})

public class DatabasePopulator {

}

