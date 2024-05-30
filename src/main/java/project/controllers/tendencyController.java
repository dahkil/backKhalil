package project.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.models.ClothesEntity;
import project.models.tendencyEntity;
import project.repository.tendencyRepository;
import project.service.tendencyServiceInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tendency")
public class tendencyController {

    @Autowired
    tendencyServiceInterface tServiceInterface;

    @Autowired
    tendencyRepository trepository;

    @PostMapping(value = "add", consumes = {"multipart/form-data"})
    public ResponseEntity<tendencyEntity> addtendence(@RequestPart("tendency") String tendencyJson,
                                                      @RequestPart("image") MultipartFile image) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> tendency = objectMapper.readValue(tendencyJson, Map.class);

        String name = (String) tendency.get("name");
        String description = (String) tendency.get("description");
        Integer idUser = (Integer) tendency.get("id");

        String path = "C:\\Users\\MSI\\Downloads\\frontKhalil-main\\frontKhalil-main\\src\\assets\\images";
        Files.copy(image.getInputStream(), Paths.get(path + File.separator + image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        String imageName = image.getOriginalFilename();

        tendencyEntity newTendency = new tendencyEntity();
        newTendency.setName(name);
        newTendency.setDescription(description);
        newTendency.setImageName(imageName);
        return ResponseEntity.ok(tServiceInterface.Addtendency(idUser, newTendency));
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteTendency(@PathVariable Long id) {
        tServiceInterface.deleteTendency(id);
    }

    @PutMapping(value = "/update/{id}",consumes = {"multipart/form-data"})
    public tendencyEntity updateTendencyPut(@PathVariable Long id, @RequestPart("tendency") String tendencyJson,
                                          @RequestPart("image") MultipartFile image) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> tendency = objectMapper.readValue(tendencyJson, Map.class);

        String name = (String) tendency.get("name");
        String description = (String) tendency.get("description");
        String path="C:\\Users\\MSI\\Downloads\\frontKhalil-main\\frontKhalil-main\\src\\assets\\images";
        Files.copy(image.getInputStream(), Paths.get(path+ File.separator+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        String imageName = image.getOriginalFilename();
        return tServiceInterface.updateTendencyPut(id,name,description,imageName);

    }

    @GetMapping("/getAll/{id}")
    public List<tendencyEntity> getAllTendency(@PathVariable Long id) {
        return tServiceInterface.getAllTendency(id);

    }
    @GetMapping("get/{id}")
    public tendencyEntity getTendencyById(@PathVariable Long id) {
        return tServiceInterface.getTendencyById(id);


    }
}
