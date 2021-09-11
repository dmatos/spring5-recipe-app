package guru.springframework.repositories;

import guru.springframework.model.UnityOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnityOfMeasureRepository extends CrudRepository<UnityOfMeasure, Long> {

    Optional<UnityOfMeasure> findByDescription(String description);
}
