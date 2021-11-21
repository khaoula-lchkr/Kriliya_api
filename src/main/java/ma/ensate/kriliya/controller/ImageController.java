package ma.ensate.kriliya.controller;
import ma.ensate.kriliya.model.Image;
import ma.ensate.kriliya.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("kriliya/")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping(value = "images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Image> save(@RequestParam int id, @RequestParam MultipartFile[] files){
        return imageService.addImage(id, files);
    }

    @PutMapping("images/{id}")
    public Image update(@PathVariable Integer id,@RequestBody Image image){
        return imageService.updateImage(id, image);
    }

    @DeleteMapping("images/{id}")
    public void delete(@PathVariable Integer id){
        imageService.removeImage(id);
    }

}

