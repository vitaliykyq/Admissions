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
import edu.coursework.admissions.model.Teacher;
import edu.coursework.admissions.service.examination.ExaminationServiceImpl;
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
    TeacherServiceImpl teacherService;

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Examination> examinations = service.getAll();
        model.addAttribute("examination",examinations);
        return "examination/examination-page";
    }

    @GetMapping("/showNewExaminationForm")
    public String showNewExaminationForm(Model model) {
        // create model attribute to bind form data
        Examination examination = new Examination();
        model.addAttribute("examination",examination);
        List<Teacher> teacherIdList = teacherService.getAll();
        model.addAttribute("teacherIdList",teacherIdList);

        return "examination/new_examination";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Examination examination = service.getById(id);
        model.addAttribute("examination",examination);

        List<Teacher> teacherIdList = teacherService.getAll();
        model.addAttribute("teacherIdList",teacherIdList);

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

