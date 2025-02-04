import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  public ImageFilter(String filename) {
    super(filename);
  }

  // Adjusts the blurrines of the image by using length and direction to blur the pixel colors
public void motionBlur(int length, String direction) {
    Pixel[][] pixels = getImagePixels();
    int imageHeight = getHeight();
    int imageWidth = getWidth();

    for (int y = 0; y < imageHeight; y++) {
        for (int x = 0; x < imageWidth; x++) {
            Pixel currentPixel = pixels[y][x];
            int red = 0;
            int green = 0;
            int blue = 0;
            int count = 0;


            for (int i = 0; i < length; i++) {
                int newX = x;  
                int newY = y;  

    
                if (direction.equals("horizontal")) {
                    newX = x + i;
                } else if (direction.equals("vertical")) {
                    newY = y + i;
                } else if (direction.equals("diagonal")) {
                    newX = x + i;
                    newY = y + i;
                }


                if (newX >= 0 && newX < imageWidth && newY >= 0 && newY < imageHeight) {
                    Pixel p = pixels[newY][newX];
                    red += p.getRed();
                    green += p.getGreen();
                    blue += p.getBlue();
                    count++;
                }
            }
          
            if (count > 0) {
                int avgRed = red / count;
                int avgGreen = green / count;
                int avgBlue = blue / count;

                currentPixel.setRed(avgRed);
                currentPixel.setGreen(avgGreen);
                currentPixel.setBlue(avgBlue);
            }
        }
    }
  }
}