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
import edu.coursework.admissions.service.certificate.CertificateServiceImpl;
import edu.coursework.admissions.service.documents.DocumentsServiceImpl;
import edu.coursework.admissions.service.examination.ExaminationServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import edu.coursework.admissions.service.specialty.SpecialtyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/certificates")
@Controller
public class CertificateUiController {

    @Autowired
    CertificateServiceImpl service;


    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Certificate> certificates = service.getAll();
        model.addAttribute("certificate",certificates);
        return "certificate/certificate-page";
    }

    @GetMapping("/showNewCertificatesForm")
    public String showNewCertificatesForm(Model model) {
        // create model attribute to bind form data
        Certificate certificate = new Certificate();
        model.addAttribute("certificate",certificate);
        return "certificate/new_certificate";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Certificate certificate = service.getById(id);
        model.addAttribute("certificate",certificate);
        return "person/update_person";
    }
    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("certificate") @RequestBody Certificate certificate) {
        service.update(certificate);
        return "redirect:/ui/certificates/get/all";
    }
    @PostMapping("/add")
    public String addTeacher(Model model, @ModelAttribute("certificate") @RequestBody Certificate certificate) {

            model.addAttribute("persons",service.create(certificate));
            return "redirect:/ui/certificates/get/all";

    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.service.delete(id);
        return "redirect:/ui/persons/get/all";
    }
}

