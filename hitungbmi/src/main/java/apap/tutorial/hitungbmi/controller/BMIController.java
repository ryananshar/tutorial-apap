package apap.tutorial.hitungbmi.controller;

import apap.tutorial.hitungbmi.model.BMI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class BMIController {
    private String getHitungBMIPage(Optional<Double> weight, Optional<Double> height, Model model){
        if(height.isPresent() && weight.isPresent()){
            final BMI bmi = new BMI(weight.get(), height.get());
            model.addAttribute("bmi", bmi);
        }else if(height.isEmpty() && weight.isPresent()){
            model.addAttribute("msg", "tolong input tinggi dalam cm");
        }else if(weight.isEmpty() && height.isPresent()){
            model.addAttribute("msg", "tolong input berat dalam kg");
        }else{
            model.addAttribute("msg", "tolong input tinggi dan berat");
        }
        return "HitungBMIPage.html";
    }

    @GetMapping(value = "/hitung-bmi")
    public String hitungBMIWithRequestParam(
            @RequestParam(value = "height") Optional<Double> height,
            @RequestParam(value = "weight") Optional<Double> weight,
            Model model ) {
        return getHitungBMIPage(weight, height, model);
    }

    @GetMapping(value = "/hitung-bmi/{height}/{weight}")
    public String hitungBMIWithPathVariable(
            @PathVariable(value = "height") Optional<Double> height,
            @PathVariable(value = "weight") Optional<Double> weight,
            Model model ) {
        return getHitungBMIPage(weight, height, model);
    }
}