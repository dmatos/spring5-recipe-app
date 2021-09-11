package guru.springframework.services;

import guru.springframework.model.UnityOfMeasure;
import guru.springframework.repositories.UnityOfMeasureRepository;
import org.springframework.stereotype.Service;

@Service
public class UnityOfMeasureService {
    private final UnityOfMeasureRepository unityOfMeasureRepository;

    public UnityOfMeasureService(UnityOfMeasureRepository unityOfMeasureRepository) {
        this.unityOfMeasureRepository = unityOfMeasureRepository;
    }

    public UnityOfMeasure findByDescription(String description){
        return unityOfMeasureRepository.findByDescription(description).get();
    }
}
