package uni.miskolc.swgyak.bdsm.service;

import org.springframework.stereotype.Service;
import uni.miskolc.swgyak.bdsm.model.entities.Address;
import uni.miskolc.swgyak.bdsm.model.entities.User;
import uni.miskolc.swgyak.bdsm.persist.AddressRepository;
import uni.miskolc.swgyak.bdsm.service.interfaces.AddressService;
import uni.miskolc.swgyak.bdsm.service.interfaces.UserService;

import java.util.List;
@Service
public class AddressSerivceImpl implements AddressService {
    private AddressRepository addressRepository;
    private UserService userService;

    public AddressSerivceImpl(AddressRepository addressRepository, UserService userService){
        this.addressRepository = addressRepository;
        this.userService = userService;
    }
    @Override
    public void addAddressToUser(Address address, Long userId) {
        User user = userService.getUser(userId);
        address.setUser(user);
        addressRepository.save(address);

    }

    @Override
    public List<Address> GetAddressForUser(Long userId) {
        List<Address> addresses = addressRepository.findAllByUser_Id(userId);
        return  addresses;
    }
}
