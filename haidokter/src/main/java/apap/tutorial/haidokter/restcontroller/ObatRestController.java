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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.service.ObatRestService;


@RestController
@RequestMapping("/api/v1")
public class ObatRestController {
    @Autowired
    private ObatRestService obatRestService;

    @PostMapping(value = "/obat")
    private ResponseEntity<String> createResep(@Valid @RequestBody ObatModel obat, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        } else {
            obatRestService.createObat(obat);
            return ResponseEntity.ok("Add Obat success");
        }
    }

    @DeleteMapping(value = "/obat/{id}")
    private ResponseEntity<String> deleteObat(@PathVariable("id") Long id) {
        try {
            obatRestService.deleteObat(id);
            return ResponseEntity.ok("Obat has been deleted!");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "obat with ID " + String.valueOf(id) + " not found!"
            );
        }
    }

    @PutMapping(value = "/obat/{id}")
    private ResponseEntity<String> updateObat(@PathVariable(value = "id") Long id, @RequestBody ObatModel obat) {
        try {
            obatRestService.changeObat(id, obat);            
            return ResponseEntity.ok("Update Obat success");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Obat with ID " + String.valueOf(id) + " not found!"
            );
        }
    }

    @GetMapping(value = "/obat/{id}")
    private ObatModel getObat(@PathVariable(value = "id") Long id) {
        try {
            return obatRestService.getObatByNoId(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Obat with Id " + String.valueOf(id) + " not found!"
            );
        }
        
    }

    @GetMapping(value = "/obats")
    private List<ObatModel> getListObat() {
        return obatRestService.retrieveListObat();
    }
}
