package io.minimvc.dao;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("H2_URL_TCP");
        String user = dotenv.get("H2_USER");
        String pass = dotenv.get("H2_PASS");

        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
