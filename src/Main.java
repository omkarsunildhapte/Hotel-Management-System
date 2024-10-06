import db.DatabaseConnection;
import view.LandingPage;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.createdDatabase();
        DatabaseConnection.getConnection();
        DatabaseConnection.createUsersTable();
        DatabaseConnection.createHotelsTable();
        new LandingPage();
    }
}
