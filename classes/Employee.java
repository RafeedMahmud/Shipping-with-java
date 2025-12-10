package model;

public class Employee extends Person {

    private String username;
    private String password;

    public Employee() {
    }

    public Employee(int id, String name, String username, String password) {
        super(id, name);
        this.username = username;
        this.password = password;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Employee");
    }

    // Getters & Setters
    public String getUsername() {
        return username;
    }
}
