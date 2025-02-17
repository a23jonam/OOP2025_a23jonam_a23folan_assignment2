package assignment2;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;

public class ToDo {
	public static void main(String[] args) {
		/*ToDo application = new ToDo();
		application.execute();*/	
		JFrame frame = new JFrame("ToDo");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Task homeTask = new HomeTask();
		Task studyTask = new StudyTask();
		//Task task1 = new StudyTask();
		panel.add(homeTask.getGuiComponent());
		panel.add(studyTask.getGuiComponent());
		frame.add(panel);
		frame.setBounds(100,100,400,100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
