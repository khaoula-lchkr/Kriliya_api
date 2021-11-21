package ma.ensate.kriliya.service;

import ma.ensate.kriliya.model.Image;
import ma.ensate.kriliya.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public List<Image> addImage(int id, MultipartFile[] files) {
        Image image = null;
        List<Image> images = new ArrayList<>();
//        for (MultipartFile file: files) {
//            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//            if(fileName.contains(".."))
//            {
//                System.out.println("not a a valid file");
//            }
//            try {
//                image.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//                image.setAnnonce_id(id);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            images.add(image);
//        }
        return imageRepository.saveAll(images);
    }

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

           if(!imageToUpdate.getImage().equals(updatedImage.getImage())) {
               imageToUpdate.setImage(updatedImage.getImage());
           }
       }
        return imageToUpdate;
    }
}
