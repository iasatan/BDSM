package uni.miskolc.swgyak.bdsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uni.miskolc.swgyak.bdsm.model.entities.User;
import uni.miskolc.swgyak.bdsm.service.interfaces.UserService;

import java.util.List;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private UserManagementController userManagementController;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Console app runs"); //sout
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Command?");
            System.out.println("EXIT/AddUser/ListUsers");
            String command = scanner.nextLine();
            if(command.equals("Exit")){
                break;
            }
            switch (command){
                case "AddUser":
                    userManagementController.addUser(scanner);
                    break;
                case "ListUsers":
                    userManagementController.listUsers();
                    break;
                case "AddBookToUser":
                    userManagementController.addBookToUser(scanner);
                    break;
            }
        }
    }


}
