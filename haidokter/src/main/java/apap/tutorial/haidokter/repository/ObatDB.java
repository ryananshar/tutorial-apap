package apap.tutorial.haidokter.repository;

import apap.tutorial.haidokter.model.ObatModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ObatDb extends JpaRepository<ObatModel, Long>{
    Optional<ObatModel> findById(Long id);
}
