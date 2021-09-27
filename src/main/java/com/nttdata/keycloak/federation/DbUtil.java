package com.nttdata.keycloak.federation;

import lombok.extern.jbosslog.JBossLog;
import org.keycloak.component.ComponentModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@JBossLog
public class DbUtil {

    public static Connection getConnection(ComponentModel config) throws SQLException{
        String jdbcURL = String.format("jdbc:mysql://%s:%s/%s", config.get(Constants.CONFIG_KEY_DB_HOST), config.get(Constants.CONFIG_KEY_DB_PORT), config.get(Constants.CONFIG_KEY_DB_NAME));
        log.info("connecting to JDBC url: " + jdbcURL);
        return DriverManager.getConnection(jdbcURL,
          config.get(Constants.CONFIG_KEY_DB_USERNAME),
          config.get(Constants.CONFIG_KEY_DB_PASSWORD));
    }
}
