package apap.tutorial.haidokter.repository;

import apap.tutorial.haidokter.model.ResepModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResepDb extends JpaRepository<ResepModel, Long> {
    Optional<ResepModel> findByNoResep(Long noResep);
}
