package ma.ensate.kriliya.service;

import ma.ensate.kriliya.model.Annonce;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnnonceService {

    public Annonce saveAnnonce(Annonce annonce);
    public List<Annonce> getAllAnnonce();
}
