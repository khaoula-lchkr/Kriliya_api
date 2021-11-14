package ma.ensate.kriliya.service;

import ma.ensate.kriliya.model.Annonce;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnnonceService {

    public List<Annonce> getAnnonceByUser(Integer id);
    public Annonce updateAnnonce(Integer id, Annonce annonce);
    public void removeAnnonce(Integer id);
    public Annonce addAnnonce(Annonce annonce);
}
