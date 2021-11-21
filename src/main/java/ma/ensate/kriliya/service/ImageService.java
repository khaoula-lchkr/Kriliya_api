package ma.ensate.kriliya.service;

import ma.ensate.kriliya.model.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ImageService {

    public List<Image> addImage(int id, MultipartFile[] files);
    public void removeImage(Integer id);
    public Image updateImage(Integer id, Image image);
}
