package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatService;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ObatController {
    @Qualifier("resepServiceImpl")
    @Autowired
    ResepService resepService;

    @Autowired
    ObatService obatService;

    @GetMapping("/obat/add/{noResep}")
    private String addResepFormPage(
        @PathVariable Long noResep,
        Model model
    ) {
        ObatModel obat = new ObatModel();
        ResepModel resep = resepService.getResepByNomorResep(noResep);

        obat.setResepModel(resep);
        model.addAttribute("obat", obat);
        model.addAttribute("noResep", noResep);

        return "form-add-obat";
    }

    @PostMapping("/obat/add")
    private String addObatSubmit(
        @ModelAttribute ObatModel obat,
        Model model
    ) {
        Long resep = obat.getResepModel().getNoResep();
        obatService.addObat(obat);
        model.addAttribute("obat", obat);
        model.addAttribute("nama", obat.getNama());
        model.addAttribute("noResep", resep);

        return "add-obat";
    }

    @GetMapping("/obat/change/{id}")
    private String changeObatFormpage(
        @PathVariable Long id,
        Model model
    ) {
        ObatModel obat = obatService.getObatByID(id);
        Long resep = obat.getResepModel().getNoResep();

        model.addAttribute("obat", obat);
        model.addAttribute("noResep", resep);

        return "form-update-obat";
    }

    @PostMapping("/obat/change")
    private String changeObatFormSubmit(
        @ModelAttribute ObatModel obat,
        Model model
    ) {
        ObatModel updatedObat = obatService.updateObat(obat);
        Long resep = obat.getResepModel().getNoResep();

        model.addAttribute("obat", updatedObat);
        model.addAttribute("noResep", resep);

        return "update-obat";
    }

    @GetMapping("/obat/delete/{id}")
    public String deleteObat(@PathVariable Long id, Model model) {
        ObatModel obat = obatService.getObatByID(id);
        Long resep = obat.getResepModel().getNoResep();

        obatService.deleteObat(id);

        model.addAttribute("obat", obat);
        model.addAttribute("id", id);
        model.addAttribute("noResep", resep);

        return "delete-obat";
    }

    @PostMapping(value="/obat/delete")
    public String deleteMenuFormSubmi(@ModelAttribute ResepModel resep, Model model) {
        model.addAttribute("obatCount", resep.getListObat().size());
        for (ObatModel obat : resep.getListObat()) {
            obatService.deleteObat(obat.getId());
        }
        return "delete-obat";
    }

    // @GetMapping("/obat/delete/{id}")
    // public String deleteObat(@PathVariable Long id, Model model) {
    //     ObatModel obat = obatService.getObatByID(id);
    //     Long resep = obat.getResepModel().getNoResep();

    //     obatService.deleteObat(id);

    //     model.addAttribute("obat", obat);
    //     model.addAttribute("id", id);
    //     model.addAttribute("noResep", resep);

    //     return "delete-obat";
    // }
}
