package lesson8;
//Задание 8 Синеокая Марина
import java.sql.*;

public class DatabaseRepositorySQLite {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
//пишем данные в базу
    public static void writeData(WeatherResponse weatherResponse, String city) {
        try {
            conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:lesson8.db");
            System.out.println("База Подключена!");
            statmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        try {
            statmt.execute("CREATE TABLE if not exists 'weather' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'city' text, 'localDate' text, 'weatherText' text, 'temperature' real);");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Таблица создана или уже существует.");
        for (int i = 0; i < weatherResponse.dailyForecasts.size(); i++) {
            String localDate = weatherResponse.dailyForecasts.get(i).date.toString();
            String weatherText = weatherResponse.dailyForecasts.get(i).day.value.toString();
            Double temperature = weatherResponse.dailyForecasts.get(i).temperature.minimum.value;

            try {
                statmt.execute("INSERT INTO 'weather' ('city', 'localDate', 'weatherText', 'temperature') VALUES ('" + city + "', '" + localDate + "', '" + weatherText + "', '" + temperature + "');");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //выводим данные из базы в консоль
    public static void printData(String city) {
        try {
            resSet = statmt.executeQuery("SELECT * FROM weather");
            while(resSet.next()) {
                String city2 = resSet.getString("city");
                String localDate2 = resSet.getString("localDate");
                String weatherText2 = resSet.getString("weatherText");
                String temperature2 = resSet.getString("temperature");
                System.out.println("В городе " + city2 + " на дату " + localDate2 + " ожидается " + weatherText2 + ", температура: " + temperature2 + "C");
            }
            statmt.executeUpdate("DROP TABLE weather"); //удаляем базу
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

    }




