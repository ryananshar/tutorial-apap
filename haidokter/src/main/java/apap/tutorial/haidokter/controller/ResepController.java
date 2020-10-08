package apap.tutorial.haidokter.controller;


import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatService;
import apap.tutorial.haidokter.service.ResepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ResepController {

    @Qualifier("resepServiceImpl")
    @Autowired
    private ResepService resepService;

    @Autowired
    private ObatService obatService;

    @GetMapping("/")
    private String home() {
        return "home";
    }

    @GetMapping("/resep/add")
    public String addResepFormPage(Model model) {
        model.addAttribute("resep", new ResepModel());

        return "form-add-resep";
    }

    @PostMapping("/resep/add")
    public String addResepSubmit(
        @ModelAttribute ResepModel resep,
        Model model
    ) {
        resepService.addResep(resep);
        model.addAttribute("nomorResep", resep.getNoResep());

        return "add-resep";
    }

    @GetMapping("/resep/change/{noResep}")
    private String changeResepFormpage(
        @PathVariable Long noResep,
        Model model
    ) {
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        model.addAttribute("resep", resep);

        return "form-update-resep";
    }

    @PostMapping("/resep/change")
    private String changeResepFormSubmit(
        @ModelAttribute ResepModel resep,
        Model model
    ) {
        ResepModel updatedResep = resepService.updateResep(resep);
        model.addAttribute("resep", updatedResep);

        return "update-resep";
    }

    @GetMapping("/resep/view")
    public String viewDetailResep(
        @RequestParam(value = "noResep") Long noResep,
        Model model
    ) {
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        List<ObatModel> listObat = resep.getListObat();

        model.addAttribute("resep", resep);
        model.addAttribute("listObat", listObat);

        return "view-resep";
    } 

    // Routing URL
    // @RequestMapping("/resep/add")
    // public String addResep(
    //     @RequestParam(value = "noResep", required = true) Long noResep,
    //     @RequestParam(value = "namaDokter", required = true) String namaDokter,
    //     @RequestParam(value = "namaPasien", required = true) String namaPasien,
    //     @RequestParam(value = "catatan", required = true) String catatan,
    //     Model model ) {
    //         // Membuat objek ResepModel
    //         ResepModel resep = new ResepModel(noResep, namaDokter, namaPasien, catatan);

    //         // Memanggil service addResep
    //         resepService.addResep(resep);

    //         // Menambah variabel nomorResep untuk dirender pada Thymeleaf
    //         model.addAttribute("nomorResep", noResep);

    //         // Return view template
    //         return "add-resep";
    //     }

    @RequestMapping("/resep/viewall")
    public String listResep(Model model) {
        // Mendapatkan semua ResepModel
        List<ResepModel> listResep = resepService.getResepList();
        
        // Menambah variabel listResep untuk dirender pada Thymeleaf
        model.addAttribute("listResep", listResep);

        // Return view template
        return "viewall-resep";
    }


    // @GetMapping(value = "resep/view/no-resep/{noResep}")
    // public String detailResepPathVariable (
    //     @PathVariable(value = "noResep", required = true) Long noResep,
    //     Model model) {

    //         // Mendapatkan ResepModel berdasarkan noResep
    //         ResepModel resep = resepService.getResepByNomorResep(noResep);

    //         // Menambah variabel listResep untuk dirender pada Thymeleaf
    //         model.addAttribute("resep", resep);

    //         return "view-resep";
    // }

    // @GetMapping(value = "resep/update/no-resep/{noResep}/catatan/{catatan}")
    // public String updateResep (
    //     @PathVariable(value = "noResep", required = true) Long noResep,
    //     @PathVariable(value = "catatan", required = true) String catatan,
    //     Model model) {

    //         // Mendapatkan ResepModel berdasarkan noResep dan meng-update catatan
    //         ResepModel resep = resepService.getResepByNomorResep(noResep);            
    //         resep.setCatatan(catatan);

    //         // Menambah variabel listResep untuk dirender pada Thymeleaf
    //         if (resep.getNoResep() != null) {
    //             model.addAttribute("noResep", noResep);
    //             model.addAttribute("resep", resep);    
    //             return "update-resep";
    //         } else {
    //             return "update-error";
    //         }
            
            
    // }

    // @GetMapping(value = "resep/delete/no-resep/{noResep}")
    // public String deleteResep (
    //     @PathVariable(value = "noResep", required = true) Long noResep,
    //     Model model) {

    //         // Mendapatkan ResepModel berdasarkan noResep
    //         ResepModel resep = resepService.getResepByNomorResep(noResep);
    //         List<ResepModel> listResep = resepService.getResepList();

    //         // Mencari dan menghapus resep
    //         for (int i = 0; i < listResep.size(); i++) {
    //             if (listResep.get(i).getNoResep().equals(noResep)) {
    //                 listResep.remove(i);
    //                 model.addAttribute("noResep", noResep);
    //                 model.addAttribute("resep", resep);
    //                 return "delete-resep";
    //             }
    //         }
    //         return "delete-error";
    // }

    // // fitur delete-all
    // // Path url: http://localhost:8080/resep/delete-all 
    // @GetMapping(value = "resep/delete-all")
    // public String deleteAll(Model model) {
    //     // Mendapat list resep
    //     List<ResepModel> listResep = resepService.getResepList();

    //     // Menghapus semua elemen pada list
    //     listResep.clear();

    //     // Menambah variabel listResep untuk dirender pada Thymeleaf
    //     model.addAttribute("listResep", listResep);

    //     // Return view template
    //     return "delete-all";
    // }
}