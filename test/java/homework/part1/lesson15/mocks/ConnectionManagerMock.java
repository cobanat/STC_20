package homework.part1.lesson15.mocks;

import homework.part1.lesson15.ConnectionManager.ConnectionManager;

import java.sql.Connection;

public class ConnectionManagerMock implements ConnectionManager {
    @Override
    public Connection getConnection(){
        return new ConnectionMock();
    }
}
