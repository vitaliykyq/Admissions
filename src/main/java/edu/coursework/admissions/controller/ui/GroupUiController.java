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
import edu.coursework.admissions.model.Examination;
import edu.coursework.admissions.model.Group;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.service.applicant.ApplicantServiceImpl;
import edu.coursework.admissions.service.examination.ExaminationServiceImpl;
import edu.coursework.admissions.service.group.GroupServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/groups")
@Controller
public class GroupUiController {

    @Autowired
    GroupServiceImpl service;

    @Autowired
    ExaminationServiceImpl serviceExamination;
    @Autowired
    ApplicantServiceImpl serviceApplicant;

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Group> groups = service.getAll();
        model.addAttribute("group",groups);
        return "group/group-page";
    }

    @GetMapping("/showNewGroupForm")
    public String showNewStadiumForm(Model model) {
        // create model attribute to bind form data
        Group group = new Group();
        model.addAttribute("group",group);
        List<Examination> examinations = serviceExamination.getAll();
        model.addAttribute("examination",examinations);
        List<Applicant> applicants = serviceApplicant.getAll();
        model.addAttribute("applicant",applicants);
        return "group/new_group";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Group group = service.getById(id);
        model.addAttribute("group",group);
        List<Examination> examinations = serviceExamination.getAll();
        model.addAttribute("examination",examinations);
        List<Applicant> applicants = serviceApplicant.getAll();
        model.addAttribute("applicant",applicants);
        return "group/update_group";
    }
    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("group") @RequestBody Group group) {
        service.update(group);
        return "redirect:/ui/groups/get/all";
    }
    @PostMapping("/add")
    public String addTeacher(Model model, @ModelAttribute("group") @RequestBody Group group) {

            model.addAttribute("group",service.create(group));
            return "redirect:/ui/groups/get/all";

    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.service.delete(id);
        return "redirect:/ui/groups/get/all";
    }
}

