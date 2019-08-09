package com.library.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.library.dao.LibrarianDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteLibrarian extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static DeleteLibrarian frame;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteLibrarian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeleteLibrarian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblEnterId = new JLabel("Enter Id:");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				if (user == null || user.trim().equals("")) {
					JOptionPane.showMessageDialog(DeleteLibrarian.this, "User can't be blank");
				} else {

					try {
						LibrarianDao.delete(user);
						JOptionPane.showMessageDialog(DeleteLibrarian.this, "Record deleted successfully!");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(DeleteLibrarian.this, "Unable to delete given id!");
					}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[] {});
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(39).addComponent(lblEnterId).addGap(57)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(107, Short.MAX_VALUE))
						.addGroup(
								Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addContainerGap(175, Short.MAX_VALUE)
										.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 109,
												GroupLayout.PREFERRED_SIZE)
										.addGap(140))
						.addGroup(
								Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addContainerGap(322, Short.MAX_VALUE).addComponent(btnNewButton,
												GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(19)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnterId))
						.addGap(33).addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(43).addComponent(btnNewButton).addContainerGap(78, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}