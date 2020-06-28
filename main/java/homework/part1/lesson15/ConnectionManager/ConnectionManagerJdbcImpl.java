package homework.part1.lesson15.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJdbcImpl implements  ConnectionManager{
    public static final ConnectionManager INSTANCE = new ConnectionManagerJdbcImpl();

    private ConnectionManagerJdbcImpl() {
    }

    public static ConnectionManager getInstance() {
        return INSTANCE;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Testing",
                    "postgres",
                    "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
