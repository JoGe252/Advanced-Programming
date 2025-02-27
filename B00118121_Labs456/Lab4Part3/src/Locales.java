import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class Locales extends JFrame {
    private JComboBox<Locale> localeComboBox;
    private JTextArea textArea;
    private static final long serialVersionUID = 1L; //Serial version UID for serialization

    public Locales() {
        setTitle(getLocalizedString("Locales"));
        setSize(400, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();
        addComponentsToFrame();

        // Adjust frame size based on components
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to initialize GUI components
    private void initializeComponents() {
        // Create and configure locale combo box
        localeComboBox = new JComboBox<>(Locale.getAvailableLocales());
        localeComboBox.setRenderer(new LocaleListCellRenderer());

        // Create and configure text area
        textArea = new JTextArea();
        textArea.setEditable(false);

        // Add action listener to combo box
        localeComboBox.addActionListener(e -> displayLocalizedInformation((Locale) localeComboBox.getSelectedItem()));
    }

    // Method to add components to the frame
    private void addComponentsToFrame() {
        // Create panel for combo box
        JPanel panel = new JPanel();
        panel.add(new JLabel(getLocalizedString("combo.label")));
        panel.add(localeComboBox);

        // Add panel and text area to frame
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    // Method to display localized information based on selected locale
    private void displayLocalizedInformation(Locale selectedLocale) {
        if (selectedLocale != null) {
            DateFormatSymbols symbols = new DateFormatSymbols(selectedLocale);

            String daysOfWeek = String.join(", ", symbols.getWeekdays());
            String monthsOfYear = String.join(", ", symbols.getMonths());

            // Set text area content
            textArea.setText("Days of the Week: " + daysOfWeek + "\n\n" + "Months of the Year: " + monthsOfYear);
        }
    }

    // Method to get localized string
    private String getLocalizedString(String key) {
        // Replace this method with an actual internationalization code based on your requirements
        // Here, we are returning a simple string as a placeholder
        return key;
    }

    // Main method to start the application
    public static void main(String[] args) {
        Locales frame = new Locales();
        frame.setVisible(true);
    }
}

//A custom cell renderer for locale combo box
class LocaleListCellRenderer extends DefaultListCellRenderer {
    private static final long serialVersionUID = 1L; //Serial version UID for serialization

    @Override //Override method to customize rendering of list cell
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Locale) { //Checks if the value is a Locale object
            value = ((Locale) value).getDisplayName(); //Converts Locale object to its display name
        }
        //Calls the superclass method to perform the default rendering
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }
}







