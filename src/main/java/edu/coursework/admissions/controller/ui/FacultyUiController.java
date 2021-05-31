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

import edu.coursework.admissions.model.*;
import edu.coursework.admissions.service.department.DepartmentServiceImpl;
import edu.coursework.admissions.service.documents.DocumentsServiceImpl;
import edu.coursework.admissions.service.examination.ExaminationServiceImpl;
import edu.coursework.admissions.service.faculty.FacultyServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import edu.coursework.admissions.service.specialty.SpecialtyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/faculties")
@Controller
public class FacultyUiController {

    @Autowired
    FacultyServiceImpl service;
    @Autowired
    ExaminationServiceImpl serviceExamination;
    @Autowired
    DepartmentServiceImpl serviceDepartment;



    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Faculty> faculties = service.getAll();
        model.addAttribute("faculty",faculties);
        return "person/person-page";
    }

    @GetMapping("/showNewFacultyForm")
    public String showNewFacultyForm(Model model) {
        // create model attribute to bind form data
        Faculty faculty = new Faculty();
        model.addAttribute("faculty",faculty);
        List<Examination> examinations = serviceExamination.getAll();
        model.addAttribute("examination",examinations);
        List<Department> departments = serviceDepartment.getAll();
        model.addAttribute("department",departments);
        return "faculty/new_faculty";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Faculty faculty = service.getById(id);
        model.addAttribute("faculty",faculty);
        List<Examination> examinations = serviceExamination.getAll();
        model.addAttribute("examination",examinations);
        List<Department> departments = serviceDepartment.getAll();
        model.addAttribute("department",departments);
        return "faculty/update_faculty";
    }
    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("faculty") @RequestBody Faculty faculty) {
        service.update(faculty);
        return "redirect:/ui/faculties/get/all";
    }
    @PostMapping("/add")
    public String addTeacher(Model model, @ModelAttribute("faculty") @RequestBody Faculty faculty) {

            model.addAttribute("persons",service.create(faculty));
            return "redirect:/ui/faculties/get/all";

    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.service.delete(id);
        return "redirect:/ui/faculties/get/all";
    }
}

