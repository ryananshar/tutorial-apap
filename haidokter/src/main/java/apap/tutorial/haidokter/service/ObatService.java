package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;

import java.util.List;

public interface ObatService {
    void addObat(ObatModel obat);

    ObatModel getObatByID(Long id);

    ObatModel updateObat(ObatModel resepModel);
}
