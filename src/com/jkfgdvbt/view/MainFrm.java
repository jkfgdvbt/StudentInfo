package com.jkfgdvbt.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.jkfgdvbt.model.UserTypeModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;

/**
 * 主界面设计
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月3日
 */

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenuItem addTeacherMenuItem;
	private JMenuItem addClassMenuItem;
	private JMenuItem addStudentMenuItem;
	private JMenu manageTeacherMenu;
	private JMenu manageClassMenu;
	public static UserTypeModel userType;
	public static Object userObject;

	/**
	 * Create the frame.
	 */
	public MainFrm(UserTypeModel userType, Object userObject) {
		this.userType = userType;
		this.userObject = userObject;
		setTitle("学生信息管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("系统设置");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("修改密码");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("退出系统");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "是否确认退出系统？") == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("学生管理");
		menuBar.add(menu_1);
		
		addStudentMenuItem = new JMenuItem("学生添加");
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addStudent(ae);
			}
		});
		menu_1.add(addStudentMenuItem);
		
		JMenuItem menuItem_3 = new JMenuItem("学生列表");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				manageStudent(ae);
			}
		});
		menu_1.add(menuItem_3);
		
		manageClassMenu = new JMenu("班级管理");
		menuBar.add(manageClassMenu);
		
		addClassMenuItem = new JMenuItem("班级添加");
		addClassMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addClass(ae);
			}
		});
		manageClassMenu.add(addClassMenuItem);
		
		JMenuItem menuItem_5 = new JMenuItem("班级列表");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				manageClass(ae);
			}
		});
		manageClassMenu.add(menuItem_5);
		
		manageTeacherMenu = new JMenu("教师管理");
		menuBar.add(manageTeacherMenu);
		
		addTeacherMenuItem = new JMenuItem("教师添加");
		addTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addTeacher(ae);
			}
		});
		manageTeacherMenu.add(addTeacherMenuItem);
		
		JMenuItem menuItem_8 = new JMenuItem("教师列表");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				manageTeacher(ae);
			}
		});
		manageTeacherMenu.add(menuItem_8);
		
		JMenu menu_3 = new JMenu("帮助");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_6 = new JMenuItem("关于");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		menu_3.add(menuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(222, 184, 135));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setAuthority();
	}

	protected void manageTeacher(ActionEvent ae) {
		// TODO Auto-generated method stub
		ManageTeacherFrm manageTeacherManageFrm = new ManageTeacherFrm();
		manageTeacherManageFrm.setVisible(true);
		desktopPane.add(manageTeacherManageFrm);
	}

	protected void addTeacher(ActionEvent ae) {
		// TODO Auto-generated method stub
		AddTeacherFrm addTeacherFrm = new AddTeacherFrm();
		addTeacherFrm.setVisible(true);
		desktopPane.add(addTeacherFrm);
	}

	protected void manageClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		ManageClassFrm manageClassManageFrm = new ManageClassFrm();
		manageClassManageFrm.setVisible(true);
		desktopPane.add(manageClassManageFrm);
	}

	protected void manageStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		ManageStudentFrm manageStudentFrm = new ManageStudentFrm();
		manageStudentFrm.setVisible(true);
		desktopPane.add(manageStudentFrm);
	}

	protected void addStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		AddStudentFrm addStudentFrm = new AddStudentFrm();
		addStudentFrm.setVisible(true);
		desktopPane.add(addStudentFrm);
	}

	protected void addClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		AddClassFrm addClassFrm = new AddClassFrm();
		addClassFrm.setVisible(true);
		desktopPane.add(addClassFrm);
	}

	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}

	protected void aboutUs(ActionEvent ae) {
		// TODO Auto-generated method stub
		final String developerInfo = "Developer: Zhu Hongyu";
		JOptionPane.showMessageDialog(this, developerInfo);
	}
	
	private void setAuthority() {
		if("学生".equals(userType.getName())) {
			addStudentMenuItem.setEnabled(false);
			manageClassMenu.setEnabled(false);
			manageTeacherMenu.setEnabled(false);
		}
		if("教师".equals(userType.getName())) {
			addTeacherMenuItem.setEnabled(false);
		}
	}
	
}
