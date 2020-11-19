package apap.tutorial.haidokter.service;

import java.util.List;

import apap.tutorial.haidokter.model.ObatModel;
import reactor.core.publisher.Mono;

public interface ObatRestService {
    ObatModel createObat(ObatModel obat);

    List<ObatModel> retrieveListObat();

    ObatModel getObatByNoId(Long id);

    ObatModel changeObat(Long id, ObatModel obatUpdate);

    void deleteObat(Long id);

    Mono<String> getHospitalByState(String state);
}
