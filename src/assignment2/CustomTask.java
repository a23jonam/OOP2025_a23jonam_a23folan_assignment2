package assignment2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskInputListener;
import se.his.it401g.todo.TaskListener;

/**
 * Implements a simple study task type, following the Task.java interface class.
 * 
 * This file licensed under the
 * <a href="https://creativecommons.org/licenses/by/4.0/">Creative Commons (CC)
 * BY 4.0 license</a>.
 * 
 * @author Dr. Erik Billing, University of Skovde
 *
 */
public class CustomTask extends JPanel implements Task {

	/**
	 * The editable text field.
	 */
	private JTextField text;

	/**
	 * The non editable text label.
	 */
	private JLabel textLabel;

	/**
	 * Check box holding the completion status.
	 */
	JCheckBox completed = new JCheckBox();

	/**
	 * The task listener used for reporting changes to the main application.
	 */
	private TaskListener listener;

	/**
	 * This is the constructor for the task, initiating the GUI component for the
	 * task. Several listeners are used to react to various events in the GUI.
	 */

	private int num = 0;
	private JLabel numLabel;

	public CustomTask() {
		super(new BorderLayout());
		this.text = new JTextField("New task", 15);
		this.textLabel = new JLabel();
		this.textLabel.setVisible(false);

		JPanel center = new JPanel();

		center.add(text);
		center.add(textLabel);
		add(center, BorderLayout.CENTER);

		TaskInputListener inputListener = new TaskInputListener(this, text, textLabel);
		this.text.addKeyListener(inputListener);
		this.textLabel.addMouseListener(inputListener);

		JButton remove = new JButton("Remove");

		JButton increment = new JButton("+");
		JButton decrement = new JButton("-");

		numLabel = new JLabel(String.valueOf(num));

		remove.addActionListener(inputListener);

		increment.addActionListener(e -> {
			if (num < 1000) {
				num++;
				numLabel.setText(String.valueOf(num));
			}
		});

		decrement.addActionListener(e -> {
			if (num != 0) {
				num--;
				numLabel.setText(String.valueOf(num));
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(numLabel);
		buttonPanel.add(increment);
		buttonPanel.add(decrement);
		buttonPanel.add(remove);

		add(completed, BorderLayout.WEST);
		add(buttonPanel, BorderLayout.EAST);

		completed.addItemListener(inputListener);

		setMaximumSize(new Dimension(1000, 50));
		setBorder(new TitledBorder(getTaskType()));
	}

	@Override
	public String getText() {
		return text.getText();
	}

	@Override
	public String getTaskType() {
		return "Counter";
	}

	@Override
	public void setTaskListener(TaskListener t) {
		listener = t;
	}

	@Override
	public TaskListener getTaskListener() {
		return listener;
	}

	@Override
	public boolean isComplete() {
		return completed.isSelected();
	}

	@Override
	public Component getGuiComponent() {
		// Since this class extends JPanel, it is itself a GUI component, and thus we
		// can return "this".
		return this;
	}

}
