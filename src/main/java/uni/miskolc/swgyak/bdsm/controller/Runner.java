package uni.miskolc.swgyak.bdsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private UserManagementController userManagementController;
    @Autowired
    private AdminController adminController;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Console app runs"); //sout
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Command?");
            System.out.println("EXIT/AddUser/ListUsers/AddDvd/ListDvds/GetDvd/DeleteDvd/ListWishlist/AddDvdToWishlist/RemoveFromWishlist");
            String command = scanner.nextLine();
            if (command.equals("Exit")) {
                break;
            }
            switch (command) {
                case "AddUser":
                    userManagementController.addUser(scanner);
                    break;
                case "ListUsers":
                    userManagementController.listUsers();
                    break;
                case "AddAddressToUser":
                    userManagementController.addAddressToUser(scanner);
                    break;
                case "AddDvd":
                    adminController.addDvd(scanner);
                    break;
                case "ListDvds":
                    adminController.listDvds();
                    break;
                case "GetDvd":
                    adminController.getDvd(scanner);
                    break;
                case "DeleteDvd":
                    adminController.deleteDvd(scanner);
                    break;
                case "ListWishlist":
                    userManagementController.getWishlistForUser(scanner);
                    break;
                case "AddDvdToWishlist":
                    userManagementController.addToWishlist(scanner);
                    break;
                case "RemoveFromWishlist":
                    userManagementController.removeFromWishlist(scanner);
                    break;
            }
        }
    }


}
