package englishclass;

public class RecordedLesson {
    private String subject;
    private String link;

    public RecordedLesson(String subject, String link) {
        this.subject = subject;
        this.link = link;
    }
    public String getSubject() {
        return subject;
    }
    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "Subject: " + subject + ", Link: " + link;
    }
    public String toCSV() {
        return subject + "," + link;
    }
}
