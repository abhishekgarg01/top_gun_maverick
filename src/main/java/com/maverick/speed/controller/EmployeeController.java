package com.maverick.speed.controller;

import com.maverick.speed.model.Employee;
import com.maverick.speed.service.EmployeeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee employeeSavedToDB = this.employeeService.addEmployee(employee);
        List<Employee> employeeList = employeeService.viewEmployee();
        employeeService.viewEmployee();
        return new ResponseEntity<Employee>(employeeSavedToDB, HttpStatus.CREATED);
    }

    @PostMapping("/add1")
    public ResponseEntity<Employee> saveEmployee1(@RequestBody Employee employee) {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();
        Session session1 = sessionFactory.openSession();
        Employee employeeSavedToDB = this.employeeService.addEmployee(employee);
        Employee emp = (Employee) session.get(Employee.class, new Integer(1));
        Employee emp1 = (Employee) session.get(Employee.class, new Integer(1));

        System.out.println("printing from emp : " + emp.getName());
        System.out.println("printing from emp1 : " + emp1.getName());

        Employee emp2 = (Employee) session1.get(Employee.class, new Integer(1));
        System.out.println("printing from emp2 : " + emp2.getName());
        session1.close();
        session.close();
        sessionFactory.close();
        //List<Employee> employeeList = employeeService.viewEmployee();
        //employeeService.viewEmployee();
        return new ResponseEntity<Employee>(employeeSavedToDB, HttpStatus.CREATED);
    }



}
