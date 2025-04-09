// The event class encapsulates the information of each user input event
public class Event {
    private String time;
    private String description;

    // Initializes the time and description of an event
    public Event(String time, String description) 
    {
        this.time = time;
        this.description = description;
    }

    // Gets the time of an event
    public String getTime() 
    {
        return time;
    }

    // Gets the description of an event
    public String getDescription() 
    {
        return description;
    }
}
