package apap.tutorial.haidokter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tutorial.haidokter.model.RoleModel;

@Repository
public interface RoleDb extends JpaRepository<RoleModel, Long>{
    List<RoleModel> findAll();
}
