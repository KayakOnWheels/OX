package com.ox;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.ox.ioController.InputController.enterMenu;

@SpringBootApplication
public class OxApplication {

    public static void main(String[] args) {

        //SpringApplication.run(OxApplication.class, args);
        enterMenu();

    }
}
