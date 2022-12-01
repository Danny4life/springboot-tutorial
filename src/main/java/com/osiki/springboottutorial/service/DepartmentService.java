package com.osiki.springboottutorial.service;

import com.osiki.springboottutorial.entity.Department;

import java.util.List;

public interface DepartmentService {

    // save department to database
   public Department saveDepartment(Department department);

   // get all department from database
  public  List<Department> fetchDepartmentList();

  // get department by id
   public  Department fetchDepartmentById(Long departmentId);

   // delete department by id
    public void deleteDepartmentId(Long departmentId);

    // update department
   public Department updateDepartment(Long departmentId, Department department);

   // get department by name
   public Department fetchDepartmentByName(String departmentName);
}
