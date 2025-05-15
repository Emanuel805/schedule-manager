package com.emanuel805.schedulemanager.ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;




public class JavaFxApplication extends Application {

    @Override
    public void start(Stage primarystage) throws Exception {
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/schedule_manager.fxml"));
        Group root = new Group();
        Scene scene = new Scene(root, 1280, 720, Color.BLACK);
        Stage stage = new Stage();

        Text text = new Text();
        text.setText("interface at\n " +
                "https://www.figma.com/design/kRYdnRi132e7ImZTHFvVpc/Untitled?node-id=0-1&t=lx6uNMzIXXEFvBje-1");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        text.setFill(Color.WHITE);

        Image image = new Image("/cat.gif");
        ImageView imageView = new ImageView(image);
        imageView.setX(400);
        imageView.setY(400);


        root.getChildren().add(text);
        root.getChildren().add(imageView);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
