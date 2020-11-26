package apap.tutorial.haidokter.service;

import java.util.List;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.rest.ResepDetail;
import reactor.core.publisher.Mono;

public interface ResepRestService {
    ResepModel createResep(ResepModel resep);

    List<ResepModel> retrieveListResep();

    ResepModel getResepByNoResep(Long noResep);

    ResepModel changeResep(Long noResep, ResepModel resepUpdate);

    void deleteResep(Long noResep);

    Mono<String> getStatus(Long noResep);

    Mono<ResepDetail> postStatus();
}
