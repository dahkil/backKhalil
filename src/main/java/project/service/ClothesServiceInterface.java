package project.service;

import project.models.ClothesEntity;

import java.util.List;

public interface ClothesServiceInterface {

    ClothesEntity addClothes(ClothesEntity clothes);
    void deleteClothes(Long id);
    ClothesEntity updateClothesPut(Long id , ClothesEntity clothes) ;
    ClothesEntity AddClothes (int userId,ClothesEntity clothes);
    List<ClothesEntity> getAllClothes();
    ClothesEntity getClothesById(Long id);
    List<ClothesEntity> getClothesByUserId(int userId);
    ClothesEntity updateClothes(Long clothesId, ClothesEntity updatedClothes);



}



