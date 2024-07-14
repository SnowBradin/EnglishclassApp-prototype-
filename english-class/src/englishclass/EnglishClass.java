package englishclass;

import java.util.ArrayList;
import java.util.List;

public class EnglishClass {
    private List<Homework> homeworkList;
    private List<RecordedLesson> recordedLessons;
    private List<WordList> wordLists;

    public EnglishClass() {
        homeworkList = new ArrayList<>();
        recordedLessons = new ArrayList<>();
        wordLists = new ArrayList<>();
    }
    public void addHomework(Homework homework) {
        homeworkList.add(homework);
    }
    public void addRecordedLesson(RecordedLesson lesson) {
        recordedLessons.add(lesson);
    }
    public void addWordList(WordList wordList) {
        wordLists.add(wordList);
    }
    public List<Homework> getHomeworkList() {
        return homeworkList;
    }
    public List<RecordedLesson> getRecordedLessons() {
        return recordedLessons;
    }
    public List<WordList> getWordLists() {
        return wordLists;
    }
    public String exportHomeworkToCSV() {
        StringBuilder csv = new StringBuilder();
        csv.append("Subject,Description,Due Date\n");
        for (Homework hw : homeworkList) {
            csv.append(hw.toCSV()).append("\n");
        }
        return csv.toString();
    }
    public String exportLessonsToCSV() {
        StringBuilder csv = new StringBuilder();
        csv.append("Subject,Due Date\n");
        for (RecordedLesson lesson : recordedLessons) {
            csv.append(lesson.toCSV()).append("\n");
        }
        return csv.toString();
    }
    /*public void viewWordLists() {
        if (wordLists.isEmpty()) {
            System.out.println("No word lists found.");
        } else {
            for (WordList wl : wordLists) {
                System.out.println(wl);
            }
        }
    }*/
}