package ru.vasilyev.restaurant.dataBaseConnection;

import ru.vasilyev.restaurant.util.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManagerImpl implements ConnectionManager {
    private static final String DRIVER_CLASS = "db.driver-class-name";
    private static final String URL = "db.url";
    private static final String PASSWORD = "db.password";
    private static final String USERNAME = "db.username";
    private static ConnectionManager connectionManager;

    public static synchronized ConnectionManager getInstance() {
        if (connectionManager == null) {
            loadDriver(PropertiesUtil.getProperties(DRIVER_CLASS));
            connectionManager = new ConnectionManagerImpl();
        }
        return connectionManager;
    }

    private static void loadDriver(String driveClass) {
        try {
            Class.forName(driveClass);
        } catch (Exception e) {
            throw new RuntimeException("loadDriver exception");
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                PropertiesUtil.getProperties(URL),
                PropertiesUtil.getProperties(USERNAME),
                PropertiesUtil.getProperties(PASSWORD)
        );
    }


}
