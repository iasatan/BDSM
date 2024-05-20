package uni.miskolc.swgyak.bdsm.persist;

import org.springframework.data.repository.CrudRepository;
import uni.miskolc.swgyak.bdsm.model.entities.Basket;

public interface BasketRepository extends CrudRepository<Basket,Long> {
    Basket findByUserId(Long UserId);
}
