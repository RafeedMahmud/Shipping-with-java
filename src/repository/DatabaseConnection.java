package repository;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // private constructor
        System.out.println("DatabaseConnection created (Singleton)");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
