import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
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

public class BounceBallSlider extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    BallPane ballPane = new BallPane();
    Slider slSpeed = new Slider();
    slSpeed.setMax(20);
    ballPane.rateProperty().bind(slSpeed.valueProperty());

    BorderPane pane = new BorderPane();
    pane.setCenter(ballPane);
    pane.setBottom(slSpeed);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("BounceBallSlider"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}

class BallPane extends Pane {
  public final double radius = 20;
  private double x = radius, y = radius;
  private double dx = 1, dy = 1;
  private Circle circle = new Circle(x, y, radius);
  private Timeline animation;

  public BallPane() {
    circle.setFill(Color.GREEN); // Set ball color
    getChildren().add(circle); // Place a ball into this pane

     // Create an animation for moving the ball
    animation = new Timeline(
    new KeyFrame(Duration.millis(50), e -> moveBall()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
    }

    public void play() {
      animation.play();
    }

    public void pause(){
      animation.pause();
    }

    public void increaseSpeed(){
      animation.setRate(animation.getRate()+ 0.1);
    }

    public void decreaseSpeed(){
      animation.setRate(
        animation.getRate() > 0? animation.getRate()-0.1: 0);
    }

    public DoubleProperty rateProperty(){
      return animation.rateProperty();

    }

    protected void moveBall(){
      if (x < radius || x > getWidth()-radius){
        dx *= -1;
      }

      if (y < radius || y > getHeight()-radius){
        dy *= -1;
      }

      x += dx;
      y += dy;

      circle.setCenterX(x);
      circle.setCenterY(y);

    }
}
