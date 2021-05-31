/*
 * *
 *  * Created by IntelliJ IDEA.
 *  * edu.coursework.sportinfrastructure.controller.ui.StadiumUiController
 *  *
 *  * @Autor: SoniaKK
 *  * @DateTime: 05.04.21, 21:50
 *  * @Version StadiumUiController.java : 1.0
 *
 */

package edu.coursework.admissions.controller.ui;

import edu.coursework.admissions.model.Department;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.model.Specialty;
import edu.coursework.admissions.service.department.DepartmentServiceImpl;
import edu.coursework.admissions.service.documents.DocumentsServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import edu.coursework.admissions.service.specialty.SpecialtyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/departments")
@Controller
public class DepartmentUiController {

    @Autowired
    DepartmentServiceImpl service;
    @Autowired
    SpecialtyServiceImpl serviceSpecialty;


    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Department> departments = service.getAll();
        model.addAttribute("department",departments);
        return "department/department-page";
    }

    @GetMapping("/showNewDepartmentForm")
    public String showNewDepartmentForm(Model model) {
        // create model attribute to bind form data
        Department department = new Department();
        model.addAttribute("department",department);
        List<Specialty> specialties = serviceSpecialty.getAll();
        model.addAttribute("specialty",specialties);
        return "department/new_department";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Department department = service.getById(id);
        model.addAttribute("department",department);
        List<Specialty> specialties = serviceSpecialty.getAll();
        model.addAttribute("specialty",specialties);
        return "department/update_department";
    }
    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("department") @RequestBody Department department) {
        service.update(department);
        return "redirect:/ui/departments/get/all";
    }
    @PostMapping("/add")
    public String addDepartment(Model model, @ModelAttribute("department") @RequestBody Department department) {

            model.addAttribute("department",service.create(department));
            return "redirect:/ui/departments/get/all";

    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.service.delete(id);
        return "redirect:/ui/departments/get/all";
    }
}

