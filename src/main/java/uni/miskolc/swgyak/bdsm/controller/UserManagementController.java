package uni.miskolc.swgyak.bdsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uni.miskolc.swgyak.bdsm.model.entities.Address;
import uni.miskolc.swgyak.bdsm.model.entities.Basket;
import uni.miskolc.swgyak.bdsm.model.entities.Dvd;
import uni.miskolc.swgyak.bdsm.model.entities.User;
import uni.miskolc.swgyak.bdsm.service.interfaces.AddressService;
import uni.miskolc.swgyak.bdsm.service.interfaces.BasketService;
import uni.miskolc.swgyak.bdsm.service.interfaces.DvdService;
import uni.miskolc.swgyak.bdsm.service.interfaces.UserService;

import java.util.List;
import java.util.Scanner;

@Component
public class UserManagementController {
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private BasketService basketService;
    @Autowired
    private DvdService dvdService;

    public void addUser(Scanner scanner) {
        System.out.println("name?");
        String userName = scanner.nextLine();
        System.out.println("email?");
        String email = scanner.nextLine();
        System.out.println("password?");
        String password = scanner.nextLine();
        System.out.println("Role?");
        String role = scanner.nextLine();
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        Basket basket = new Basket();
        basket.setUser(user);
        user.setBasket(basket);
        Long id = userService.addUser(user);
        basketService.saveBasket(basket);
        System.out.println(id);
    }

    public void listUsers() {
        System.out.println("Users:");
        List<User> users = userService.getAllUser();
        for (User user : users) {
            System.out.println(user);

        }
    }

    public void addAddressToUser(Scanner scanner) {
        System.out.println("userId?");
        Long userId = Long.decode(scanner.nextLine());
        Address address = new Address();
        System.out.println("Country?");
        address.setCountry(scanner.nextLine());
        System.out.println("postalCode?");
        address.setPostalCode(scanner.nextLine());
        address.setCity("Miskolc");
        address.setStreet("asd");
        addressService.addAddressToUser(address, userId);
        System.out.println(addressService.GetAddressForUser(userId));
    }

    public void getBasket(Scanner scanner) {
        System.out.println("UserId?");
        Long userId = Long.decode(scanner.nextLine());
        List<Dvd> dvds = basketService.GetBasketForUser(userId).getDvdList();
        for (Dvd dvd : dvds) {
            System.out.println(dvd);
        }
    }

    public void addToBasket(Scanner scanner) {
        System.out.println("UserId?");
        Long userId = Long.decode(scanner.nextLine());
        System.out.println("DvdId?");
        Long dvdId = Long.decode(scanner.nextLine());
        basketService.addToBasket(dvdService.getDvd(dvdId), userId);
    }
}
