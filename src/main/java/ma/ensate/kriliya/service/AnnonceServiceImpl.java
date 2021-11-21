package ma.ensate.kriliya.service;

import ma.ensate.kriliya.model.Annonce;
import ma.ensate.kriliya.model.Image;
import ma.ensate.kriliya.repository.AnnonceRepository;
import ma.ensate.kriliya.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceServiceImpl implements AnnonceService{

    @Autowired
    private AnnonceRepository annoncerepository;

    @Autowired
    private ImageRepository imageRepository;


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
            if(!annonceToUpdate.getDate().equals(updatedAnnonce.getDate())){
                annonceToUpdate.setDate(updatedAnnonce.getDate());
            }
            if(!annonceToUpdate.getMeuble().equals(updatedAnnonce.getMeuble())){
                annonceToUpdate.setMeuble(updatedAnnonce.getMeuble());
            }
        }
        return annonceToUpdate;
    }

    @Override
    public void removeAnnonce(Integer id) {
        annoncerepository.deleteById(id);
    }

    @Override
    public Annonce addAnnonce(Annonce annonce, MultipartFile[] files){
        List<Image> images = new ArrayList<>();
        for (MultipartFile file: files) {
            Image image = new Image();
            try {
                image.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            images.add(image);
        }
        Annonce insertedAnnonce = annoncerepository.save(annonce);
        int id_annonce = insertedAnnonce.getId();
        for (Image img: images) {
            imageRepository.save(new Image(img.getImage(), id_annonce));
        }
        return insertedAnnonce;
    }

    @Override
    public Annonce getAnnonce(Integer id) {
        Optional<Annonce> annonce = annoncerepository.findById(id);
        Annonce ann = null;
        if(annonce.isPresent()){
            ann = annonce.get();
        }
        return ann;
    }
}
