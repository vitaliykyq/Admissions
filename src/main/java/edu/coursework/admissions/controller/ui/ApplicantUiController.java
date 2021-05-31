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

import edu.coursework.admissions.model.Applicant;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.service.applicant.ApplicantServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/applicants")
@Controller
public class ApplicantUiController {

    @Autowired
    ApplicantServiceImpl service;



    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Applicant> applicants = service.getAll();
        model.addAttribute("applicant",applicants);
        return "applicant/applicant-page";
    }

    @GetMapping("/showNewApplicantForm")
    public String showNewApplicantForm(Model model) {
        // create model attribute to bind form data
        Applicant applicant = new Applicant();
        model.addAttribute("applicant",applicant);

        return "applicant/new_applicant";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Applicant applicant = service.getById(id);
        model.addAttribute("applicant",applicant);

        return "applicant/update_applicant";
    }
    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("applicant") @RequestBody Applicant applicant) {
        service.update(applicant);
        return "redirect:/ui/applicants/get/all";
    }
    @PostMapping("/add")
    public String addTeacher(Model model, @ModelAttribute("applicant") @RequestBody Applicant applicant) {

            model.addAttribute("applicant",service.create(applicant));
            return "redirect:/ui/applicants/get/all";

    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.service.delete(id);
        return "redirect:/ui/persons/get/all";
    }
}

