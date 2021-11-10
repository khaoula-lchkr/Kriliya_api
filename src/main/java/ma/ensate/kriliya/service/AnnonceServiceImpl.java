package ma.ensate.kriliya.service;

import ma.ensate.kriliya.model.Annonce;
import ma.ensate.kriliya.model.Image;
import ma.ensate.kriliya.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceServiceImpl implements AnnonceService{

    @Autowired
    private AnnonceRepository annoncerepository;


    @Override
    public List<Annonce> getAnnonceByUser(Integer id) {
        return annoncerepository.findAllByUser_id(id);
    }

    @Override
    @Transactional
    public Annonce updateAnnonce(Integer id, Annonce updatedAnnonce) {
        Optional<Annonce> annonce = annoncerepository.findById(id);
        Annonce annonceToUpdate = null;
        if(annonce.isPresent()){
            annonceToUpdate = annonce.get();
            annonceToUpdate.setChambres(updatedAnnonce.getChambres());
            annonceToUpdate.setDescription(updatedAnnonce.getDescription());
            annonceToUpdate.setPrix(updatedAnnonce.getPrix());
            annonceToUpdate.setTitre(updatedAnnonce.getTitre());
            annonceToUpdate.setChauffage(updatedAnnonce.getChauffage());
            annonceToUpdate.setMachineALaver(updatedAnnonce.getMachineALaver());
            annonceToUpdate.setChauffage(updatedAnnonce.getChauffage());
            annonceToUpdate.setQuartier(updatedAnnonce.getQuartier());
            annonceToUpdate.setRefrigerateur(updatedAnnonce.getRefrigerateur());
            annonceToUpdate.setType(updatedAnnonce.getType());
            annonceToUpdate.setVille(updatedAnnonce.getVille());
            annonceToUpdate.setSurface(updatedAnnonce.getSurface());
            annonceToUpdate.setWifi(updatedAnnonce.getWifi());
            annonceToUpdate.setPreference(updatedAnnonce.getPreference());
        }
        return annonceToUpdate;
    }

    @Override
    public void removeAnnonce(Integer id) {
        annoncerepository.deleteById(id);
    }
}
