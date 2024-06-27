package com.teky.jpfxcrmapp;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpfxcrmappApplication {

    public static void main(String[] args) {
        //SpringApplication.run(JpfxcrmappApplication.class, args);
        Application.launch(App.class);
    }
}
