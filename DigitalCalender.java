import java.util.Scanner;

public class DigitalCalender
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to your new digital calender!\n-------------------------------------");
        System.out.println("Instructions: \n-------------------------------------");
        System.out.println("1. Input Month\n2. Input Event\n3. Input Date\n4. Repeat for all needed dates\n-------------------------------------");
        System.out.println("Once all information has been entered,\nhit confirm and a digital calender\nwill be created suited to your month's\nschedule\n");

        System.out.print("Would you like to begin entering information for the calender? (Enter Yes or No): ");
        String beginCalender = sc.next();
        if (beginCalender.toLowerCase().equals("no"))
        {
            System.out.print("Okay! Have a good day!");
            System.exit(0);
        }
        else if (beginCalender.toLowerCase().equals("yes"))
        {
            System.out.print("Excellent! Let's begin!");
        }

        sc.close();
    }
}

