package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.models.ClothesEntity;
import project.repository.ClothesRepository;
import project.service.ClothesServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/Clothes")
public class ClothesControlles {

    @Autowired
    ClothesServiceInterface clothesServiceInterface;
    @Autowired
    ClothesRepository clothesRepository;

    @PostMapping(value = "/add")
    public ClothesEntity addClothes(@RequestBody ClothesEntity Clothes) {
        return clothesServiceInterface.addClothes(Clothes);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteClothes(@PathVariable Long id) {
        clothesServiceInterface.deleteClothes(id);
    }

    @PutMapping(value = "/updateClothes/{id}")
    public ClothesEntity updateClothesPut(@PathVariable Long id, @RequestBody ClothesEntity clothes) {
        return clothesServiceInterface.updateClothesPut(id, clothes);

    }


    @PostMapping("addP/{userId}")

    public ClothesEntity AddClothes(@PathVariable int userId, @RequestBody ClothesEntity clothes) {
        return clothesServiceInterface.AddClothes(userId, clothes);
    }


    @GetMapping("/all")
    public List<ClothesEntity> getAllClothes() {
        return clothesServiceInterface.getAllClothes();

    }


    @GetMapping("get/{id}")
    public ClothesEntity getClothesById(@PathVariable Long id) {
        return clothesServiceInterface.getClothesById(id);


    }

    @GetMapping("/user/{userId}")
    public List<ClothesEntity> getClothesByUserId(@PathVariable int userId) {
        return clothesServiceInterface.getClothesByUserId(userId);

    }

    @PutMapping("/update/{clothesId}")
    public ClothesEntity updateClothes(@PathVariable Long clothesId, @RequestBody ClothesEntity updatedClothes) {
        return clothesServiceInterface.updateClothes(clothesId, updatedClothes);

    }
}


