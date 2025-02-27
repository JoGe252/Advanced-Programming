import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MyAlbum extends JFrame {
    private Vector<AlbumItem> album;
    private JLabel imageLabel;
    private JTextArea factsTextArea;
    private JButton nextButton;
    private int currentIndex;

    // Constructor to initialize the MyAlbum JFrame
    public MyAlbum() {
        album = new Vector<>();
        initializeAlbum(); // Initialize the album with items

        setTitle("My Album"); // Set the title of the frame
        setSize(400, 300); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation

        // Initialize components
        imageLabel = new JLabel();
        factsTextArea = new JTextArea();
        nextButton = new JButton("Next");

        // Add action listener to the forward button
        nextButton.addActionListener(e -> {
            showNextItem(); // Call method to display the next item on the album
        });

        // Add components to the panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(factsTextArea, BorderLayout.SOUTH);
        panel.add(nextButton, BorderLayout.EAST);

        // Add panel to the frame
        add(panel);

        showNextItem(); // Display the first item initially
    }

    // Method to initialize the album with items
    private void initializeAlbum() {
        // Add at least 5 objects of each subclass to the album
        album.add(new FavouriteSport("Modern football started in the 19th Century.", "Goals","images/football.jpg"));
        album.add(new FavouriteAnimal("The average lifespan of a wolf is 5-7 years in the wild and 12-15 years in captivity.", "North America/ Eurasia","images/wolf.jpg"));
        album.add(new FavouriteSport("The modern era of Formula One began in 1950.", "Points","images/f1.jpg"));
        album.add(new FavouriteAnimal("Humans have used falcons for hunting for thousands of years.", "~","images/falcon.jpg"));
        album.add(new FavouriteSport("Basketball was invented by James Naismith in Springfield, Massachusetts, in 1891.", "Points","images/basketball.jpg"));
        album.add(new FavouriteAnimal("Lions run at a speed of up to 81km/ph.", "Africa","images/lion.jpg"));
        album.add(new FavouriteSport("The modern era of MMA began with the creation of the Ultimate Fighting Championship (UFC) in 1993.", "Score","images/mma.jpg"));
        album.add(new FavouriteAnimal("There are currently 42 species of dolphins.", "~","images/dolphin.jpg"));
        album.add(new FavouriteSport("Modern boxing history really began to develop into the sport known and loved today in the 18th century.", "Score","images/boxing.jpg"));
        album.add(new FavouriteAnimal("Chameleons have Panoramic Vision\n", "Africa","images/chameleon.jpg"));
    }

    // Method to show the next item on the album
    private void showNextItem() {
        if (currentIndex < album.size()) {
            AlbumItem currentItem = album.get(currentIndex);
            imageLabel.setIcon(currentItem.getImage()); // Set the image icon
            factsTextArea.setText(currentItem.getFacts()); // Set the facts
            currentIndex++;
        } else {
            JOptionPane.showMessageDialog(this, "Album empty"); // Show message if no more items
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        MyAlbum frame = new MyAlbum();
        frame.setVisible(true);
    }
}


