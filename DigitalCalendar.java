import java.util.*;

import java.util.*;
import java.util.InputMismatchException;

public class DigitalCalendar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, List<Event>> calendar = new TreeMap<>();

        System.out.println("\nWelcome to your digital calendar!");
        System.out.println("-------------------------------------");
        System.out.println("Instructions: ");
        System.out.println("1. Input Month\n2. Input Year\n3. Input Events (Date, Time, Description)");
        System.out.println("4. When done, confirm to generate your calendar.");
        System.out.println("-------------------------------------\n");
        System.out.print("Would you like to begin entering information? (Yes/No): ");
        String beginCalendar = sc.nextLine().toLowerCase();

        if (!beginCalendar.equals("yes")) {
            System.out.println("Okay! Have a great day!");
            sc.close();
            return;
        }
        System.out.print("\nEnter the month name (e.g., March): ");
        String month = sc.nextLine();
        int year = 0;
        boolean valid = false;
        while (!valid) {
        try {
            System.out.print("Enter the year: ");
            year = sc.nextInt();
            sc.nextLine();

            valid = true;
        }
        catch (InputMismatchException e) {
           System.out.println("That's not a valid year! please enter a valid year");
           valid = false;
           sc.nextLine();
        }
        }
        int monthDays = getDaysInMonth(month, year);
        if (monthDays == 0) {
            System.out.println("Invalid month entered. Please restart.");
            sc.close();
            return;
        }

        boolean addingEvents = true;
        int day = 0;

        while (addingEvents) {
        	System.out.print("\nEnter the day of the month (1-" + monthDays + "): ");
            boolean object = false;
            while (!object) {
            try {
                day = sc.nextInt();
                object = true;
            }
            catch (InputMismatchException e) {
               System.out.println("That's not a valid day! please enter a valid day");
               sc.nextLine();

               object = false;
            }
            }
            sc.nextLine(); // Clear buffer from previous nextInt()
            System.out.print("Enter the event time (e.g., 10:30 AM or 14:30): ");
            String time = sc.nextLine();
            System.out.print("Enter the event description: ");
            String description = sc.nextLine();

            Event event = new Event(time, description);
            calendar.computeIfAbsent(day, k -> new ArrayList<>()).add(event);

            calendar.get(day).sort(Comparator.comparing(Event::getTime));
            System.out.print("Would you like to add another event? (yes/no): ");
            String response = sc.nextLine().toLowerCase();
            addingEvents = response.equals("yes");
        }
 
        displayCalendar(month, year, calendar);
        sc.close();
    }

    private static int getDaysInMonth(String month, int year) {
        switch (month.toLowerCase()) {
            case "january": return 31;
            case "february": return (isLeapYear(year)) ? 29 : 28;
            case "march": return 31;
            case "april": return 30;
            case "may": return 31;
            case "june": return 30;
            case "july": return 31;
            case "august": return 31;
            case "september": return 30;
            case "october": return 31;
            case "november": return 30;
            case "december": return 31;
            default: return 0; 
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static void displayCalendar(String month, int year, Map<Integer, List<Event>> calendar) {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-56s ║\n", "Digital Calendar for " + month + " " + year);
        System.out.println("╠══════════════════════════════════════════════════════════╣");

        for (Map.Entry<Integer, List<Event>> entry : calendar.entrySet()) {
            int day = entry.getKey();
            List<Event> events = entry.getValue();

            System.out.printf("║ Day %2d: %-48s ║\n", day, "");
            System.out.println("╟──────────────────────────────────────────────────────────╢");

            for (Event event : events) {
                System.out.printf("║ %-8s │ %-45s ║\n", event.getTime(), event.getDescription());
            }

            System.out.println("╠══════════════════════════════════════════════════════════╣");
        }

        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }
}

class Event {
    private String time;
    private String description;

    public Event(String time, String description) {
        this.time = time;
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }
}

