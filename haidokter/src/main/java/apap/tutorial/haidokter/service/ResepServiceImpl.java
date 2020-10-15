package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.repository.ResepDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ResepServiceImpl implements ResepService {
    @Autowired
    ResepDb resepDb;

    @Override
    public void addResep(ResepModel resep) {
        resepDb.save(resep);
    }

    @Override
    public List<ResepModel> getResepList() {
        return resepDb.findAll(Sort.by(Sort.Direction.DESC, "noResep"));
        // return resepDb.findAll();
    }

    @Override
    public ResepModel getResepByNomorResep(Long noResep) {
        return resepDb.findByNoResep(noResep).get();
    }

    @Override
    public ResepModel updateResep(ResepModel resep) {
        resepDb.save(resep);
        return resep;
    }

    @Override
    public void deleteResep(ResepModel resep) throws Exception{
        if (resep.getListObat().isEmpty()) {
            resepDb.deleteById(resep.getNoResep());
        }
        else {
            throw new Exception("Resep tidak bisa dihapus karena memiliki obat.");
        }
    }

    // @GetMapping(value = "resep/delete/no-resep/{noResep}")
    // public String deleteResep (
    //     @PathVariable(value = "noResep", required = true) Long noResep,
    //     Model model) {

    //         // Mendapatkan ResepModel berdasarkan noResep
    //         ResepModel resep = resepService.getResepByNomorResep(noResep);
    //         List<ResepModel> listResep = resepService.getResepList();

    //         // Mencari dan menghapus resep
    //         for (int i = 0; i < listResep.size(); i++) {
    //             if (listResep.get(i).getNoResep().equals(noResep)) {
    //                 listResep.remove(i);
    //                 model.addAttribute("noResep", noResep);
    //                 model.addAttribute("resep", resep);
    //                 return "delete-resep";
    //             }
    //         }
    //         return "delete-error";
    // }
}
