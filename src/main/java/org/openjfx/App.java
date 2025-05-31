package org.openjfx;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;

import atlantafx.base.controls.Card;
import atlantafx.base.controls.CustomTextField;
import atlantafx.base.controls.RingProgressIndicator;
import atlantafx.base.theme.Dracula;
import atlantafx.base.theme.Styles;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
        ViewNavigator.setMainStage(stage);
        var root = new BorderPane();
        var scene = new Scene(root, 640, 480);
        var tabs = new TabPane();
        var dashboardTab = new Tab("Dashboard");
        var connectTab = new Tab("Connect");
        var financeTab = new Tab("Finance");

        dashboardTab.setContent(getDashboard());
        connectTab.setContent(getConnect());
        financeTab.setContent(getFinance());

        tabs.getTabs().setAll(dashboardTab, connectTab, financeTab);
        tabs.getStyleClass().add(Styles.TABS_CLASSIC);
        tabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        root.setTop(tabs);

        ViewNavigator.switchViews(scene);
    }

    public Node getDashboard() {
        var pane = new BorderPane();

        var bottomRightPane = new StackPane();
        var indicator = new RingProgressIndicator(0.25, false);
        var card = new Card();
        var centerCard = new Card();
        var centerContainer = new VBox(centerCard);
        var centerContentVbox = new VBox(indicator);

        bottomRightPane.setPrefHeight(700);
        StackPane.setAlignment(indicator, Pos.TOP_RIGHT);
        StackPane.setAlignment(card, Pos.BOTTOM_RIGHT);
        // card.setBody(node);
        card.setMinSize(300, 700);
        card.setMaxSize(300, 700);
        // card.visibleProperty().set(false);

        indicator.setMinSize(300, 300);
        indicator.autosize();
        bottomRightPane.getChildren().add(card);
        centerCard.setBody(centerContentVbox);
        centerContainer.setAlignment(Pos.CENTER);

        pane.setCenter(centerContainer);
        pane.setBottom(bottomRightPane);

        return pane;
    }

    public Node getConnect() {
        var pane = new BorderPane();
        pane.setTop(new Button("HAHAHAHAHAHAHAHA"));
        return pane;
    }

    public Node getFinance() {
        var pane = new BorderPane();
        var vbox = new VBox();
        var hbox = new HBox();

        Label bal = new Label("0");
        Label goal = new Label("0");
        Label diff = new Label("0");
        var balPane = new TitledPane("Balance", bal);
        var goalPane = new TitledPane("Goal", goal);
        var diffPane = new TitledPane("Difference", diff);

        bal.getStyleClass().addAll(Styles.SUCCESS);
        goal.getStyleClass().addAll(Styles.SUCCESS);
        diff.getStyleClass().addAll(Styles.SUCCESS);
        hbox.getChildren().setAll(balPane, goalPane, diffPane);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10, 30, 0, 0));
        HBox add = new HBox();

        var expense = new CustomTextField();
        expense.setPromptText("expense");
        expense.setPrefWidth(150);

        var income = new CustomTextField();
        income.setPromptText("income");
        income.setPrefWidth(150);

        var submit = new Button("submit");
        add.getChildren().addAll(expense, income, submit);
        add.setPadding(new Insets(10, 30, 0, 0));
        add.setSpacing(10);

        var date = new TableColumn<Transaction, String>("date");
        var time = new TableColumn<Transaction, String>("time");
        var exp = new TableColumn<Transaction, String>("expense");
        var inc = new TableColumn<Transaction, String>("income");
        var table = new TableView<Transaction>();

        date.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLocalDate().toString()));
        time.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLocalTime().toString()));
        exp.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getExpense())));
        inc.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIncome())));

        table.getColumns().addAll(date, time, exp, inc);
        table.setPadding(new Insets(10, 30, 0, 0));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_LAST_COLUMN);
        table.setMinSize(800, 400);

        submit.setOnMouseClicked(event -> {
            Transaction tx = new Transaction(LocalDate.now(), LocalTime.now(), Double.parseDouble(expense.getText()),
                    Double.parseDouble(income.getText()));
            table.getItems().add(tx);

            expense.clear();
            income.clear();

        });

        vbox.getChildren().addAll(hbox, add, table);
        pane.setRight(vbox);

        return pane;
    }

    public static void main(String[] args) {
        launch();
    }

}
