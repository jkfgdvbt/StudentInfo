package com.jkfgdvbt.view;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.jkfgdvbt.dao.AdminDao;
import com.jkfgdvbt.dao.StudentDao;
import com.jkfgdvbt.dao.TeacherDao;
import com.jkfgdvbt.model.AdminModel;
import com.jkfgdvbt.model.StudentModel;
import com.jkfgdvbt.model.TeacherModel;
import com.jkfgdvbt.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 修改密码界面
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月5日
 */

public class EditPasswordFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmPasswordTextField;
	private JButton submitButton;
	private JButton resetButton;
	private JLabel label_3;
	private JLabel currentUserLabel;
	
	/**
	 * Create the frame.
	 */
	public EditPasswordFrm() {
		setTitle("修改密码");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		
		
		JLabel label = new JLabel("原密码：");
		label.setFont(new Font("黑体", Font.PLAIN, 30));
		
		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		oldPasswordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("新密码：");
		label_1.setFont(new Font("黑体", Font.PLAIN, 30));
		
		newPasswordTextField = new JTextField();
		newPasswordTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		newPasswordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("确认密码：");
		label_2.setFont(new Font("黑体", Font.PLAIN, 30));
		
		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		confirmPasswordTextField.setColumns(10);
		
		submitButton = new JButton("确认修改");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEdit(ae);
			}
		});
		submitButton.setFont(new Font("黑体", Font.BOLD, 30));
		
		resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setFont(new Font("黑体", Font.BOLD, 30));
		
		label_3 = new JLabel("当前用户：");
		label_3.setFont(new Font("黑体", Font.PLAIN, 30));
		
		currentUserLabel = new JLabel("");
		currentUserLabel.setFont(new Font("黑体", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(141)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(submitButton)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(currentUserLabel, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
								.addComponent(newPasswordTextField, 292, 292, 292)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(resetButton)
									.addComponent(confirmPasswordTextField, 292, 292, 292)))))
					.addContainerGap(186, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(121)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(currentUserLabel)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(94))
		);
		contentPane.setLayout(gl_contentPane);
		if("系统管理员".equals(MainFrm.userType.getName())) {
			AdminModel admin = (AdminModel)MainFrm.userObject;
			currentUserLabel.setText(admin.getName());
		}else if("学生".equals(MainFrm.userType.getName())) {
			StudentModel student = (StudentModel)MainFrm.userObject;
			currentUserLabel.setText(student.getName());
		}else if("教师".equals(MainFrm.userType.getName())) {
			TeacherModel teacher = (TeacherModel)MainFrm.userObject;
			currentUserLabel.setText(teacher.getName());
		}
	}

	protected void submitEdit(ActionEvent ae) {
		// TODO Auto-generated method stub
		String oldPassword = oldPasswordTextField.getText();
		String newPassword = newPasswordTextField.getText();
		String confirmPassword = confirmPasswordTextField.getText();
		if(StringUtil.isEmpty(oldPassword)) {
			JOptionPane.showMessageDialog(this, "请输入旧密码");
			return;
		}
		if(StringUtil.isEmpty(newPassword)) {
			JOptionPane.showMessageDialog(this, "请输入新密码");
			return;
		}
		if(StringUtil.isEmpty(confirmPassword)) {
			JOptionPane.showMessageDialog(this, "请再次输入新密码");
			return;
		}
		if(!newPassword.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(this, "两次密码输入不一致");
			return;
		}
		if(newPassword.equals(oldPassword)) {
			JOptionPane.showMessageDialog(this, "新密码不应与旧密码相同");
			return;
		}
		if("系统管理员".equals(MainFrm.userType.getName())) {
			AdminDao adminDao = new AdminDao();
			AdminModel adminTmp = new AdminModel();
			AdminModel admin = (AdminModel)MainFrm.userObject;
			adminTmp.setName(admin.getName());
			adminTmp.setId(admin.getId());
			adminTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));
			adminDao.closeDao();
			return;
		}
		if("学生".equals(MainFrm.userType.getName())) {
			StudentDao studentDao = new StudentDao();
			StudentModel studentTmp = new StudentModel();
			StudentModel student = (StudentModel)MainFrm.userObject;
			studentTmp.setName(student.getName());
			studentTmp.setPassword(oldPassword);
			studentTmp.setId(student.getId());
			JOptionPane.showMessageDialog(this, studentDao.editPassword(studentTmp, newPassword));
			studentDao.closeDao();
			return;
		}
		if("教师".equals(MainFrm.userType.getName())) {
			TeacherDao teacherDao = new TeacherDao();
			TeacherModel teacherTmp = new TeacherModel();
			TeacherModel teacher = (TeacherModel)MainFrm.userObject;
			teacherTmp.setName(teacher.getName());
			teacherTmp.setPassword(oldPassword);
			teacherTmp.setId(teacher.getId());
			JOptionPane.showMessageDialog(this, teacherDao.editPassword(teacherTmp, newPassword));
			teacherDao.closeDao();
			return;
		}
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
	
}
