package uni.miskolc.swgyak.bdsm.persist;

import org.springframework.data.repository.CrudRepository;
import uni.miskolc.swgyak.bdsm.model.entities.Dvd;

public interface DvdRepository extends CrudRepository<Dvd, Long> {
}

