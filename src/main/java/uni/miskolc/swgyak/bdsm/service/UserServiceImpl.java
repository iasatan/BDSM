package uni.miskolc.swgyak.bdsm.service;

import org.springframework.stereotype.Service;
import uni.miskolc.swgyak.bdsm.model.entities.User;
import uni.miskolc.swgyak.bdsm.persist.UserRepository;
import uni.miskolc.swgyak.bdsm.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        User user = User.builder()
                .userName("Adam")
                .email("saa")
                .role("User")
                .password("saa")
                .addresses(new ArrayList<>())
                .basket(new Basket())
                .build();
        userRepository.save(user);
        this.userRepository=userRepository;
    }
    @Override
    public Long addUser(User user) {
        Long id = userRepository.save(user).getId();
        return id;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    @Override
    public User getUser(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }
}
