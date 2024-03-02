package uni.miskolc.swgyak.bdsm.service.interfaces;

import uni.miskolc.swgyak.bdsm.model.entities.Address;

import java.util.List;

public interface AddressService {
    void addAddressToUser(Address address, Long userId);
    List<Address> GetAddressForUser(Long userId);
}
