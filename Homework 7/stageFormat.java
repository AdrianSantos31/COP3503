/*

Write a program that uses a BorderPane that:
1. starts with two buttons on the bottom and your name on the screen and the two buttons should be programmed for up and down
instead of left and right, similar to example 16.2. Only use the left half of the center for your name (1 row 2 columns). See number 5
below for the right half of the center. So you could use a GridPane for the center.
2. enhances 16.2 with checkboxes that permit your name to be bold and/or italicized but the font must be  something other
than Times New Roman, and these checkboxes must be on the left (not the right) , similar to example 16.3
3. enhances 16.3 with  3 radio buttons that paint the text colors that are colors of your choice, but not red, green or blue,
and these radio buttons must be on the right (not the left), similar to example 16.4. You can use RGB coloring if you like.
4. puts a bouncing red rectangle (not a ball)  at the top  with a slider for speed (see see 16.12).
5. puts an mp4 video of something you have produced in the right half of the center with the same controls as in 16.14.
(use http://www.unf.edu/~nxxxxyyyy/name.mp4)
This will be in a folder that you create named homepage on Osprey.

All of this should be in a single file, but the code must show a variety of classes that use extends just as the author does
in chapter 16. Program incrementally, doing one "feature" at a time.

    ******************************
    *  Written by: Adrian Santos *
    *  Date: 11/20/2016          *
    ******************************
*/

//Library Imports

import javafx.beans.binding.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.scene.layout.StackPane;



public class stageFormat extends Application{
    public static void main(String[] args) throws Exception{
      Application.launch(args);
      }

    @Override
    public void start(Stage primaryStage){

      //Pane Declaration
      BorderPane mainBorderPane = new BorderPane();

      mainBorderPane.setStyle("-fx-border-width: 2px; -fx-border-color: gray");

      GridPane centerGridPane = new GridPane();
      //set pane borders visible*******************
      centerGridPane.setGridLinesVisible(true);//Testing Pane Set-up
      mainBorderPane.setVisible(true);//Testing border visibility

      //Main Location
      StackPane root = new StackPane(mainBorderPane);
      NumberBinding maxScale = Bindings.min(root.widthProperty().divide(1200),
      root.heightProperty().divide(500));


      //Bind Border Pane scaling
      mainBorderPane.scaleXProperty().bind(maxScale);
      mainBorderPane.scaleYProperty().bind(maxScale);


      //Create a scene and place it on Stage
      Scene scene = new Scene(root, 1200, 500);
      primaryStage.setTitle("Adrian Santos - N00798593"); //Title of the document
      primaryStage.setScene(scene); // Put scene on the stage
      primaryStage.show(); // Display the stage


      //***************Label Test***********************
      //Label top
      String topStringTest = "Slider and Bouncing Ball";
      Label lblTop = new Label (topStringTest);

      //Label left
      String leftStringTest = "Bold and Italic";
      Label lblLeft = new Label (leftStringTest);

      //Label right
      String rightStringTest = "Colors";
      Label lblRight = new Label (rightStringTest);

      //Label Bottom
      String bottomStringTest = "Control up or down";
      Label lblBottom = new Label (bottomStringTest);

      //Label L gridPane
      String leftGridPaneTest = "Name";
      Label lblLeftGridPane = new Label (leftGridPaneTest);

      //Label R gridPane
      String rightGridPaneTest = "Video";
      Label lblRightGridPane = new Label (rightGridPaneTest);

      centerGridPane.add(lblLeftGridPane, 0, 0);
      centerGridPane.add(lblRightGridPane, 1, 0);

      mainBorderPane.setTop(lblTop);
      mainBorderPane.setAlignment(lblTop, Pos.CENTER);

      mainBorderPane.setLeft(lblLeft);
      mainBorderPane.setAlignment(lblLeft, Pos.CENTER);

      mainBorderPane.setCenter(centerGridPane);
      mainBorderPane.setAlignment(centerGridPane, Pos.CENTER);

      mainBorderPane.setRight(lblRight);
      mainBorderPane.setAlignment(lblRight, Pos.CENTER);

      mainBorderPane.setBottom(lblBottom);
      mainBorderPane.setAlignment(lblBottom, Pos.CENTER);

    }

}
