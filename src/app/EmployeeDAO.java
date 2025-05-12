package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(String name, int age, String position, float salary) throws SQLException {
        String sql = "INSERT INTO employees (name, age, position, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, position);
            stmt.setFloat(4, salary);
            stmt.executeUpdate();
        }
    }

    public void updateEmployee(int id, String name, int age, String position, float salary) throws SQLException {
        String sql = "UPDATE employees SET name=?, age=?, position=?, salary=? WHERE id=?";
        try (Connection conn = DatabaseConnector.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, position);
            stmt.setFloat(4, salary);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DatabaseConnector.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<String> getAllEmployees() throws SQLException {
        List<String> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = DatabaseConnector.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String row = rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("position") + " | " +
                        rs.getFloat("salary");
                list.add(row);
            }
        }
        return list;
    }
}
