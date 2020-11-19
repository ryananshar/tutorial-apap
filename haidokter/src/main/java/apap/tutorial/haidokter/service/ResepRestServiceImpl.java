package apap.tutorial.haidokter.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.repository.ResepDb;

@Service
@Transactional
public class ResepRestServiceImpl implements ResepRestService{
    @Autowired
    private ResepDb resepDb;

	@Override
	public ResepModel createResep(ResepModel resep) {
		return resepDb.save(resep);
	}

	@Override
	public List<ResepModel> retrieveListResep() {
		return resepDb.findAll();
	}

	@Override
	public ResepModel getResepByNoResep(Long noResep) {
        Optional<ResepModel> resep = resepDb.findByNoResep(noResep);
        if (resep.isPresent()) {
            return resep.get();
        } else {
            throw new NoSuchElementException();
        }
	}

	@Override
	public ResepModel changeResep(Long noResep, ResepModel resepUpdate) {
        ResepModel resep = getResepByNoResep(noResep);
		resep.setNamaDokter(resepUpdate.getNamaDokter());
		resep.setNamaPasien(resepUpdate.getNamaPasien());
		resep.setCatatan(resepUpdate.getCatatan());
		return resepDb.save(resep);
	}

	@Override
	public void deleteResep(Long noResep) {
		ResepModel resep = getResepByNoResep(noResep);
		if (resep.getListObat().size() == 0) {
			resepDb.delete(resep);
		} else {
			throw new UnsupportedOperationException();
		}
		
	}
    
}
