package com.company.employee.service;

import com.company.employee.model.Employee;
import com.company.employee.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeService {

    public void addEmployee(Employee emp) throws Exception {
        Connection conn = DBConnection.getConnection();

        String query = "INSERT INTO employee (id, name, department) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, emp.getId());
        ps.setString(2, emp.getName());
        ps.setString(3, emp.getDepartment());

        ps.executeUpdate();
        conn.close();
    }
}
