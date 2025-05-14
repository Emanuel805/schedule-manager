package com.emanuel805.schedulemanager.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

    @Override
    public void start(Stage primarystage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/schedule_manager.fxml"));
        Label label = new Label("Hello World");
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1280, 720);

        primarystage.setTitle("Schedule Manager");
        primarystage.setScene(scene);
        primarystage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
