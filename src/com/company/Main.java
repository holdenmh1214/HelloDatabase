package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");

        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS players (names VARCHAR, health DOUBLE, score INT, is_alive BOOLEAN)");
        stmt.execute("INSERT INTO players VALUES('Alice', 100, 10, true)");
        stmt.execute("INSERT INTO players VALUES('Bob', 90, 10, true)");
        stmt.execute("UPDATE players SET health = 50 WHERE names = 'Alice'");
        stmt.execute("DELETE FROM players WHERE names='Bob'");

        ResultSet results = stmt.executeQuery("SELECT * FROM players");

        while (results.next()) {
            String name = results.getString("names");
            double health = results.getDouble("health");
            int score = results.getInt("score");
            boolean isAlive = results.getBoolean("is_Alive");

            System.out.println(String.format("%s, %s, %s, %s", name, health, score, isAlive));

        }

        stmt.execute("DROP TABLE players");

        conn.close();
    }
}
