package assignment2;


import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskListener;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PBar extends JPanel implements TaskListener {
    private JProgressBar progressBar;
    private JLabel completedLabel;
    private List<Task> taskList;
    private int completedTasks = 0;


    public PBar(List<Task> tasks) {
    	this.taskList = tasks;
        setLayout(new BorderLayout());        

        completedLabel = new JLabel("0 / " + taskList.size() + " tasks completed", SwingConstants.CENTER);
        add(completedLabel, BorderLayout.CENTER);
        updateProgress();
    }

    private void updateProgress() {
        if (taskList.isEmpty()) {
            completedLabel.setText("0 / 0 tasks completed");
            return;
        }

        completedLabel.setText(completedTasks + " / " + taskList.size() + " tasks completed");
    }
    
    @Override
    public void taskCompleted(Task t) {

        if (t.isComplete() && taskList.contains(t)) {
            completedTasks++;
            updateProgress();
        }
    }

    @Override
    public void taskUncompleted(Task t) {
        if (!t.isComplete() && completedTasks > 0 && taskList.contains(t)) {
            completedTasks--;
            updateProgress();
        }
    }

    @Override
    public void taskChanged(Task t) {
        //updateProgress();
    }

    @Override
    public void taskRemoved(Task t) {
        if (taskList.remove(t) && t.isComplete()) {
            completedTasks--;
        }
        updateProgress();
    }

	@Override
	public void taskCreated(Task t) {
        taskList.add(t);
        updateProgress();

	}
	

}