package com.ox;

import com.ox.actors.HumanPlayer;
import com.ox.logic.OxRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.ox.IOController.InputController.enterMenu;

@SpringBootApplication
public class OxApplication {

    public static void main(String[] args) {

        //SpringApplication.run(OxApplication.class, args);
        enterMenu();

    }

}
