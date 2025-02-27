import javax.swing.ImageIcon;

// Abstract class representing an item on the album
public abstract class AlbumItem {

    // Abstract method to get the image icon of the item
    abstract ImageIcon getImage();

    // Abstract method to get the facts related to the item
    abstract String getFacts();
}


