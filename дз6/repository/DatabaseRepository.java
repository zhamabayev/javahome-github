package repository;

import entity.WeatherData;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;

public interface DatabaseRepository {

    boolean saveWeatherData(WeatherData weatherData) throws SQLException;

    List<WeatherData> getAllSavedData() throws IOException, SQLException;

    void closeConnection();
}
