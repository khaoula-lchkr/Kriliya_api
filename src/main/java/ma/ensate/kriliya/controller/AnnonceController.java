package ma.ensate.kriliya.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.ensate.kriliya.model.Annonce;
import ma.ensate.kriliya.service.AnnonceService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("kriliya/")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @GetMapping("mesAnnonces/{id}")
    public List<Annonce> getByUser(@PathVariable Integer id){
        return annonceService.getAnnonceByUser(id);
    }

    @GetMapping("annonce/{id}")
    public Annonce getAnnonce(@PathVariable Integer id) { return annonceService.getAnnonce(id);}

    @PostMapping(path = "/annonce/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Annonce save(@RequestPart String annonce, @RequestPart MultipartFile[] files) {

        Annonce annonceOb = new Annonce();
        try {
            annonceOb  = new ObjectMapper().readValue(annonce, Annonce.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
           return annonceService.addAnnonce(annonceOb, files);
    }

    @PutMapping("annonce/{id}")
    public Annonce update(@PathVariable Integer id, @RequestBody Annonce annonce){
       return  annonceService.updateAnnonce(id, annonce);
    }

    @DeleteMapping("annonce/{id}")
    public void delete(@PathVariable Integer id) {
        annonceService.removeAnnonce(id);
    }
}
