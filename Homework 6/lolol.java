/* This program will utilize Java FX Programming. The instructions are noted as below
  Written by: Adrian Santos
              N00798593
  Date: 10/08/2016

Write a single program that produces Figure 14.52 (part b)  and
Figure 14.48  (part a)  and Figure 14.45 (part b).  All three should be visible at
the same time in a single window.
In addition, the clock (figure 14.52 part b)should have your name inside it, displayed
horizontally
between the 9 and the 3.  Note that the time displayed is based upon random numbers and
should vary with each run.
 A single program should only produce a single display of all three figures. Resizing of the
window should be
possible and should preserve the figures as much as possible.
*/

//Library Stage and Scene Imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class lolol extends Application{
    final static int RADIUS = 76;
    final static int GAP = 10;

  //Main method, since jGrasp will be used to check the program
  public static void main(String[] args) throws Exception{
     Application.launch(args);
    }

  @Override
  public void start(Stage primaryStage){

    int hour = (int)(Math.random()* 10);
    int minute = (int)(Math.random()* 31);
    int second = (int)(Math.random()* 93);


    StackPane fullStackPane = new StackPane();
    







    ClockPane clock = new ClockPane(hour, minute, second);
    String timeString = "          " + clock.getHour() + ":" + clock.getMinute() + ":"
    + clock.getSecond();
    //Create a label
    Label lblCurrentTime = new Label(timeString);
    gridClockPane.add(clock, 0, 1);
    gridClockPane.add(lblCurrentTime, 1, 1);




    //BorderPane
    GridPane gridPane = new GridPane();//GridPane
    StackPane stackPane = new StackPane(gridPane);
    Pane fanPane = new Pane(); //fanPane
    Pane hangmanPane = new Pane(); //hangmanPane
    Pane clockclockPane = new Pane ();


    gridPane.add(fanPane, 0, 0);
    gridPane.add(gridClockPane, 1, 0);
    gridPane.add(hangmanPane, 2, 0);


    //Create a scene and place it in the Stage
    Scene scene = new Scene(gridPane,800,330);
    primaryStage.setTitle("Adrian Santos - N00798593"); //Title of the document
    primaryStage.setScene(scene); // Put scene on the stage
    primaryStage.show(); // Display the stage


    /*borderPaneWhole.widthProperty().addListener(ov ->
    clock.setW(borderPaneWhole.getWidth()));
    borderPaneWhole.heightProperty().addListener(ov ->
    clock.setH(borderPaneWhole.getHeight()));
      */


    //Fan
    int x = RADIUS + GAP;
    int y = RADIUS + GAP;

    for (int i=0; i < 2; i++){
      for (int j = 0; j < 2; j++){
        //Create Scene 1
        Circle fan = new Circle();
        fan.setCenterX(x);
        fan.setCenterY(y);
        fan.setRadius(RADIUS);
        fan.setStroke(Color.BLACK);
        fan.setFill(Color.WHITE);
        fanPane.getChildren().add(fan);

        for (int k =30; k < 360; k+= 90){
          Arc arc = new Arc(x, y, RADIUS - 15, RADIUS - 15, k, 30);
          arc.setStroke(Color.BLACK);
          arc.setFill(Color.BLACK);
          arc.setType(ArcType.ROUND);
          fanPane.getChildren().add(arc);
        }
       x += RADIUS * 2 + GAP;
      }
      //Reset the center
      x = RADIUS + GAP;
      y += RADIUS * 2 + GAP;
    }

    //Hangman
    Circle circle = new Circle(20);
    circle.setCenterX(100.0f);
    circle.setCenterY(70.0f);
    circle.setFill(Color.TRANSPARENT);
    circle.setStroke(Color.BLACK);


    Line line1 = new Line();//Correct - Long V Pole
    line1.setStartX(40.0f);
    line1.setStartY(220.0f);
    line1.setEndX(40.0f);
    line1.setEndY(40.0f);

    Line line2 = new Line();//Correct - H pole
    line2.setStartX(40.0f);
    line2.setStartY(40.0f);
    line2.setEndX(100.0f);
    line2.setEndY(40.0f);

    Line line3 = new Line();//Correct - Short V Pole
    line3.setStartX(100.0f);
    line3.setStartY(50.0f);
    line3.setEndX(100.0f);
    line3.setEndY(40.0f);

    Line line4 = new Line();//Correct - Body
    line4.setStartX(100.0f);
    line4.setStartY(90.0f);
    line4.setEndX(100.0f);
    line4.setEndY(170.0f);

    Line line5 = new Line();//Correct R Leg
    line5.setStartX(100.0f);
    line5.setStartY(170.0f);
    line5.setEndX(70.0f);
    line5.setEndY(210.0f);

    Line line6 = new Line();//Correct L Leg
    line6.setStartX(100.0f);
    line6.setStartY(170.0f);
    line6.setEndX(130.0f);
    line6.setEndY(210.0f);

    Line line7 = new Line();//Correct - R Arm
    line7.setStartX(83.0f);
    line7.setStartY(80.0f);
    line7.setEndX(53.0f);
    line7.setEndY(120.0f);


    Line line8 = new Line();//Correct - L Arm
    line8.setStartX(117.0f);
    line8.setStartY(80.0f);
    line8.setEndX(147.0f);
    line8.setEndY(120.0f);

    Arc arc = new Arc();
    arc.setCenterX(40.0f);
    arc.setCenterY(245.0f);
    arc.setRadiusX(25.0f);
    arc.setRadiusY(25.0f);
    arc.setStartAngle(0.0f);
    arc.setLength(180.0f);
    arc.setFill(Color.TRANSPARENT);
    arc.setStroke(Color.BLACK);
    arc.setType(ArcType.OPEN);

    hangmanPane.getChildren().addAll(circle, line1, line2, line3, line4, line5, line6, line7, line8, arc);

  }
}
