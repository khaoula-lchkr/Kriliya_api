package ma.ensate.kriliya.service;
import ma.ensate.kriliya.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

    public void RemoveUser(Integer id);
    public List<User> getAllUsers();
}
