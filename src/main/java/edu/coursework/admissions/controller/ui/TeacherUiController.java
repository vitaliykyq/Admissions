package edu.coursework.admissions.controller.ui;

import edu.coursework.admissions.model.Examination;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.model.Teacher;
import edu.coursework.admissions.service.examination.ExaminationServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import edu.coursework.admissions.service.teacher.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/teachers")
@Controller
public class TeacherUiController {

    @Autowired
    TeacherServiceImpl service;

    @Autowired
    PersonServiceImpl servicePerson;

    @Autowired
    ExaminationServiceImpl serviceExamination;

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Teacher> teachers = service.getAll();
        model.addAttribute("teachers",teachers);
        return "teacher/teacher-page";
    }

    @GetMapping("/showNewTeacherForm")
    public String showNewTeacherForm(Model model) {
        // create model attribute to bind form data
        Teacher teacher = new Teacher();
        model.addAttribute("teacher",teacher);
        List<Person> personIdList = servicePerson.getAll();
        model.addAttribute("personIdList", personIdList);
        List<Examination> examinationIdList = serviceExamination.getAll();
        model.addAttribute("examinationIdList", examinationIdList);
        return "teacher/new_teacher";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value="id") String id, Model model){
        Teacher teacher = service.getById(id);
        model.addAttribute("teacher",teacher);
        List<Person> personIdList = servicePerson.getAll();
        model.addAttribute("personIdList", personIdList);
        List<Examination> examinations = serviceExamination.getAll();
        model.addAttribute("examinations",examinations);
        return "teacher/update_teacher";
    }
    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("teacher") @RequestBody Teacher teacher) {
        service.update(teacher);
        return "redirect:/ui/teachers/get/all";
    }
    @PostMapping("/add")
    public String addTeacher(Model model, @ModelAttribute("teacher") @RequestBody Teacher teacher) {
        teacher.setPerson(servicePerson.getById(teacher.getPerson().getId()));
        model.addAttribute("teacher",service.create(teacher));
        return "redirect:/ui/teachers/get/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.service.delete(id);
        return "redirect:/ui/teachers/get/all";
    }
}
