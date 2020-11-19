package apap.tutorial.haidokter.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.repository.ResepDb;
import apap.tutorial.haidokter.rest.ResepDetail;
import apap.tutorial.haidokter.rest.Setting;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import reactor.core.publisher.Mono;

@Service
@Transactional
public class ResepRestServiceImpl implements ResepRestService {
	private final WebClient webClient;

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

	public ResepRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.resepUrl).build();
    }

	@Override
	public Mono<String> getStatus(Long noResep) {
		return this.webClient.get().uri("/rest/resep/"+noResep+"/status").retrieve().bodyToMono(String.class);
	}

	@Override
	public Mono<ResepDetail> postStatus() {
		MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
		data.add("namaDokter", "Dr. PAPA");
		data.add("namaPasien", "Dede APAP");
		return this.webClient.post().uri("/rest/resep/full")
				.syncBody(data)
				.retrieve()
				.bodyToMono(ResepDetail.class);
	}
    
}