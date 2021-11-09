package ma.ensate.kriliya.controller;

import ma.ensate.kriliya.model.Annonce;
import ma.ensate.kriliya.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @PostMapping("/save")
    public String add(@RequestBody Annonce annonce){
        annonceService.saveAnnonce(annonce);
        return "Saved";
    }


    @GetMapping("get")
    public List<Annonce> get(){
        return annonceService.getAllAnnonce();
    }
}
