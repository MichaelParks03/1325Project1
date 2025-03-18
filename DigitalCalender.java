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

