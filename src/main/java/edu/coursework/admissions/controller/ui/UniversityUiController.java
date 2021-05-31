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

import edu.coursework.admissions.model.Faculty;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.model.Specialty;
import edu.coursework.admissions.model.University;
import edu.coursework.admissions.service.faculty.FacultyServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import edu.coursework.admissions.service.specialty.SpecialtyServiceImpl;
import edu.coursework.admissions.service.university.UniversityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/universities")
@Controller
public class UniversityUiController {

    @Autowired
    UniversityServiceImpl service;

    @Autowired
    SpecialtyServiceImpl serviceSpecialty;

    @Autowired
    FacultyServiceImpl serviceFaculty;
    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<University> universities = service.getAll();
        model.addAttribute("university",universities);
        return "university/university-page";
    }

    @GetMapping("/showNewPersonForm")
    public String showNewStadiumForm(Model model) {
        // create model attribute to bind form data
        University university = new University();
        model.addAttribute("university",university);
        List<Specialty> specialties = serviceSpecialty.getAll();
        model.addAttribute("specialty",specialties);
        List<Faculty> faculties = serviceFaculty.getAll();
        model.addAttribute("faculty",faculties);

        return "university/new_university";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        University university = service.getById(id);
        model.addAttribute("university",university);
        List<Specialty> specialties = serviceSpecialty.getAll();
        model.addAttribute("specialty",specialties);
        List<Faculty> faculties = serviceFaculty.getAll();
        model.addAttribute("faculty",faculties);
        return "university/update_university";
    }
    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("university") @RequestBody University university) {
        service.update(university);
        return "redirect:/ui/universities/get/all";
    }
    @PostMapping("/add")
    public String addTeacher(Model model, @ModelAttribute("university") @RequestBody University university) {

            model.addAttribute("university",service.create(university));
            return "redirect:/ui/universities/get/all";

    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.service.delete(id);
        return "redirect:/ui/universities/get/all";
    }
}

