package uni.miskolc.swgyak.bdsm.service;

import org.springframework.stereotype.Service;
import uni.miskolc.swgyak.bdsm.model.entities.Basket;
import uni.miskolc.swgyak.bdsm.model.entities.Dvd;
import uni.miskolc.swgyak.bdsm.model.entities.User;
import uni.miskolc.swgyak.bdsm.persist.BasketRepository;
import uni.miskolc.swgyak.bdsm.service.interfaces.BasketService;
import uni.miskolc.swgyak.bdsm.service.interfaces.UserService;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    private BasketRepository basketRepository;
    private UserService userService;

    public BasketServiceImpl(BasketRepository basketRepository, UserService userService) {
        this.basketRepository = basketRepository;
        this.userService = userService;
    }

    @Override
    public void addToBasket(Dvd dvd, Long userId) {
        Basket basket = GetBasketForUser(userId);
        List<Dvd> dvdList = basket.getDvdList();
        dvdList.add(dvd);
        basket.setDvdList(dvdList);
        basketRepository.save(basket);
    }

    @Override
    public Basket GetBasketForUser(Long userId) {
        return basketRepository.findByUserId(userId);
    }
}
