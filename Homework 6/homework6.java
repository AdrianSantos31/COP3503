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

//Box Imports
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

//Clock Library Imports
//Fan Library Imports
//Hangman Library Imports

//Displays Three Figures
public class homework6 extends Application{
  public void start(Stage primaryStage){

    //Create a Pane
    Pane pane = new Pane();

    //Fan - Static; Set Central Coordinate then subdivide into 4 quadrants
    Rectangle rFan = new Rectangle (0,0,200,200);
    rFan.setStroke(Color.BLACK);
    rFan.setFill(Color.GREEN);
    pane.getChildren().add(new Text(50,50,"Fan Location"));
    pane.getChildren().add(rFan);

    //Hangman - Static
    Rectangle rHangman = new Rectangle (800,0,200,200);
    rHangman.setStroke(Color.BLACK);
    rHangman.setFill(Color.GREEN);
    pane.getChildren().add(new Text(650,50,"Hangman Location"));
    pane.getChildren().add(rHangman);


    //Clock - Dynamic; Set a name horizontally; randomly generated time at each run
    Rectangle rClock = new Rectangle (400,300,200,200);
    rClock.setStroke(Color.BLACK);
    rClock.setFill(Color.GREEN);
    pane.getChildren().add(new Text(500,150,"Fan Location"));
    pane.getChildren().add(rClock);





    //Create a scene and place it in the Stage
    Scene scene = new Scene(pane, 1000,500);
    primaryStage.setTitle("First JavaFX"); //Title of the document
    primaryStage.setScene(scene); // Put scene on the stage
    primaryStage.show(); // Display the stage
  }






//Main method, since jGrasp will be used to check the program
public static void main(String[] args){
   Application.launch(args);
  }
}
