package uni.miskolc.swgyak.bdsm.persist;

import org.springframework.data.repository.CrudRepository;
import uni.miskolc.swgyak.bdsm.model.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
