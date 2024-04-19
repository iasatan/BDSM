package uni.miskolc.swgyak.bdsm.service.interfaces;

import uni.miskolc.swgyak.bdsm.model.entities.Address;
import uni.miskolc.swgyak.bdsm.model.entities.Basket;
import uni.miskolc.swgyak.bdsm.model.entities.Dvd;

import java.util.List;

public interface BasketService {
    void addToBasket(Dvd dvd, Long userId);
    Basket GetBasketForUser(Long userId);
}
