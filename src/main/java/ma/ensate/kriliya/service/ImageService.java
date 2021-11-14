package ma.ensate.kriliya.service;

import ma.ensate.kriliya.model.Image;
import org.springframework.stereotype.Service;

@Service
public interface ImageService {

    public void removeImage(Integer id);
    public Image updateImage(Integer id, Image image);
}
