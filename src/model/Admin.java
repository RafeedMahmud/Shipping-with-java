package model;

public class Admin extends Employee {

    public Admin() {
    }

    public Admin(int id, String name, String username, String password) {
        super(id, name, username, password);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Admin");
    }
}
