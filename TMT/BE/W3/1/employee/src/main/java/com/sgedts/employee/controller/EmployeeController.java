

package com.sgedts.employee.controller;

import com.sgedts.employee.bean.EmployeeListResponseBean;
import com.sgedts.employee.bean.EmployeeRequestBean;
import com.sgedts.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/api/employees")
    public ResponseEntity<List<EmployeeListResponseBean>> getListEmployees(@RequestParam(value = "keyword", required = false) String keyword) {
        return new ResponseEntity<>(employeeService.getListEmployee(keyword), HttpStatus.OK);
    }

    @GetMapping(value = "/api/employees/{id}")
    public ResponseEntity<EmployeeListResponseBean> getDetailEmployee(@PathVariable(value = "id") long id) throws Exception {
        return new ResponseEntity<>(employeeService.getDetailEmployee(id), HttpStatus.OK);
    }

    @PostMapping(value = "/api/employees")
    public ResponseEntity<Void> addEmployee(@RequestBody EmployeeRequestBean requestBean) {
        employeeService.addEmployee(requestBean);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/api/employees/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable(value = "id") long id, @RequestBody EmployeeRequestBean requestBean) {
        employeeService.updateEmployee(id, requestBean);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/api/employees/{id}")
    public ResponseEntity<Void> updateEmployeePartially(@PathVariable(value = "id") long id, @RequestBody EmployeeRequestBean requestBean) {
        employeeService.updateEmployeePartially(id, requestBean);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable (value = "id") long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
