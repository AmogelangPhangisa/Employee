/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.VisionZar.employeeManagement.config;

import com.zaxxer.hikari.HikariDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author S2028873
 */
public class DataSourceUtility {
public static DataSource getDatasource() {
     HikariDataSource dataSource = new HikariDataSource();
        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(5);
        dataSource.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
        dataSource.addDataSourceProperty("url", "jdbc:sqlserver://LPTAYA61:2010;databaseName=employeeDB");
        dataSource.addDataSourceProperty("user", "amogelang");
        dataSource.addDataSourceProperty("password", "amogelang");

        return dataSource;
    }

    public static DataSource getDatasourceLookup() {
        try {
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:/employeeDS");
            return dataSource;
        } catch (NamingException ex) {
            Logger.getLogger(DataSourceUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    }


