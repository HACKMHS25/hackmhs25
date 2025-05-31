package org.openjfx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        BorderPane pane = new BorderPane();
        
        Image menu = new Image("https://static.thenounproject.com/png/345386-200.png");
        
          


        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Button bt = new Button("Funds");
        Button bt2 = new Button("Home");
        Button bt3 = new Button("Connect");
        HBox bar = new HBox(100);
        bar.getChildren().addAll(bt,bt2,bt3);
        bar.setAlignment(Pos.BOTTOM_CENTER);
        

        Rectangle rec = new Rectangle(600,200);
        rec.setArcHeight(100);
        rec.setArcWidth(100);
        rec.setFill(Color.rgb(211,211,211));

        Text welcText = new Text("Welcome!");
        








        
        


        
        var scene = new Scene(pane, 640, 480);
        

        pane.setBottom(bar);
        pane.setCenter(rec);
        pane.setTop(welcText);
        pane.setAlignment(welcText, Pos.TOP_CENTER);

        stage.setScene(scene);

        stage.show();
 
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}