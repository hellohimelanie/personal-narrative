import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Creates a Scene object
    MyStory ms = new MyStory();
    

    // Plays the scene
    Theater.playScenes(ms);
    
  }
}