import java.awt.*;
import javax.swing.ImageIcon;

// Class representing a favorite animal item in the album
public class FavouriteAnimal extends AlbumItem {
    private String Animal;
    private String continent;
    private String imagePath;

    // Constructor to initialize the attributes of the favorite animal
    public FavouriteAnimal(String Animal, String continent, String imagePath ) {
        this.Animal = Animal;
        this.continent = continent;
        this.imagePath = imagePath;
    }

    // Method to get the image of the favorite animal
    @Override
    ImageIcon getImage() {
        try {
            // Load the image using ImageIcon
            ImageIcon imageIcon = new ImageIcon(imagePath);

            // Resize the image to a specific size
            Image image = imageIcon.getImage();
            Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            // Create a new ImageIcon with the resized image
            return new ImageIcon(resizedImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle the exception gracefully, return null or a default image
        }
    }

    // Method to get the facts about the favorite animal
    @Override
    String getFacts() {
        return "Animal Facts:" + Animal + "\nContinent: " + continent;
    }
}


