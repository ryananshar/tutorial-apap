package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;

import java.util.List;


public interface ResepService {
    //  Method untuk menambah Resep
    void addResep(ResepModel resep);

    //  Method untuk mendapatkan semua data Resep yang telah tersimpan
    List<ResepModel> getResepList();

    //  Method untuk mendapatkan data sebuah resep berdasarkan nomor resep
    ResepModel getResepByNomorResep(String noResep);
}