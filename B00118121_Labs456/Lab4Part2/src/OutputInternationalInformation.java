import java.text.*;
import java.util.*;

public class OutputInternationalInformation {
    public static void main(String[] args) {
        // Creates three Locale objects
        Locale irishLocale = new Locale("ga", "IE");
        Locale portugeseLocale = new Locale("pt", "PT");
        Locale malluLocale = new Locale("ml", "IN");

        // Displays localized information for each Locale
        displayLocalizedInformation(irishLocale);
        displayLocalizedInformation(portugeseLocale);
        displayLocalizedInformation(malluLocale);
    }

    public static void displayLocalizedInformation(Locale locale) {
        System.out.println("Locale: " + locale.getDisplayName());

        // Displays days of the week
        String[] daysOfWeek = DateFormatSymbols.getInstance(locale).getWeekdays();
        System.out.println("Days of the Week:");
        for (int i = 2; i < daysOfWeek.length; i++) {
            System.out.println(daysOfWeek[i]);
        }

        // Displays months of the year
        String[] monthsOfYear = DateFormatSymbols.getInstance(locale).getMonths();
        System.out.println("Months of the Year:");
        for (String month : monthsOfYear) {
            System.out.println(month);
        }

        // Displays currency format for a big number
        double bigNumber = 12000.50;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        System.out.println("Currency: " + currencyFormatter.format(bigNumber));

        // Displays today's date in SHORT date format
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        System.out.println("Today's Date: " + dateFormat.format(new Date()));

        // Displays one more locale-sensitive piece of information
        Currency currency = Currency.getInstance(locale);
        System.out.println("Currency code: " + currency.getCurrencyCode());

        // Displays the country name in the local language
        String countryName = locale.getDisplayCountry(locale);
        System.out.println("Country Name: " + countryName);
        System.out.printf("\n \n ");

    }
}

