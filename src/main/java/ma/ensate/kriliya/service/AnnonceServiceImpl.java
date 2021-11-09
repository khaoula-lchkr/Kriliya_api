package ma.ensate.kriliya.service;

import ma.ensate.kriliya.model.Annonce;
import ma.ensate.kriliya.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService{

    @Autowired
    private AnnonceRepository annoncerepository;

    @Override
    public Annonce saveAnnonce(Annonce annonce) {
        return annoncerepository.save(annonce);
    }

    @Override
    public List<Annonce> getAllAnnonce() {
        return annoncerepository.findAll();
    }
}
