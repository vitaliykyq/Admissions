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

import edu.coursework.admissions.model.Examination;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.model.Specialty;
import edu.coursework.admissions.service.examination.ExaminationServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import edu.coursework.admissions.service.specialty.SpecialtyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/specialties")
@Controller
public class SpecialtyUiController {

    @Autowired
    SpecialtyServiceImpl service;


    @Autowired
    ExaminationServiceImpl serviceExamination;

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Specialty> specialties = service.getAll();
        model.addAttribute("specialty",specialties);
        return "specialty/specialty-page";
    }

    @GetMapping("/showNewSpecialtyForm")
    public String showNewStadiumForm(Model model) {
        // create model attribute to bind form data
        Specialty specialty = new Specialty();
        model.addAttribute("specialty",specialty);
        List<Examination> examinations = serviceExamination.getAll();
        model.addAttribute("examination",examinations);

        return "specialty/new_specialty";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Specialty specialty = service.getById(id);
        model.addAttribute("specialty",specialty);
        List<Examination> examinations = serviceExamination.getAll();
        model.addAttribute("examination",examinations);

        return "specialty/update_specialty";
    }
    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("specialty") @RequestBody Specialty specialty) {
        service.update(specialty);
        return "redirect:/ui/specialties/get/all";
    }
    @PostMapping("/add")
    public String addTeacher(Model model, @ModelAttribute("specialty") @RequestBody Specialty specialty) {

            model.addAttribute("specialty",service.create(specialty));
            return "redirect:/ui/specialties/get/all";

    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.service.delete(id);
        return "redirect:/ui/specialties/get/all";
    }
}

