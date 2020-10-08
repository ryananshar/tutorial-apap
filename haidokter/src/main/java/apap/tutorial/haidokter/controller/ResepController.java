package apap.tutorial.haidokter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ResepService;

import java.util.*;

@Controller
public class ResepController {
    @Autowired
    private ResepService resepService;

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

    @RequestMapping("/resep/view")
    public String detailResep (
        @RequestParam(value = "noResep") Long noResep,
        Model model) {

            // Mendapatkan ResepModel berdasarkan noResep
            ResepModel resep = resepService.getResepByNomorResep(noResep);

            // Menambah variabel listResep untuk dirender pada Thymeleaf
            model.addAttribute("resep", resep);

            return "view-resep";
        }

    @GetMapping(value = "resep/view/no-resep/{noResep}")
    public String detailResepPathVariable (
        @PathVariable(value = "noResep", required = true) Long noResep,
        Model model) {

            // Mendapatkan ResepModel berdasarkan noResep
            ResepModel resep = resepService.getResepByNomorResep(noResep);

            // Menambah variabel listResep untuk dirender pada Thymeleaf
            model.addAttribute("resep", resep);

            return "view-resep";
    }

    @GetMapping(value = "resep/update/no-resep/{noResep}/catatan/{catatan}")
    public String updateResep (
        @PathVariable(value = "noResep", required = true) Long noResep,
        @PathVariable(value = "catatan", required = true) String catatan,
        Model model) {

            // Mendapatkan ResepModel berdasarkan noResep dan meng-update catatan
            ResepModel resep = resepService.getResepByNomorResep(noResep);            
            resep.setCatatan(catatan);

            // Menambah variabel listResep untuk dirender pada Thymeleaf
            if (resep.getNoResep() != null) {
                model.addAttribute("noResep", noResep);
                model.addAttribute("resep", resep);    
                return "update-resep";
            } else {
                return "update-error";
            }
            
            
    }

    @GetMapping(value = "resep/delete/no-resep/{noResep}")
    public String deleteResep (
        @PathVariable(value = "noResep", required = true) Long noResep,
        Model model) {

            // Mendapatkan ResepModel berdasarkan noResep
            ResepModel resep = resepService.getResepByNomorResep(noResep);
            List<ResepModel> listResep = resepService.getResepList();

            // Mencari dan menghapus resep
            for (int i = 0; i < listResep.size(); i++) {
                if (listResep.get(i).getNoResep().equals(noResep)) {
                    listResep.remove(i);
                    model.addAttribute("noResep", noResep);
                    model.addAttribute("resep", resep);
                    return "delete-resep";
                }
            }
            return "delete-error";
    }

    // fitur delete-all
    // Path url: http://localhost:8080/resep/delete-all 
    @GetMapping(value = "resep/delete-all")
    public String deleteAll(Model model) {
        // Mendapat list resep
        List<ResepModel> listResep = resepService.getResepList();

        // Menghapus semua elemen pada list
        listResep.clear();

        // Menambah variabel listResep untuk dirender pada Thymeleaf
        model.addAttribute("listResep", listResep);

        // Return view template
        return "delete-all";
    }
}