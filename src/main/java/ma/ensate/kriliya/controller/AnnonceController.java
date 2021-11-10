package ma.ensate.kriliya.controller;

import ma.ensate.kriliya.model.Annonce;
import ma.ensate.kriliya.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kriliya")
public class AnnonceController {


    @Autowired
    private AnnonceService annonceService;

    @GetMapping("/mesAnnonces/{id}")
    public List<Annonce> getAnnonceByUser(@PathVariable Integer id){
        return annonceService.getAnnonceByUser(id);
    }

    @PutMapping("/annonce/{id}")
    public Annonce update(@PathVariable Integer id, @RequestBody Annonce annonce){
       return  annonceService.updateAnnonce(id, annonce);
    }



    @DeleteMapping("/annonce/{id}")
    public void removeAnnonce(@PathVariable Integer id) {
        annonceService.removeAnnonce(id);
    }
}
