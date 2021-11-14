package ma.ensate.kriliya.controller;
import ma.ensate.kriliya.model.Image;
import ma.ensate.kriliya.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("kriliya/")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PutMapping("images/{id}")
    public Image update(@PathVariable Integer id,@RequestBody Image image){
        return imageService.updateImage(id, image);
    }

    @DeleteMapping("images/{id}")
    public void delete(@PathVariable Integer id){
        imageService.removeImage(id);
    }

}

