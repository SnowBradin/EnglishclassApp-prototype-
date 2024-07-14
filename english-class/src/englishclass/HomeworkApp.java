package englishclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HomeworkApp {
    private JFrame frame;
    private EnglishClass englishClass;

    public HomeworkApp() {
        englishClass = new EnglishClass();
        frame = new JFrame("English Class Management");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(10, 20, 80, 25);
        panel.add(subjectLabel);

        JTextField subjectText = new JTextField(20);
        subjectText.setBounds(100, 20, 165, 25);
        panel.add(subjectText);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(10, 50, 80, 25);
        panel.add(descriptionLabel);

        JTextField descriptionText = new JTextField(20);
        descriptionText.setBounds(100, 50, 165, 25);
        panel.add(descriptionText);

        JLabel dueDateLabel = new JLabel("Due Date:");
        dueDateLabel.setBounds(10, 80, 80, 25);
        panel.add(dueDateLabel);

        JTextField dueDateText = new JTextField(20);
        dueDateText.setBounds(100, 80, 165, 25);
        panel.add(dueDateText);

        JButton addHomeworkButton = new JButton("Add Homework");
        addHomeworkButton.setBounds(10, 110, 150, 25);
        panel.add(addHomeworkButton);

        JButton viewHomeworkButton = new JButton("View Homework");
        viewHomeworkButton.setBounds(170, 110, 150, 25);
        panel.add(viewHomeworkButton);

        JButton exportHomeworkButton = new JButton("Export Homework to CSV");
        exportHomeworkButton.setBounds(10, 140, 300, 25);
        panel.add(exportHomeworkButton);

        addHomeworkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String subject = subjectText.getText();
                String description = descriptionText.getText();
                String dueDate = dueDateText.getText();
                Homework homework = new Homework(subject, description, dueDate);
                englishClass.addHomework(homework);
                JOptionPane.showMessageDialog(frame, "Homework added successfully!");
            }
        });

        viewHomeworkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder homeworkDetails = new StringBuilder();
                for (Homework hw : englishClass.getHomeworkList()) {
                    homeworkDetails.append(hw.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, homeworkDetails.toString(), "Homework List", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exportHomeworkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String csvContent = englishClass.exportHomeworkToCSV();
                try {
                    File file = new File("homework.csv");
                    FileWriter writer = new FileWriter(file);
                    writer.write(csvContent);
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Homework exported to " + file.getAbsolutePath());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error exporting homework to CSV.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new HomeworkApp();
    }
}
