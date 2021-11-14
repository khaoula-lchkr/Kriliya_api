package ma.ensate.kriliya.controller;
import ma.ensate.kriliya.model.Annonce;
import ma.ensate.kriliya.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/annonce")
    public Annonce store(@RequestBody Annonce annonce){
        return annonceService.addAnnonce(annonce);
    }

    @PutMapping("annonce/{id}")
    public Annonce update(@PathVariable Integer id, @RequestBody Annonce annonce){
       return  annonceService.updateAnnonce(id, annonce);
    }

    @DeleteMapping("/annonce/{id}")
    public void delete(@PathVariable Integer id) {
        annonceService.removeAnnonce(id);
    }
}
