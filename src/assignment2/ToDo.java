package assignment2;

import javax.swing.JFrame;

import se.his.it401g.todo.HomeTask;
//import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;

public class ToDo {

	public static void main(String[] args) {
		/*ToDo application = new ToDo();
		application.execute();*/	
		JFrame frame = new JFrame();
		
		Task task = new HomeTask();
		//Task task1 = new StudyTask();
		frame.add(task.getGuiComponent());
		frame.setBounds(100,100,400,100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
