package app;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        try {
            dao.addEmployee("John Miller", 31, "Developer", 1800.50f);
            dao.addEmployee("Emily Johnson", 40, "Manager", 2200.00f);
            dao.updateEmployee(1, "John Miller", 32, "Senior Developer", 2500.75f);
            dao.deleteEmployee(2);
            List<String> employees = dao.getAllEmployees();
            for (String emp : employees) {
                System.out.println(emp);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
