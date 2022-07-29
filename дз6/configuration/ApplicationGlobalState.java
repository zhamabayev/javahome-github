package configuration;
import java.sql.*;

public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    private final String API_KEY = "Gnzd4iXgN7I0eLkYlT7P2Jd83ytnz09x";
    private String daily = "daily";
    private final String DB_FILENAME = "application.db";

    private ApplicationGlobalState () {
    }

    public static ApplicationGlobalState getInstance () {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }
        return INSTANCE;
    }

    public String getDbFileName() {
        return DB_FILENAME;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getAPI_KEY () {
        return API_KEY;
    }

    public String getDaily() {
        return daily;
    }
}
