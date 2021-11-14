package ma.ensate.kriliya.service;

import ma.ensate.kriliya.model.Annonce;
import ma.ensate.kriliya.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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
            if(!(annonceToUpdate.getChambres() == updatedAnnonce.getChambres())){
                annonceToUpdate.setChambres(updatedAnnonce.getChambres());
            }
            if(!annonceToUpdate.getDescription().equals(updatedAnnonce.getDescription())){
                annonceToUpdate.setDescription(updatedAnnonce.getDescription());
            }
            if(!(annonceToUpdate.getPrix() == updatedAnnonce.getPrix())){
                annonceToUpdate.setPrix(updatedAnnonce.getPrix());
            }
            if(!annonceToUpdate.getTitre().equals(updatedAnnonce.getTitre())){
                annonceToUpdate.setTitre(updatedAnnonce.getTitre());
            }
            if(!annonceToUpdate.getChauffage().equals(updatedAnnonce.getChauffage())){
                annonceToUpdate.setChauffage(updatedAnnonce.getChauffage());
            }
            if(!annonceToUpdate.getMachineALaver().equals(updatedAnnonce.getMachineALaver())){
                annonceToUpdate.setMachineALaver(updatedAnnonce.getMachineALaver());
            }
            if(!annonceToUpdate.getQuartier().equals(updatedAnnonce.getQuartier())){
                annonceToUpdate.setQuartier(updatedAnnonce.getQuartier());
            }
            if(!annonceToUpdate.getRefrigerateur().equals(updatedAnnonce.getRefrigerateur())){
                annonceToUpdate.setRefrigerateur(updatedAnnonce.getRefrigerateur());
            }
            if(!annonceToUpdate.getType().equals(updatedAnnonce.getType())){
                annonceToUpdate.setType(updatedAnnonce.getType());
            }
            if(!annonceToUpdate.getVille().equals(updatedAnnonce.getVille())){
                annonceToUpdate.setVille(updatedAnnonce.getVille());
            }
            if(annonceToUpdate.getSurface() == updatedAnnonce.getSurface()){
                annonceToUpdate.setSurface(updatedAnnonce.getSurface());
            }
            if(!annonceToUpdate.getWifi().equals(updatedAnnonce.getWifi())){
                annonceToUpdate.setWifi(updatedAnnonce.getWifi());
            }
            if(!annonceToUpdate.getPreference().equals(updatedAnnonce.getPreference())){
                annonceToUpdate.setPreference(updatedAnnonce.getPreference());
            }
        }
        return annonceToUpdate;
    }

    @Override
    public void removeAnnonce(Integer id) {
        annoncerepository.deleteById(id);
    }

    @Override
    public Annonce addAnnonce(Annonce annonce) { return annoncerepository.save(annonce); }
}
