package com.derily.ch4.db.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class DatabaseConnectionFactory {
    private static DatabaseConnectionFactory conFactory=new DatabaseConnectionFactory();
    private DataSource dataSource=null;
    private DatabaseConnectionFactory(){}

    public synchronized void init() throws IOException{
        if(dataSource!=null)
            return;
        InputStream inStream=this.getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties dbProperties=new Properties();
        dbProperties.load(inStream);
        inStream.close();

        PoolProperties p=new PoolProperties();
        p.setUrl("jdbc:mysql://"+dbProperties.getProperty("db_host")+
                ""+dbProperties.getProperty("db_port")+"/"+
                dbProperties.getProperty("db_name"));
        p.setDriverClassName(dbProperties.getProperty("db_driver_class_name"));
        p.setUsername(dbProperties.getProperty("db_user_name"));
        p.setPassword(dbProperties.getProperty("db_password"));
        p.setMaxActive(10);
        dataSource=new DataSource();
        dataSource.setPoolProperties(p);
    }

    public static DatabaseConnectionFactory getConnectionFactory(){
        return conFactory;
    }

    public Connection getConnection() throws SQLException{
        if(dataSource==null){
            throw new SQLException("");
        }
        return dataSource.getConnection();
    }
}
