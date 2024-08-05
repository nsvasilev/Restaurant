package ru.vasilyev.restaurant.util;

import ru.vasilyev.restaurant.dataBaseConnection.ConnectionManager;
import ru.vasilyev.restaurant.exception.DataBaseStatementException;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;

public class SQLInit {
    private static final String SCHEME = "schema.sql";
    private static final String DATA = "data.sql";
    public static String schemeSQL;
    public static String dataSQL;

    static {
        loadInitSQL();
    }

    public SQLInit() {
    }

    public static void initScheme(ConnectionManager connectionManager) {
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(schemeSQL);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при инциализации scheme.sql");
        }
    }

    public static void initData(ConnectionManager connectionManager) {
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(dataSQL);
        } catch (Exception e) {
            throw new DataBaseStatementException("Ошибка при заполнении таблиц базы данных инициализационными данными."
                    + System.lineSeparator() + e.getMessage());
        }
    }

    private static void loadInitSQL() {
        try (InputStream inputStream = SQLInit.class.getClassLoader().getResourceAsStream(SCHEME)) {
            assert inputStream != null;
            schemeSQL = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        try (InputStream inputStream = SQLInit.class.getClassLoader().getResourceAsStream(DATA)) {
            assert inputStream != null;
            dataSQL = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalStateException();
        }

    }
}
