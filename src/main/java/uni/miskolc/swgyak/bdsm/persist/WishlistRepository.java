package uni.miskolc.swgyak.bdsm.persist;

import org.springframework.data.repository.CrudRepository;
import uni.miskolc.swgyak.bdsm.model.entities.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist, Long> {
    Wishlist findAllBy();
    Wishlist findByUser_Id(Long userId);
}
