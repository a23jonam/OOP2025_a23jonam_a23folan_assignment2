package assignment2;
import assignment2.PBar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskListener;

public class ToDo {
	public static void main(String[] args) {
		JFrame frame = new JFrame("To-do List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,300);
		frame.setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.setPreferredSize(new Dimension(400, 50));
		//JLabel buttonLabel = new JLabel("BUTTONS");
		//buttonPanel.add(buttonLabel);
		buttonPanel.add(new JButton("Add Home Task"));
		buttonPanel.add(new JButton("Add Study Task"));
		buttonPanel.add(new JButton("Add Counter Task"));
		
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

		List<Task> tasks = new ArrayList<>();
		
		taskPanel.add(homeTask.getGuiComponent());
		taskPanel.add(studyTask.getGuiComponent());
		taskPanel.add(customTask.getGuiComponent());
		
		
        PBar progressPanel = new PBar(tasks);
        frame.add(progressPanel, BorderLayout.SOUTH);

		
        frame.add(buttonPanel, BorderLayout.NORTH); // Buttons at top
        frame.add(new JScrollPane(taskPanel), BorderLayout.CENTER); // Scrollable task list

        frame.setVisible(true);
    }

}
