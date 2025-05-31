package org.openjfx;

import java.awt.Button;

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
        var tabs = new TabPane();
        var dashboardTab = new Tab("Dashboard");
        var connectTab = new Tab("Dashboard");
        var financeTab = new Tab("Dashboard");

        var bottomRightPane = new StackPane();
        var indicator = new RingProgressIndicator(0.25, false);
        var card = new Card();
        var centerCard = new Card();
        var centerContainer = new VBox(centerCard);
        var centerContentVbox = new VBox(indicator);

        tabs.getTabs().setAll(dashboardTab, connectTab, financeTab);
        bottomRightPane.setPrefHeight(700);
        StackPane.setAlignment(indicator, Pos.TOP_RIGHT);
        StackPane.setAlignment(card, Pos.BOTTOM_RIGHT);
        // card.setBody(node);
        card.setMinSize(300, 700);
        card.setMaxSize(300, 700);
        // card.visibleProperty().set(false);
        centerContentVbox.setAlignment(Pos.CENTER);

        indicator.setMinSize(300, 300);
        indicator.autosize();
        bottomRightPane.getChildren().add(card);
        centerCard.setBody(centerContentVbox);
        centerContainer.setAlignment(Pos.CENTER);

        tabs.getStyleClass().add(Styles.TABS_CLASSIC);
        tabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        pane.setTop(tabs);
        pane.setCenter(centerContainer);
        pane.setBottom(bottomRightPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
