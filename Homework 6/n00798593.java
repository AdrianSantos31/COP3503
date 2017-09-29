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
import javafx.beans.binding.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.Calendar;
import java.util.GregorianCalendar;



//Displays Three Figures
public class n00798593 extends Application{
    final static int RADIUS = 75;
    final static int GAP = 10;

  //Main method, since jGrasp will be used to check the program
  public static void main(String[] args) throws Exception{
     Application.launch(args);
    }

  @Override
  public void start(Stage primaryStage){

    Pane fanPane = new Pane(); //fanPane
    fanPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    Pane hangmanPane = new Pane(); //hangmanPane
    hangmanPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    BorderPane borderClockPane = new BorderPane();//borderClockPane

    GridPane gridPane = new GridPane();//Main Grid Pane

    //gridPane.setGridLinesVisible(true);//Testing Pane Set-up

    //Binding Grid Pane
    gridPane.setMaxSize(800,330);//Pane Size
    gridPane.setMinSize(800,330);

    StackPane root = new StackPane(gridPane);//Main Stack Pane
    NumberBinding maxScale = Bindings.min(root.widthProperty().divide(800),
    root.heightProperty().divide(330));

    gridPane.scaleXProperty().bind(maxScale);
    gridPane.scaleYProperty().bind(maxScale);

    //GridPane Location
    gridPane.add(fanPane, 0, 0);
    gridPane.add(borderClockPane, 1, 0);
    gridPane.add(hangmanPane, 2,0);


    //Create a scene and place it in the Stage
    Scene scene = new Scene(root,800,330);
    primaryStage.setTitle("Adrian Santos - N00798593"); //Title of the document
    primaryStage.setScene(scene); // Put scene on the stage
    primaryStage.show(); // Display the stage

    //Clock
    int hour = (int)(Math.random()* 10);
    int minute = (int)(Math.random()* 31);
    int second = (int)(Math.random()* 93);

    ClockPane clock = new ClockPane(hour, minute, second);
    String timeString = "             " + clock.getHour() + ":" + clock.getMinute() + ":"
    + clock.getSecond();
    Label lblCurrentTime = new Label(timeString);
    borderClockPane.setCenter(clock);
    borderClockPane.setBottom(lblCurrentTime);
    borderClockPane.setAlignment(lblCurrentTime, Pos.CENTER);

    //Fan
    int x = RADIUS + GAP;
    int y = RADIUS + GAP;

    for (int i=0; i < 2; i++){
      for (int j = 0; j < 2; j++){
        Circle fan = new Circle();//Create a Circle
        fan.setCenterX(x);
        fan.setCenterY(y);
        fan.setRadius(RADIUS);
        fan.setStroke(Color.BLACK);
        fan.setFill(Color.WHITE);
        fan.setStrokeWidth(3.0);

        fanPane.getChildren().add(fan);

        for (int k =30; k < 360; k+= 90){
          Arc arc = new Arc(x, y, RADIUS - 15, RADIUS - 15, k, 30);//Inside the head, create an arc
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
    Circle head = new Circle(20);
    head.setCenterX(130.0f);
    head.setCenterY(70.0f);
    head.setFill(Color.TRANSPARENT);
    head.setStroke(Color.BLACK);
    head.setStrokeWidth(3.0);


    Line longVertPole = new Line();//Correct - Long V Pole
    longVertPole.setStartX(70.0f);
    longVertPole.setStartY(258.0f);
    longVertPole.setEndX(70.0f);
    longVertPole.setEndY(40.0f);
    longVertPole.setStrokeWidth(3.0);

    Line horizontalPole = new Line();//Correct - H pole
    horizontalPole.setStartX(70.0f);
    horizontalPole.setStartY(40.0f);
    horizontalPole.setEndX(130.0f);
    horizontalPole.setEndY(40.0f);
    horizontalPole.setStrokeWidth(3.0);


    Line shortVertPole = new Line();//Correct - Short V Pole
    shortVertPole.setStartX(130.0f);
    shortVertPole.setStartY(50.0f);
    shortVertPole.setEndX(130.0f);
    shortVertPole.setEndY(40.0f);
    shortVertPole.setStrokeWidth(3.0);

    Line body = new Line();//Correct - Body
    body.setStartX(130.0f);
    body.setStartY(90.0f);
    body.setEndX(130.0f);
    body.setEndY(170.0f);
    body.setStrokeWidth(3.0);


    Line rightLeg = new Line();//Correct R Leg
    rightLeg.setStartX(130.0f);
    rightLeg.setStartY(170.0f);
    rightLeg.setEndX(100.0f);
    rightLeg.setEndY(210.0f);
    rightLeg.setStrokeWidth(3.0);


    Line leftLeg = new Line();//Correct L Leg
    leftLeg.setStartX(130.0f);
    leftLeg.setStartY(170.0f);
    leftLeg.setEndX(160.0f);
    leftLeg.setEndY(210.0f);
    leftLeg.setStrokeWidth(3.0);


    Line rightArm = new Line();//Correct - R Arm
    rightArm.setStartX(112.0f);
    rightArm.setStartY(80.0f);
    rightArm.setEndX(83.0f);
    rightArm.setEndY(120.0f);
    rightArm.setStrokeWidth(3.0);



    Line leftArm = new Line();//Correct - L Arm
    leftArm.setStartX(148.0f);
    leftArm.setStartY(80.0f);
    leftArm.setEndX(177.0f);
    leftArm.setEndY(120.0f);
    leftArm.setStrokeWidth(3.0);


    Arc arcBase = new Arc();
    arcBase.setCenterX(70.0f);
    arcBase.setCenterY(285.0f);
    arcBase.setRadiusX(25.0f);
    arcBase.setRadiusY(25.0f);
    arcBase.setStartAngle(0.0f);
    arcBase.setLength(180.0f);
    arcBase.setFill(Color.TRANSPARENT);
    arcBase.setStroke(Color.BLACK);
    arcBase.setType(ArcType.OPEN);
    arcBase.setStrokeWidth(3.0);


    hangmanPane.getChildren().addAll(head, longVertPole, horizontalPole, shortVertPole, body, rightLeg, leftLeg, rightArm, leftArm, arcBase);

  }
}


class ClockPane extends Pane{
  private int hour;
  private int minute;
  private int second;

  private double w = 330, h = 330;

  public ClockPane(){
    setCurrentTime();
  }

  public ClockPane(int hour, int minute, int second){
    this.hour = hour;
    this.minute = minute;
    this.second = second;
    paintClock();
  }

  public int getHour(){
    return hour;
  }

  public void setHour(int hour){
    this.hour = hour;
    paintClock();
  }

  public int getMinute(){
    return minute;
  }

  public void setMinute(int minute){
    this.minute = minute;
    paintClock();
  }

  public int getSecond(){
    return second;
  }

  public void setSecond(int second){
    this.second = second;
    paintClock();
  }

  public double getW(){
    return w;
  }

  public void setW(double w){
    this.w = w;
    paintClock();
  }

  public double getH(){
    return h;
  }

  public void setH(double h){
    this.h = h;
    paintClock();
  }

  public void setCurrentTime (){

    Calendar calendar = new GregorianCalendar();

    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);

    paintClock();

  }

  protected void paintClock(){
    double clockRadius = Math.min(w,h) * 0.8 * 0.5;
    double centerX = w / 2;
    double centerY = h / 2;//

    //Create Circle
    Circle head = new Circle(centerX, centerY, clockRadius);
    head.setFill(Color.WHITE);
    head.setStroke(Color.BLACK);
    head.setStrokeWidth(3.0);

    Text t1 = new Text (centerX - 5, centerY - clockRadius + 12, "12");
    Text t2 = new Text (centerX - clockRadius + 3, centerY + 3, "9");
    Text t3 = new Text (centerX + clockRadius - 10, centerY + 3, "3");
    Text t4 = new Text (centerX - 3, centerY + clockRadius - 3, "6");
    Text name = new Text (centerX - 40, centerY+2, "Adrian Santos");

    //Draw second hand
    /*
    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength *
    Math.sin(second *(2 * Math.PI / 60));
    double secondY = centerY - sLength *
    Math.cos(second * (2 * Math.PI / 60));
    Line sLine =  new Line (centerX, centerY, secondX, secondY);
    sLine.setStroke(Color.RED);
    */

    //Draw minute hand
    double mLength = clockRadius * 0.65;
    double minuteX = centerX + mLength *
    Math.sin(minute *(2 * Math.PI / 60));
    double minuteY = centerY - mLength *
    Math.cos(minute * (2 * Math.PI / 60));
    Line mLine =  new Line (centerX, centerY, minuteX, minuteY);
    mLine.setStroke(Color.BLUE);
    mLine.setStrokeWidth(2.0);

    //Draw hour hand
    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength *
    Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength *
    Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine =  new Line (centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.GREEN);
    hLine.setStrokeWidth(2.0);


    getChildren().clear();
    getChildren().addAll(head, t1, t2,t3,t4, name, mLine, hLine);
  }

}
