package example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repo;
    @Override
    public User findUserByName(String name) {
        return repo.findUserByName(name);
    }

    @Override
    public void saveUser(User user) {
        repo.save(user);
    }
}
