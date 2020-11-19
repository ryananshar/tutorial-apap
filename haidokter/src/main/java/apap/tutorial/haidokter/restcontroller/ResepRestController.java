package apap.tutorial.haidokter.restcontroller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestMapping;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ResepRestService;

@RestController
@RequestMapping("/api/v1")
public class ResepRestController {
    @Autowired
    private ResepRestService resepRestService;

    @PostMapping(value = "/resep")
    private ResepModel createResep(@Valid @RequestBody ResepModel resep, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        } else {
            return resepRestService.createResep(resep);
        }
    }

    @DeleteMapping(value = "/resep/{noResep}")
    private ResponseEntity<String> deleteResep(@PathVariable("noResep") Long noResep) {
        try {
            resepRestService.deleteResep(noResep);
            return ResponseEntity.ok("Resep with Number " + String.valueOf(noResep) + " deleted!");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Resep with Number " + String.valueOf(noResep) + " not found!"
            );
        } catch (UnsupportedOperationException e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Resep still has Obat, please delete the Obat first!"
            );
        }
    }

    @PutMapping(value = "/resep/{noResep}")
    private ResepModel updateResep(@PathVariable(value = "noResep") Long noResep, @RequestBody ResepModel resep) {
        try {
            return resepRestService.changeResep(noResep, resep);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Resep with Number " + String.valueOf(noResep) + " not found!"
            );
        }
    }

    @GetMapping(value = "/reseps")
    private List<ResepModel> retrieveListResep() {
        return resepRestService.retrieveListResep();
    }
}
