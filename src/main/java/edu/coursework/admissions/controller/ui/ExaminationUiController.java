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
import edu.coursework.admissions.service.teacher.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/examinations")
@Controller
public class ExaminationUiController {

    @Autowired
    ExaminationServiceImpl service;
    @Autowired
    SpecialtyServiceImpl serviceSpecialty;


    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Examination> examinations = service.getAll();
        model.addAttribute("examination",examinations);
        return "examination/examination-page";
    }

    @GetMapping("/showNewPersonForm")
    public String showNewStadiumForm(Model model) {
        // create model attribute to bind form data
        Examination examination = new Examination();
        model.addAttribute("examination",examination);
        List<Specialty> specialties = serviceSpecialty.getAll();
        model.addAttribute("specialty",specialties);

        return "examination/new_examination";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Examination examination = service.getById(id);
        model.addAttribute("examination",examination);
        List<Specialty> specialties = serviceSpecialty.getAll();
        model.addAttribute("specialty",specialties);

        return "examination/update_examination";
    }
    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("examination") @RequestBody Examination examination) {
        service.update(examination);
        return "redirect:/ui/examinations/get/all";
    }
    @PostMapping("/add")
    public String addTeacher(Model model, @ModelAttribute("examination") @RequestBody Examination examination) {

            model.addAttribute("examination",service.create(examination));
            return "redirect:/ui/examinations/get/all";

    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.service.delete(id);
        return "redirect:/ui/examinations/get/all";
    }
}

