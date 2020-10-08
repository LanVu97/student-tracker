/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author default
 */
public class MySqlClient {

    private static HikariDataSource ds;
    private static final String userName = "webstudent";
    private static final String password = "Hoanglan.vu97";
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/student-tracker";

    private MySqlClient() {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(userName);
        config.setPassword(password);
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setMaximumPoolSize(3);

        ds = new HikariDataSource(config);
    }
    public static MySqlClient Instance = new MySqlClient();

    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        int maximumPoolSize = Instance.ds.getMaximumPoolSize();
        System.out.println("max pool size: " + maximumPoolSize);
    }

}
