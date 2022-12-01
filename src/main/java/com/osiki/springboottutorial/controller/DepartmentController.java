package com.osiki.springboottutorial.controller;

import com.osiki.springboottutorial.entity.Department;
import com.osiki.springboottutorial.service.DepartmentService;
import com.osiki.springboottutorial.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // save department to database
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        return departmentService.saveDepartment(department);

    }

    // get all department from database
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){

        return departmentService.fetchDepartmentList();

    }

    // Fetching department by ID
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){

        return departmentService.fetchDepartmentById(departmentId);

    }

    // delete department by id api

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentId(departmentId);
        return "Department deleted successfully";

    }

    // update department
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    // fetch department by name
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);

    }
}
