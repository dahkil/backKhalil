package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.models.ClothesEntity;
import project.models.tendencyEntity;

import java.util.List;

@Repository

public interface tendencyRepository extends JpaRepository<tendencyEntity, Long> {


}
