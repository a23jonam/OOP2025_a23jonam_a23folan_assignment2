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
	public static void main(String[] args) {
		JFrame frame = new JFrame("To-do List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,300);
		frame.setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.setPreferredSize(new Dimension(400, 50));

		JButton homeTaskButton = new JButton("Add Home Task");
		JButton studyTaskButton = new JButton("Add Study Task");
		JButton counterTaskButton = new JButton("Add Counter Task");
		buttonPanel.add(homeTaskButton);
		buttonPanel.add(studyTaskButton);
		buttonPanel.add(counterTaskButton);
		
		//JLabel buttonLabel = new JLabel("BUTTONS");
		//buttonPanel.add(buttonLabel);
		/*buttonPanel.add(new JButton ("Add Home Task"));
		buttonPanel.add(new JButton("Add Study Task"));
		buttonPanel.add(new JButton("Add Counter Task"));*/
		
		List<Task> tasks = new ArrayList<>();
		
		JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
		//JLabel taskLabel = new JLabel("TASKS");
		//taskPanel.add(taskLabel);
		taskPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		Task homeTask = new HomeTask();
		Task studyTask = new StudyTask();
		Task customTask = new CustomTask();
		
		/*tasks.add(homeTask);
		tasks.add(studyTask);
		tasks.add(customTask);*/
		
		taskPanel.add(homeTask.getGuiComponent());
		taskPanel.add(studyTask.getGuiComponent());
		taskPanel.add(customTask.getGuiComponent());
		
		String[] items = {"SORT", "Alphabetical", "Completed", "Non-Completed", "Type"};
		JComboBox<String> comboBox = new JComboBox<>(items);
		buttonPanel.add(comboBox, BorderLayout.EAST);
		
		
        PBar progressPanel = new PBar(tasks);
        frame.add(progressPanel, BorderLayout.SOUTH);

		
        frame.add(buttonPanel, BorderLayout.NORTH); // Buttons at top
        frame.add(new JScrollPane(taskPanel), BorderLayout.CENTER); // Scrollable task list
        
		homeTaskButton.addActionListener(e -> {
		    Task newTask = new HomeTask();  // Create new home task
		    tasks.add(newTask);  // Add it to the task list
		    taskPanel.add(newTask.getGuiComponent());  // Add it to the UI
		    taskPanel.revalidate();  // Recalculate layout
		    taskPanel.repaint();
		});

		studyTaskButton.addActionListener(e -> {
		    Task newTask = new StudyTask();  // Create new home task
		    tasks.add(newTask);  // Add it to the task list
		    taskPanel.add(newTask.getGuiComponent());  // Add it to the UI
		    taskPanel.revalidate();  // Recalculate layout
		    taskPanel.repaint();
		});
		
		counterTaskButton.addActionListener(e -> {
		    Task newTask = new CustomTask();  // Create new home task
		    tasks.add(newTask);  // Add it to the task list
		    taskPanel.add(newTask.getGuiComponent());  // Add it to the UI
		    taskPanel.revalidate();  // Recalculate layout
		    taskPanel.repaint();
		});
		
        frame.setVisible(true);
    }

}
