
public class Course {

    private String code;
    private String title;
    private String description;
    private String schedule;
    private int availableSlots;
    private int capacity;
    private String professor;

    public Course(String code, String title, String description, int availableSlots, String schedule, String professor) {
        this.availableSlots = availableSlots;
        this.capacity = capacity;
        this.code = code;
        this.description = description;
        this.schedule = schedule;
        this.title = title;
        this.professor = professor;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getProfessor() {
        return professor;
    }

    public boolean hasAvailableSlots() {
        return availableSlots > 0;
    }

    public boolean registerStudent() {
        if (hasAvailableSlots()) {
            availableSlots--;
            return true;
        }
        return false;
    }

    public void dropStudent() {
        availableSlots++;
    }

    @Override
    public String toString() {
        return """
               Course { 
               Code: """ + this.code
                + "\nTitle:" + this.title
                + "\nDescription: " + this.description
                + "\nSchedule: " + this.schedule
                + "\nAvailable Slots: " + this.availableSlots
                + "\nCapacity: " + this.capacity
                + "\nProfessor: " + this.professor + '}';
    }

}
