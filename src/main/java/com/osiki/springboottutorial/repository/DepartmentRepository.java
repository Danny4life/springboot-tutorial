package com.osiki.springboottutorial.repository;

import com.osiki.springboottutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // create our own repository
    public Department findByDepartmentName(String departmentName);

    // to ignore case letter
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
