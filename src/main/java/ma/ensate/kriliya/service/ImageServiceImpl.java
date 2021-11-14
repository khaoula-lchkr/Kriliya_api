package ma.ensate.kriliya.service;

import ma.ensate.kriliya.model.Image;
import ma.ensate.kriliya.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public void removeImage(Integer id) {
        imageRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Image updateImage(Integer id, Image updatedImage) {
       Optional<Image> image = imageRepository.findById(id);

       Image imageToUpdate = null;
       if(image.isPresent()){
           imageToUpdate = image.get();
           System.out.println(imageToUpdate.getCle());
           if(!imageToUpdate.getUrl().equals(updatedImage.getUrl())){
               imageToUpdate.setUrl(updatedImage.getUrl());
           }
           if(!imageToUpdate.getCle().equals(updatedImage.getCle()))
           {
               imageToUpdate.setCle(updatedImage.getCle());
           }
       }
        return imageToUpdate;
    }
}
