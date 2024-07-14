package englishclass;

public class Homework {
    private String subject;
    private String description;
    private String dueDate;

    public Homework(String subject, String description, String dueDate) {
        this.subject = subject;
        this.description = description;
        this.dueDate = dueDate;
    }
    public String getSubject() {
        return subject;
    }
    public String getDescription() {
        return description;
    }
    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Subject: " + subject + ", Description: " + description + ", Due Date: " + dueDate;
    }
    public String toCSV() {
        return subject + "," + description + "," + dueDate;
    }
}

