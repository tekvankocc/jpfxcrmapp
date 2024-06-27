package com.teky.jpfxcrmapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app.fxml"));

        Scene scene = new Scene(loader.load(), 800, 800);
        stage.setScene(scene);
        stage.setTitle("FX CRM");
        stage.show();
    }

    public static <T extends Object> T getInstance(Class<T> type) {
        return context.getBean(type);
    }

    @Override
    public void init() throws Exception {
        super.init();
        context = new SpringApplicationBuilder(JpfxcrmappApplication.class).run();
    }

    private static ConfigurableApplicationContext context;
}
