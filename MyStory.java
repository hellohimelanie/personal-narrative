import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  private String[][] settingImages = {
    {"beach.jpg", "forest.jpg"}  // 0: Beach, 1: Forest
  };

  private String[][] characterImages = {
    {"chris.jpg", "heather.jpg", "owen.jpg", "gwen.jpg"}  // Characters
  };

  public MyStory() {
    drawScene();
  }

  public void drawScene() {
    drawIntroScene();      // Intro with setting images
    drawCharacterScene();  // Character elimination
  }

  // Intro scene with images of the setting
  public void drawIntroScene() {
    clear("white");  // Light background

    setTextHeight(20);
    setTextColor("black");
    setTextStyle(Font.MONO, FontStyle.BOLD);


    drawText("Welcome to Total Drama Island", 50, 20);  // Text at position x = 50 with font size 20

    // Show images of settings using the 2D array
    ImageFilter beach = new ImageFilter(settingImages[0][0]);  // 0: Beach image
    // Full brightness (morning effect)
    drawImage(beach, 0, 100, 200);
    pause(1.0);

    ImageFilter forest = new ImageFilter(settingImages[0][1]);  // 1: Forest image
    drawImage(forest, 200, 100 , 200);

    pause(1.0); 
    
    forest.motionBlur(100, "horizontal");
    beach.motionBlur(100,"horizontal");
    drawImage(forest, 200, 100, 200);
    drawImage(beach, 0, 100, 200);
    
    pause(1.0);
  }

  // Character elimination scene
  public void drawCharacterScene() {
    clear("black");  // Clear screen for character reveal

    setTextHeight(20);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    drawText("The Contestants", 50, 20);  // Text at position x=50 with font size 20

    // Display characters from the 2D array
    ImageFilter character1 = new ImageFilter(characterImages[0][0]); // Chris
    drawImage(character1, 0, 50, 150);

    ImageFilter character2 = new ImageFilter(characterImages[0][1]); // Heather
    drawImage(character2, 200, 50, 150);

    ImageFilter character3 = new ImageFilter(characterImages[0][2]); // Owen
    drawImage(character3, 0, 200, 150);

    ImageFilter character4 = new ImageFilter(characterImages[0][3]); // Gwen
    drawImage(character4, 200, 200, 150);

    pause(2.0);
    
    character1.motionBlur(200,"vertical");
    drawImage(character1, 0,50,150);

    // Pause for 1.5 seconds to show all characters
    pause(1.5);

    // Eliminate a character (example: Owen)
    clear("black");
    drawText("Eliminated: Chris", 50, 20);  // Text at position x=50 with font size 20

    // Show remaining characters after elimination
    drawImage(character2, 200, 50, 150);
    drawImage(character3, 0, 200,150);
    drawImage(character4, 200, 200, 150);  // Removed Chris
  }
}