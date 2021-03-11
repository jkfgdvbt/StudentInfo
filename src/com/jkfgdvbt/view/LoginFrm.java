package com.jkfgdvbt.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import com.jkfgdvbt.dao.AdminDao;
import com.jkfgdvbt.dao.StudentDao;
import com.jkfgdvbt.dao.TeacherDao;
import com.jkfgdvbt.model.AdminModel;
import com.jkfgdvbt.model.StudentModel;
import com.jkfgdvbt.model.TeacherModel;
import com.jkfgdvbt.model.UserTypeModel;
import com.jkfgdvbt.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 登录界面
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年1月30日
 */

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField UserNameTextField;
	private JPasswordField UserPasswordTextField;
	private JComboBox UserTypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setTitle("登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("学生信息系统登录界面");
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/登录.png")));
		label.setFont(new Font("黑体", Font.BOLD, 40));
		
		JLabel label_1 = new JLabel("用户名：");
		label_1.setFont(new Font("黑体", Font.PLAIN, 30));
		
		UserNameTextField = new JTextField();
		UserNameTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		UserNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("密码：");
		label_2.setFont(new Font("黑体", Font.PLAIN, 30));
		
		UserPasswordTextField = new JPasswordField();
		UserPasswordTextField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		UserPasswordTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("登录类型：");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 30));
		
		UserTypeComboBox = new JComboBox();
		UserTypeComboBox.setModel(new DefaultComboBoxModel(new UserTypeModel[] {UserTypeModel.ADMIN, UserTypeModel.TEACHER, UserTypeModel.STUDENT}));
		UserTypeComboBox.setFont(new Font("黑体", Font.PLAIN, 30));
		
		JButton LoginButton = new JButton("登录");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		LoginButton.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		JButton ResetButton = new JButton("重置");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restValue(ae);
			}
		});
		ResetButton.setFont(new Font("微软雅黑", Font.BOLD, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(96)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(174)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1)
										.addComponent(label_2))
									.addGap(48)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(UserPasswordTextField, 456, 456, 456)
										.addComponent(UserNameTextField, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(UserTypeComboBox, 0, 472, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addContainerGap(182, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(329)
					.addComponent(LoginButton)
					.addGap(191)
					.addComponent(ResetButton)
					.addGap(230))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(label)
					.addGap(84)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(UserNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(75)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(UserPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(UserTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ResetButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(LoginButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName = UserNameTextField.getText();
		String password = UserPasswordTextField.getText();
		UserTypeModel selectedItem = (UserTypeModel)UserTypeComboBox.getSelectedItem();
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return;
		}
		AdminModel admin = null;
		if("系统管理员".equals(selectedItem.getName())) {
			//系统管理员登录
			AdminDao adminDao = new AdminDao();
			AdminModel adminTmp = new AdminModel();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			admin = adminDao.login(adminTmp);
			adminDao.closeDao();
			if(admin == null) {
				JOptionPane.showMessageDialog(this, "登录信息错误");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎" + selectedItem.getName() + admin.getName() + "登录。");
			this.dispose();
			new MainFrm(selectedItem, admin).setVisible(true);
		}else if("教师".equals(selectedItem.getName())) {
			//教师登录
			TeacherModel teacher = null;
			TeacherDao teacherDao = new TeacherDao();
			TeacherModel teacherTmp = new TeacherModel();
			teacherTmp.setName(userName);
			teacherTmp.setPassword(password);
			teacher = teacherDao.login(teacherTmp);
			teacherDao.closeDao();
			if(teacher == null) {
				JOptionPane.showMessageDialog(this, "登录信息错误");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎" + selectedItem.getName() + teacher.getName() + "登录。");
			this.dispose();
			new MainFrm(selectedItem, teacher).setVisible(true);
		}else {
			//学生登录
			StudentModel student = null;
			StudentDao studentDao = new StudentDao();
			StudentModel studentTmp = new StudentModel();
			studentTmp.setName(userName);
			studentTmp.setPassword(password);
			student = studentDao.login(studentTmp);
			studentDao.closeDao();
			if(student == null) {
				JOptionPane.showMessageDialog(this, "登录信息错误");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎" + selectedItem.getName() + student.getName() + "登录。");
			this.dispose();
			new MainFrm(selectedItem, student).setVisible(true);
		}
		
	}

	protected void restValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		UserNameTextField.setText("");
		UserPasswordTextField.setText("");
		UserTypeComboBox.setSelectedIndex(0);
	}
}
