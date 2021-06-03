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

import edu.coursework.admissions.model.Certificate;
import edu.coursework.admissions.model.Documents;
import edu.coursework.admissions.model.Person;
import edu.coursework.admissions.model.Specialty;
import edu.coursework.admissions.service.certificate.CertificateServiceImpl;
import edu.coursework.admissions.service.documents.DocumentsServiceImpl;
import edu.coursework.admissions.service.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/documents")
@Controller
public class DocumentsUiController {

    @Autowired
    DocumentsServiceImpl service;

    @Autowired
    CertificateServiceImpl serviceCertificate;

    @RequestMapping("/get/all")
    public String showAll(Model model){
        List<Documents> documents = service.getAll();
        model.addAttribute("document",documents);
        return "document/document-page";
    }

    @GetMapping("/showNewDocumentForm")
    public String showNewDocumentForm(Model model) {
        // create model attribute to bind form data
        Documents documents = new Documents();
        model.addAttribute("document",documents);
        List<Certificate> certificates = serviceCertificate.getAll();
        model.addAttribute("certificate",certificates);
        return "document/new_document";
    }
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Documents documents = service.getById(id);
        model.addAttribute("document",documents);
        List<Certificate> certificates = serviceCertificate.getAll();
        model.addAttribute("certificate",certificates);
        return "document/update_document";
    }
    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("document") @RequestBody  Documents documents) {
        service.update(documents);
        return "redirect:/ui/documents/get/all";
    }
    @PostMapping("/add")
    public String addTeacher(Model model, @ModelAttribute("document") @RequestBody  Documents documents) {

            model.addAttribute("document",service.create(documents));
            return "redirect:/ui/documents/get/all";

    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") String id) {

        // call delete employee method
        this.service.delete(id);
        return "redirect:/ui/documents/get/all";
    }
}

