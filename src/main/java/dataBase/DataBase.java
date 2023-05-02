package dataBase;

import dataBase.exceptions.DataBaseException;
import dataBase.exceptions.PropertiesNotFoundException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBase {
    private static Connection connection;

    private static Properties loadProperties(){
        try {
            FileInputStream fileInputStream = new FileInputStream("DataBase.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        }
        catch (FileNotFoundException e) {
            throw new PropertiesNotFoundException(e.getMessage() + "Não foi possível encontrar o arquivo DataBase.properties");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties properties = loadProperties();
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String dataBaseUrl = properties.getProperty("databaseurl");
            connection = DriverManager.getConnection(dataBaseUrl, user, password);
        } catch (SQLException e) {
            throw new DataBaseException("Não foi possível se conectar ao banco de dados");
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DataBaseException("Não foi possível encerrar a conexão com o banco de dados corretamente");
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DataBaseException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new DataBaseException(e.getMessage());
            }
        }
    }
}
