package com.company.employee.controller;

import com.company.employee.model.Employee;
import com.company.employee.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class EmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String dept = req.getParameter("department");

            Employee emp = new Employee(id, name, dept);
            EmployeeService service = new EmployeeService();
            service.addEmployee(emp);

            resp.getWriter().write("Employee Added Successfully");

        } catch (Exception e) {
            resp.getWriter().write("Error: " + e.getMessage());
        }
    }
}
