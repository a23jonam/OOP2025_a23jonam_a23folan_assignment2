package assignment2;
import assignment2.PBar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskListener;


public class ToDo {
    private JFrame frame;
    private JPanel taskPanel;
    private List<Task> tasks;
    private PBar progressPanel;

    public ToDo() {
        tasks = new ArrayList<>();
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("To-do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setPreferredSize(new Dimension(400, 50));

        JButton homeTaskButton = new JButton("Add Home Task");
        JButton studyTaskButton = new JButton("Add Study Task");
        JButton counterTaskButton = new JButton("Add Counter Task");

        buttonPanel.add(homeTaskButton);
        buttonPanel.add(studyTaskButton);
        buttonPanel.add(counterTaskButton);

        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        progressPanel = new PBar(tasks);
        for (Task task : tasks) {
            task.setTaskListener(progressPanel);
        }

        // Sorting Dropdown
        String[] sortOptions = {"Default", "Alphabetical", "Completed", "Non-Completed", "Type"};
        JComboBox<String> sortDropdown = new JComboBox<>(sortOptions);
        buttonPanel.add(sortDropdown, BorderLayout.EAST);
        sortDropdown.addActionListener(e -> sortTasks((String) sortDropdown.getSelectedItem()));

        // Task Buttons Actions
        homeTaskButton.addActionListener(e -> addTask(new HomeTask()));
        studyTaskButton.addActionListener(e -> addTask(new StudyTask()));
        counterTaskButton.addActionListener(e -> addTask(new CustomTask()));

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskPanel), BorderLayout.CENTER);
        frame.add(progressPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addTask(Task task) {
        tasks.add(task);
        task.setTaskListener(progressPanel);
        taskPanel.add(task.getGuiComponent());
        taskPanel.revalidate();
        taskPanel.repaint();
    }

    private void sortTasks(String criteria) {
        switch (criteria) {
            case "Alphabetical" -> tasks.sort(Comparator.comparing(Task::getText));
            case "Completed" -> tasks.sort(Comparator.comparing(Task::isComplete).reversed());
            case "Non-Completed" -> tasks.sort(Comparator.comparing(Task::isComplete));
            case "Type" -> tasks.sort(Comparator.comparing(Task::getTaskType));
        }
        refreshTaskDisplay();
    }

    private void refreshTaskDisplay() {
        taskPanel.removeAll();
        for (Task task : tasks) {
            taskPanel.add(task.getGuiComponent());
        }
        taskPanel.revalidate();
        taskPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDo::new);
    }
}
