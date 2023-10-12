package com.maverick.speed.service;

import com.maverick.speed.model.Address;
import com.maverick.speed.model.Employee;
import com.maverick.speed.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressService addressService;

    public Employee addEmployee(Employee employee) {
        Employee savedEmployee =   employeeRepository.save(employee);
        Address address = new Address();
        address.setAddress("Varanasi");
        address.setEmployee(employee);

        addressService.addAddress(address);

        return savedEmployee;
    }

    public List<Employee> viewEmployee() {
        return employeeRepository.findAll();
    }
}
