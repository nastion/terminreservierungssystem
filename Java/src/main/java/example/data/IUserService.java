package example.data;

public interface IUserService {
    public User findUserByName(String name);
    public void saveUser(User user);
}
