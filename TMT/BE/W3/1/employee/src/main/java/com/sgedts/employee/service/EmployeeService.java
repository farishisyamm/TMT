package com.sgedts.employee.service;

import com.sgedts.employee.bean.EmployeeListResponseBean;
import com.sgedts.employee.bean.EmployeeRequestBean;
import com.sgedts.employee.model.Employees;
import com.sgedts.employee.repository.EmployeesRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeeService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<EmployeeListResponseBean> getListEmployee(String param) {
        if (null == param) {
            param = Strings.EMPTY;
        }
        List<Employees> employees1 = employeesRepository.findAllByParam(param);
        return employees1.stream()
                .map(employees -> {
                    EmployeeListResponseBean responseBean = new EmployeeListResponseBean(
                            employees.getId(),
                            employees.getName(),
                            employees.getPosition(),
                            employees.getSalary()
                    );
                    System.out.println("Formatted Salary: " + responseBean.getFormattedSalary());
                    return responseBean;
                })
                .collect(Collectors.toList());

//        if (null == param || param.isEmpty()) {
//            return employees1;
//        }
//
//        return employees.stream()
//                .filter(employeeListResponseBean -> employeeListResponseBean.getName().equals(param))
//                .findAny()
//                .stream()
//                .toList();
    }

    public EmployeeListResponseBean getDetailEmployee(long id) throws Exception {
        Optional<Employees> employeesOptional = employeesRepository.findById(id);
        if (employeesOptional.isEmpty()) {
            throw new Exception("Data not found");
        }
        Employees employees = employeesOptional.get();
        System.out.println("Formatted Salary: " + employees.getFormattedSalary());
        return new EmployeeListResponseBean(employees.getId(), employees.getName(), employees.getPosition(), employees.getSalary());
    }

    public void addEmployee(EmployeeRequestBean requestBean) {
        Employees employees1 = new Employees();
        employees1.setName(requestBean.getName());
        employees1.setPosition(requestBean.getPosition());
        employees1.setSalary(requestBean.getSalary());
        employeesRepository.save(employees1);
    }

    //PUT (FULL)
    public void updateEmployee(Long id, EmployeeRequestBean requestBean) {
        Employees existingEmployee = employeesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        existingEmployee.setName(requestBean.getName());
        existingEmployee.setPosition(requestBean.getPosition());
        existingEmployee.setSalary(requestBean.getSalary());

        employeesRepository.save(existingEmployee);
    }

    //PATCH (PARTIALLY)
    public void updateEmployeePartially(Long id, EmployeeRequestBean requestBean) {
        Employees existingEmployee = employeesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        if (requestBean.getName() != null) {
            existingEmployee.setName(requestBean.getName());
        }
        if (requestBean.getPosition() != null) {
            existingEmployee.setPosition(requestBean.getPosition());
        }
        if (requestBean.getSalary() != null) {
            existingEmployee.setSalary(requestBean.getSalary());
        }

        employeesRepository.save(existingEmployee);
    }


    public void deleteEmployee(Long id) {
        Employees existingEmployee = employeesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employeesRepository.delete(existingEmployee);
    }
}
