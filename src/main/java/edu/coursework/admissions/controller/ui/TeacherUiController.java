package edu.coursework.admissions.controller.ui;

import edu.coursework.admissions.model.Person;
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

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Person> persons = service.getAll();
        model.addAttribute("person",persons);
        return "person/person-page";
    }

    @GetMapping("/showNewPersonForm")
    public String showNewStadiumForm(Model model) {
        // create model attribute to bind form data
        Person person = new Person();
        model.addAttribute("person",person);

        return "person/new_person";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value="id") String id, Model model){
        Person person = service.getById(id);
        model.addAttribute("person",person);

        return "person/update_person";
    }
    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("persons") @RequestBody Person person) {
        service.update(person);
        return "redirect:/ui/persons/get/all";
    }
    @PostMapping("/add")
    public String addStadium(Model model, @ModelAttribute("persons") @RequestBody Person person) {

        model.addAttribute("persons",service.create(person));
        return "redirect:/ui/persons/get/all";

    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.service.delete(id);
        return "redirect:/ui/persons/get/all";
    }
}
