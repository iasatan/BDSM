package uni.miskolc.swgyak.bdsm.service.interfaces;

import uni.miskolc.swgyak.bdsm.model.entities.User;

import java.util.List;

public interface UserService {
    Long addUser(User user);
    List<User> getAllUser();

    User getUser(Long id);
}
