package assignment2;
import assignment2.PBar;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		/*ToDo application = new ToDo();
		application.execute();*/	
		JFrame frame = new JFrame("ToDo");
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Task homeTask = new HomeTask();
		Task studyTask = new StudyTask();
		Task customTask = new CustomTask();
		
		List<Task> tasks = new ArrayList<>();
		panel.add(homeTask.getGuiComponent());
		panel.add(studyTask.getGuiComponent());
		panel.add(customTask.getGuiComponent());
		
        PBar progressPanel = new PBar(tasks);
        frame.add(panel, BorderLayout.CENTER);  
        frame.add(progressPanel, BorderLayout.SOUTH);
		
		frame.setBounds(100,100,400,100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
