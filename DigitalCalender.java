import java.util.Scanner;

public class DigitalCalender
{
    public static int chooseMonth (String month)
    {
        int numericMonth = 0;

        switch (month.toLowerCase())
        {
            case "january":
                numericMonth = 31;
                break;
            case "february":
                numericMonth = 28;
                break;
            case "march":
                numericMonth = 31;
                break;
            case "april":
                numericMonth = 30;
                break;
            case "may":
                numericMonth = 31;
                break;
            case "june":
                numericMonth = 30;
                break;
            case "july":
                numericMonth = 31;
                break;
            case "august":
                numericMonth = 31;
                break;
            case "september":
                numericMonth = 30;
                break;
            case "october":
                numericMonth = 31;
                break;
            case "november":
                numericMonth = 30;
                break;
            case "december":
                numericMonth = 31;
                break;
            default:
                System.out.print("This is not a valid month, please restart");
        }
        return numericMonth;
    }


    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to your new digital calender!\n-------------------------------------");
        System.out.println("Instructions: \n-------------------------------------");
        System.out.println("1. Input Month\n2. Input Event\n3. Input Date\n4. Repeat for all needed dates\n-------------------------------------");
        System.out.println("Once all information has been entered,\nhit confirm and a digital calender\nwill be created suited to your month's\nschedule\n");
        
        System.out.print("Would you like to begin entering information for the calender? (Enter Yes or No): ");
        String beginCalender = sc.next();
        sc.nextLine();
        if (beginCalender.toLowerCase().equals("yes"))
        {
            System.out.println("Excellent! Let's begin!\n");
        }
        else if (beginCalender.toLowerCase().equals("no"))
        {
            System.out.print("Okay! Have a good day!\n");
            System.exit(0);
        }
        
        System.out.println("Which month will you be planning for? ");
        String letterMonth = sc.nextLine();
        int monthDays = chooseMonth(letterMonth);

        sc.close();
    }
}

import java.util.*;

public class DigitalCalendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, List<Event>> calendar = new TreeMap<>();

        System.out.print("Enter the month name (e.g., March): ");
        String month = sc.nextLine();

        boolean addingEvents = true;
        while (addingEvents) {
            System.out.print("Enter the day of the month (1-31): ");
            int day = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter the event time (e.g., 10:30 AM or 14:30): ");
            String time = sc.nextLine();

            System.out.print("Enter the event description: ");
            String description = sc.nextLine();

            // Add the event to the calendar
            Event event = new Event(time, description);
            calendar.computeIfAbsent(day, k -> new ArrayList<>()).add(event);

            // Sort events for the day
            calendar.get(day).sort(Comparator.comparing(Event::getTime));

            System.out.print("Would you like to add another event? (yes/no): ");
            String response = sc.nextLine().toLowerCase();
            addingEvents = response.equals("yes");
        }

        // Display the calendar
        displayCalendar(month, calendar);

        sc.close();
    }

    private static void displayCalendar(String month, Map<Integer, List<Event>> calendar) {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-56s ║\n", "Digital Calendar for " + month);
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