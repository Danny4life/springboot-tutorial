package com.osiki.springboottutorial.service;

import com.osiki.springboottutorial.entity.Department;
import com.osiki.springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    // save department to database
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }


    // get all department from database
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }


    //get department by id
    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    // delete department by id
    @Override
    public void deleteDepartmentId(Long departmentId) {
        departmentRepository.deleteById(departmentId);

    }

    //update department
    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        // get dept from db

        Department depDb = departmentRepository.findById(departmentId).get();

        // check if other fields are null then skip it
        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(depDb);
    }

    // get department by name

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
