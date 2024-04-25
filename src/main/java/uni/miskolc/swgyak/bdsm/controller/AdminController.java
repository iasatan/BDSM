package uni.miskolc.swgyak.bdsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uni.miskolc.swgyak.bdsm.model.entities.Dvd;
import uni.miskolc.swgyak.bdsm.service.interfaces.DvdService;

import java.util.Scanner;

@Component
public class AdminController {
    @Autowired
    private DvdService dvdService;

    public void addDvd(Scanner sc) {
        // scan dvd details
        System.out.println("Title?");
        String title = sc.nextLine();
        System.out.println("Year?");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("Genre?");
        String genre = sc.nextLine();
        System.out.println("Price?");

        double price = Double.parseDouble(sc.nextLine());
        Dvd dvd = new Dvd();
        dvd.setTitle(title);
        dvd.setReleaseYear(year);
        dvd.setGenre(genre);
        dvd.setPrice(price);

        dvdService.addDvd(dvd);
    }

    public void listDvds() {
        System.out.println("Dvds:");
        dvdService.getAllDvd().forEach(System.out::println);
    }

    public void getDvd(Scanner sc) {
        System.out.println("Id?");
        Long id = Long.decode(sc.nextLine());
        System.out.println(dvdService.getDvd(id));
    }

    public void deleteDvd(Scanner sc) {
        System.out.println("Id?");
        Long id = Long.decode(sc.nextLine());
        dvdService.deleteDvd(id);
    }
}
