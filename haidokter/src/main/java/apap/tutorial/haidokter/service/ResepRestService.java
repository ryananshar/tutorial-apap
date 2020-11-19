package apap.tutorial.haidokter.service;

import java.util.List;

import apap.tutorial.haidokter.model.ResepModel;

public interface ResepRestService {
    ResepModel createResep(ResepModel resep);

    List<ResepModel> retrieveListResep();

    ResepModel getResepByNoResep(Long noResep);

    ResepModel changeResep(Long noResep, ResepModel resepUpdate);

    void deleteResep(Long noResep);
}
