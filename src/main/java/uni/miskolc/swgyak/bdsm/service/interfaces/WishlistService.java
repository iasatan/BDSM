package uni.miskolc.swgyak.bdsm.service.interfaces;

import uni.miskolc.swgyak.bdsm.model.entities.Wishlist;

public interface WishlistService {
    void addToWishlist(Long dvdId, Long userId);
    void removeFromWishlist(Long userId, Long dvdId);
    Wishlist getWishlistForUser(Long userId);

    void save(Wishlist wishlist);
}
