package ma.ensate.kriliya.repository;

import ma.ensate.kriliya.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {

public List<Annonce> findAllByUser_id(Integer id);

}
