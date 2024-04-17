import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection {
    public static final String URL = "jdbc:mysql://localhost:3306/musical_instruments";
    public static final String USER = "nicholas";
    public static final String PASS = "zipcode(0)";

    public static java.sql.Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Error Connecting to database", e);
        }
    }

    public static void main(String[] args) {
    }
}
