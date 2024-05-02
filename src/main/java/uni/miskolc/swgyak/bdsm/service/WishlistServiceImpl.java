package uni.miskolc.swgyak.bdsm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.miskolc.swgyak.bdsm.model.entities.Dvd;
import uni.miskolc.swgyak.bdsm.model.entities.User;
import uni.miskolc.swgyak.bdsm.model.entities.Wishlist;
import uni.miskolc.swgyak.bdsm.persist.DvdRepository;
import uni.miskolc.swgyak.bdsm.persist.UserRepository;
import uni.miskolc.swgyak.bdsm.persist.WishlistRepository;
import uni.miskolc.swgyak.bdsm.service.interfaces.DvdService;
import uni.miskolc.swgyak.bdsm.service.interfaces.UserService;
import uni.miskolc.swgyak.bdsm.service.interfaces.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService {


    @Autowired
    private UserService userService;
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private DvdService dvdService;

    @Override
    public void addToWishlist(Long dvdId, Long userId) {
        User user = userService.getUser(userId);
        Dvd dvd = dvdService.getDvd(dvdId);
        Wishlist wishlist = wishlistRepository.findByUser_Id(userId);
        wishlist.getDvds().add(dvd);
        wishlistRepository.save(wishlist);

    }

    @Override
    public void removeFromWishlist(Long userId, Long dvdId) {
        User user = userService.getUser(userId);
        Dvd dvd = dvdService.getDvd(dvdId);
        Wishlist wishlist = user.getWishlist();
        wishlist.getDvds().remove(dvd);
        wishlistRepository.save(wishlist);
    }

    @Override
    public Wishlist getWishlistForUser(Long userId) {
        Wishlist wishlist = wishlistRepository.findById(userId).get();
        return wishlist;
    }

    @Override
    public void save(Wishlist wishlist) {
        wishlistRepository.save(wishlist);
    }
}
