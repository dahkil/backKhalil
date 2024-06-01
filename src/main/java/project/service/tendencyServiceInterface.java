package project.service;

import project.models.ClothesEntity;
import project.models.tendencyEntity;

import java.util.List;

public interface tendencyServiceInterface {
    tendencyEntity Addtendency( tendencyEntity tendence);
    void deleteTendency(Long id);
    tendencyEntity updateTendencyPut(Long id , String name, String description,  String imageName) ;
    List<tendencyEntity> getAllTendency();
    tendencyEntity getTendencyById(Long id);




}
