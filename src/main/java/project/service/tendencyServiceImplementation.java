package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.models.Category;
import project.models.ClothesEntity;
import project.models.tendencyEntity;
import project.repository.UserRepository;
import project.repository.tendencyRepository;

import java.util.List;

@Service
public class tendencyServiceImplementation implements tendencyServiceInterface {

    @Autowired
    tendencyRepository tRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public tendencyEntity Addtendency(int userId, tendencyEntity tendence) {
        tendence.setUser(userRepository.findById(userId).orElse(null));
        return tRepository.save(tendence);
    }
    @Override
    public void deleteTendency(Long id) {
        tRepository.deleteById(id);
    }

    @Override
    public tendencyEntity updateTendencyPut(Long id, String name, String description,  String imageName)  {
        tendencyEntity tdc = tRepository.findById(id).get();
        tdc.setName(name);
        tdc.setImageName(imageName);
        tdc.setDescription(description);

        return tRepository.save(tdc);
    }

    @Override
    public List<tendencyEntity> getAllTendency(Long id) {

        return tRepository.findByUserId(Math.toIntExact(id));
    }

    @Override
    public tendencyEntity getTendencyById(Long id) {

        return tRepository.findById(id).orElse(null);
    }

}
