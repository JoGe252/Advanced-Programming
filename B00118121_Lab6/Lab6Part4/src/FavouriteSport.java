import javax.swing.ImageIcon;
import java.awt.*;


public class FavouriteSport extends AlbumItem {
    private String Sport;
    private String mainScoreType;
    private String pathToImage;

    public FavouriteSport(String Sport, String mainScoreType,String pathToImage) {
        this.Sport = Sport;
        this.mainScoreType = mainScoreType;
        this.pathToImage = pathToImage;
    }

    @Override
    ImageIcon getImage() {
        try {
            String imagePath = this.pathToImage;

            // Load the image using ImageIcon
            ImageIcon imageIcon = new ImageIcon(imagePath);

            // Resize the image to a minimum size (e.g., 50x50 pixels)
            Image image = imageIcon.getImage();
            Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            // Create a new ImageIcon with the resized image
            return new ImageIcon(resizedImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle the exception gracefully, return null or a default image
        }
    }

    @Override
    String getFacts() {
        return "Sport Facts: " + Sport + "\nMain Score Type: " + mainScoreType;
    }
}

