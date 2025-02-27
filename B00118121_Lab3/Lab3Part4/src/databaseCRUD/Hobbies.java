package databaseCRUD;
import java.sql.*;

public class Hobbies {
    public static String JDBC_URL = "jdbc:mysql://localhost:3306/hobbies";
    public static String USERNAME = "root";
    public static String PASSWORD = "JmysqlG252";

    public static void main(String[] args) {
        createTable();
        addDatatoTable();
        readDataFromTable();
        deleteRecordFromTable();
    }

    public static void createTable() { //Method that creates a table if the table doesn't exist
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS student(id INT PRIMARY KEY, name VARCHAR(255))";
            statement.executeUpdate(createTableQuery);
            System.out.println("Table created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void addDatatoTable() { //Method that adds data to the table
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student Values (? , ?)")) {
            preparedStatement.setInt(1, 7);
            preparedStatement.setString(2, "Football");
            preparedStatement.executeUpdate();
            preparedStatement.setInt(1, 11);
            preparedStatement.setString(2, "Formula1");
            preparedStatement.executeUpdate();
            System.out.println("Data added to table!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//? are placeholders to put the values in later because the SQL statement is being prepared for statement

    private static void readDataFromTable() { //Method that reads the data from the table
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Hobbies")) {
            System.out.println("Reading data from the table");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteRecordFromTable() { //Method that deletes the record
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id = ?")) {
            preparedStatement.setInt(1, 1);
            preparedStatement.executeUpdate();
            System.out.println("Record deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



















