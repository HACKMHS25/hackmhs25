package org.openjfx;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewNavigator {
  public static Stage mainStage;

  public static void setMainStage(Stage stage) {
    mainStage = stage;
  }

  public static void switchViews(Scene scene) {
    if (scene != null) {
      mainStage.setScene(scene);
      mainStage.show();
    }
  }
}
