package apap.tutorial.haidokter.controller;


import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
// import apap.tutorial.haidokter.service.ObatService;
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
    // private ObatService obatService;

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

    @GetMapping({"/resep/change/{noResep}", "/resep/change"})
    private String changeResepFormPage(
            @PathVariable(required = false) Long noResep,
            Model model
    ) {
        try {
            ResepModel resep = resepService.getResepByNomorResep(noResep);
            model.addAttribute("resep", resep);

            return "form-update-resep";
        } catch (Exception e) {
            model.addAttribute("msg", "Nomor Resep Tidak Ditemukan atau Nomor Resep Tidak Ada!");

        return "update-error";
        }
        
    }

    // @GetMapping("/resep/change/{noResep}")
    // private String changeResepFormpage(
    //     @PathVariable Long noResep,
    //     Model model
    // ) {
    //     ResepModel resep = resepService.getResepByNomorResep(noResep);
    //     model.addAttribute("resep", resep);

    //     return "form-update-resep";
    // }

    @PostMapping("/resep/change")
    private String changeResepFormSubmit(
        @ModelAttribute ResepModel resep,
        Model model
    ) {
        ResepModel updatedResep = resepService.updateResep(resep);
        model.addAttribute("resep", updatedResep);

        return "update-resep";
    }

    // @GetMapping("/resep/delete/{noResep}")
    // public String deleteResep(@PathVariable Long noResep, Model model) {
    //     String message = "Resep tidak bisa dihapus karena memiliki obat.";
    //     ResepModel resep = resepService.getResepByNomorResep(noResep);

    //     try {
    //         List<ObatModel> listObat = resep.getListObat(); 
    //         resepService.deleteResep(resep);
    //     } catch (Exception e) {
    //         message = e.getMessage();
    //     }

    //     model.addAttribute("noResep", noResep);
    //     model.addAttribute("message", message);

    //     return "delete-resep";
    // }

    @GetMapping({"/resep/delete/no-resep/{noResep}", "/resep/delete/no-resep"})
    public String deleteResep(
            @PathVariable(value = "noResep", required = false) Long noResep,
            Model model
    ) throws Exception {
        if (noResep != null) {
            if (isResepExists(noResep) && !hasObat(noResep)) {
                ResepModel resep = resepService.getResepByNomorResep(noResep);
                model.addAttribute("resep", resep);
                resepService.deleteResep(resep);

                return "delete-resep";
            } else if (hasObat(noResep)) {
                model.addAttribute("msg", "Resep masih memiliki obat! Hapus obat terlebih dahulu!");

                return "delete-error";
            }
        }
        model.addAttribute("msg", "Nomor Resep Tidak Ditemukan atau Nomor Resep Tidak Ada!");

        return "delete-error";
    }

    @GetMapping("/resep/view")
    public String viewDetailResep(
        @RequestParam(value = "noResep") Long noResep,
        Model model
    ) {
        try {
            ResepModel resep = resepService.getResepByNomorResep(noResep);
            
            model.addAttribute("resep", resep);
            List<ObatModel> listObat = resep.getListObat();  
            model.addAttribute("listObat", listObat);           

            return "view-resep";
        } catch (NoSuchElementException e) {
            String message = "Proses pencarian tidak dilakukan karena nomor resep tidak ada.";
            model.addAttribute("message", message);
            
            return "view-resep";
        }
                
    } 


    @RequestMapping("/resep/viewall")
    public String listResep(Model model) {
        // Mendapatkan semua ResepModel
        List<ResepModel> listResep = resepService.getResepList();
        
        // Menambah variabel listResep untuk dirender pada Thymeleaf
        model.addAttribute("listResep", listResep);

        // Return view template
        return "viewall-resep";
    }


    private boolean isResepExists(Long noResep) {
        return resepService.getResepByNomorResep(noResep).isPresent();
    }

    private boolean hasObat(Long noResep) {
        return resepService.getResepByNomorResep(noResep).getListObat().size() != 0;
    }
}