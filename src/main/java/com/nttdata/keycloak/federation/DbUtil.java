package com.nttdata.keycloak.federation;

import org.keycloak.component.ComponentModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    public static Connection getConnection(ComponentModel config) throws SQLException{
        Integer port = Integer.parseInt(config.get(Constants.CONFIG_KEY_DB_PORT));
        String jdbcURL = String.format("jdbc:mysql://%s:%d/%s", config.get(Constants.CONFIG_KEY_DB_HOST), port, config.get(Constants.CONFIG_KEY_DB_NAME));
        return DriverManager.getConnection(jdbcURL,
          config.get(Constants.CONFIG_KEY_DB_USERNAME),
          config.get(Constants.CONFIG_KEY_DB_PASSWORD));
    }
}
