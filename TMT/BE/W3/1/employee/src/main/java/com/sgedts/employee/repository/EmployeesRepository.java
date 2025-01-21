package com.sgedts.employee.repository;

import com.sgedts.employee.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    List<Employees> findAllByName(String param);

    @Query(nativeQuery = true, value = "SELECT * FROM {h-schema}employees WHERE :param = '' OR name LIKE CONCAT('%', :param, '%')")
    List<Employees> findAllByParam(String param);
}
