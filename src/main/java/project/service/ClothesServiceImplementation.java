package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.models.ClothesEntity;
import project.models.UserEntity;
import project.repository.ClothesRepository;
import project.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service

public class ClothesServiceImplementation implements ClothesServiceInterface {
    @Autowired
    ClothesRepository clothesRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public ClothesEntity addClothes(ClothesEntity Clothes) {
        return clothesRepository.save(Clothes);
    }

    @Override
    public void deleteClothes(Long id) {
        clothesRepository.deleteById(id);
    }

    @Override
    public ClothesEntity updateClothesPut(Long id, ClothesEntity clothes) {
        ClothesEntity cls = clothesRepository.findById(id).get();
        cls.setName(clothes.getName());
        cls.setDescription(clothes.getDescription());
        return clothesRepository.save(cls);
    }




    @Override
    public ClothesEntity AddClothes(int userId, ClothesEntity clothes) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()) {

            clothes.setUser(user.get());

            return clothesRepository.save(clothes);

        } else {
            throw new IllegalArgumentException("User Not found");
        }


    }

    @Override
    public List<ClothesEntity> getAllClothes() {
        return clothesRepository.findAll();
    }


    @Override
    public ClothesEntity getClothesById(Long id) {

        return clothesRepository.findById(id).orElse(null);
    }


    @Override
    public List<ClothesEntity> getClothesByUserId(int userId) {
        return clothesRepository.findByUserId(userId);
    }


    @Override
    public ClothesEntity updateClothes(Long clothesId, ClothesEntity updatedClothes) {
        ClothesEntity existingClothes = clothesRepository.findById(clothesId).orElse(null);
        if (existingClothes != null) {
            existingClothes.setName(updatedClothes.getName());
            existingClothes.setDescription(updatedClothes.getDescription());
            return clothesRepository.save(existingClothes);
        } else {
            return null;
        }

    }
}





