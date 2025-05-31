package org.openjfx;

import atlantafx.base.controls.Card;
import atlantafx.base.controls.RingProgressIndicator;
import atlantafx.base.theme.Dracula;
import atlantafx.base.theme.Styles;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Application.setUserAgentStylesheet(new Dracula().getUserAgentStylesheet());
        var pane = new BorderPane();
        var scene = new Scene(pane, 640, 480);
        var tabs = new TabPane(new Tab("Dashboard"), new Tab("Connect"), new Tab("Finance"));

        // TODO: fix center logic
        var centerTop = new Group();
        var centerBot = new Group();
        var centerVbox = new VBox(
                centerTop,
                centerBot);

        var bottomRightPane = new StackPane();
        var indicator = new RingProgressIndicator(0.25, false);
        var card = new Card();
        bottomRightPane.setPrefHeight(800);
        StackPane.setAlignment(indicator, Pos.TOP_RIGHT);
        StackPane.setAlignment(card, Pos.BOTTOM_RIGHT);
        // card.setBody(node);
        card.setMinSize(300, 800);
        card.setMaxSize(300, 800);

        indicator.setMinSize(150, 150);
        indicator.autosize();
        centerTop.getChildren().add(indicator);
        bottomRightPane.getChildren().add(card);

        tabs.getStyleClass().add(Styles.TABS_CLASSIC);
        tabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        pane.setTop(tabs);
        pane.setCenter(centerVbox);
        pane.setBottom(bottomRightPane);

        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
