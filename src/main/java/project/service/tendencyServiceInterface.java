package project.service;

import project.models.ClothesEntity;
import project.models.tendencyEntity;

import java.util.List;

public interface tendencyServiceInterface {
    tendencyEntity Addtendency(int userId, tendencyEntity tendence);
    void deleteTendency(Long id);
    tendencyEntity updateTendencyPut(Long id , String name, String description,  String imageName) ;
    List<tendencyEntity> getAllTendency(Long id);
    tendencyEntity getTendencyById(Long id);




}
