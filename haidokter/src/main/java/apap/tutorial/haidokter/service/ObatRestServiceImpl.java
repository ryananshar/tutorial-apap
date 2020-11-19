package apap.tutorial.haidokter.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.repository.ObatDb;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class ObatRestServiceImpl implements ObatRestService {
    private final WebClient webClient;

    @Autowired
    private ObatDb obatDb;

    @Override
    public ObatModel createObat(ObatModel obat) {
        return obatDb.save(obat);
    }

    @Override
    public List<ObatModel> retrieveListObat() {
        return obatDb.findAll();
    }

    @Override
    public ObatModel getObatByNoId(Long id) {
        Optional<ObatModel> obat = obatDb.findById(id);
        if (obat.isPresent()) {
			return obat.get();
		} else {
			throw new NoSuchElementException();
		}
    }

    @Override
    public ObatModel changeObat(Long id, ObatModel obatUpdate) {
        ObatModel obat = getObatByNoId(id);
        obat.setNama(obatUpdate.getNama());
        obat.setKuantitas(obatUpdate.getKuantitas());
        obat.setBentuk(obatUpdate.getBentuk());
        return obatDb.save(obat);
    }

    @Override
    public void deleteObat(Long id) {
        ObatModel obat = getObatByNoId(id);
        obatDb.delete(obat);
    }
    
    public ObatRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public Mono<String> getHospitalByState(String state) {
        return this.webClient.get().uri("http://www.communitybenefitinsight.org/api/get_hospitals.php?state=" + state)
                .retrieve()
                .bodyToMono(String.class);
    }
}
