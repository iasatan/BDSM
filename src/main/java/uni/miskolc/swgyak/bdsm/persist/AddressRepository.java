package uni.miskolc.swgyak.bdsm.persist;

import org.springframework.data.repository.CrudRepository;
import uni.miskolc.swgyak.bdsm.model.entities.Address;
import uni.miskolc.swgyak.bdsm.model.entities.User;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAllByUser_Id(Long userId);

}
