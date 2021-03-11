package com.jkfgdvbt.view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import com.jkfgdvbt.dao.TeacherDao;
import com.jkfgdvbt.model.TeacherModel;
import com.jkfgdvbt.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 添加教师揭界面
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年3月7日
 */

public class AddTeacherFrm extends JInternalFrame {
	private JTextField teacherNameTextField;
	private JTextField teacherTitleTextField;
	private JTextField teacherAgeTextField;
	private JRadioButton teacherSexMaleRadioButton;
	private JRadioButton teacherSexFemaleRadioButton;
	private ButtonGroup buttonGroup;
	private JTextField teacherPasswordTextField;

	/**
	 * Create the frame.
	 */
	public AddTeacherFrm() {
		setTitle("添加教师");
		setBounds(100, 100, 800, 600);
		setClosable(true);
		setIconifiable(true);
		
		JLabel label = new JLabel("教师姓名：");
		label.setFont(new Font("黑体", Font.PLAIN, 30));
		
		teacherNameTextField = new JTextField();
		teacherNameTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		teacherNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("教师性别：");
		label_1.setFont(new Font("黑体", Font.PLAIN, 30));
		
		buttonGroup = new ButtonGroup();
		teacherSexMaleRadioButton = new JRadioButton("男");
		teacherSexMaleRadioButton.setFont(new Font("黑体", Font.PLAIN, 30));
		teacherSexMaleRadioButton.setSelected(true);
		teacherSexFemaleRadioButton = new JRadioButton("女");
		teacherSexFemaleRadioButton.setFont(new Font("黑体", Font.PLAIN, 30));
		buttonGroup.add(teacherSexFemaleRadioButton);
		buttonGroup.add(teacherSexMaleRadioButton);
		
		JLabel label_2 = new JLabel("教师职称：");
		label_2.setFont(new Font("黑体", Font.PLAIN, 30));
		
		teacherTitleTextField = new JTextField();
		teacherTitleTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		teacherTitleTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("教师年龄：");
		label_3.setFont(new Font("黑体", Font.PLAIN, 30));
		
		teacherAgeTextField = new JTextField();
		teacherAgeTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		teacherAgeTextField.setColumns(10);
		
		JButton submitButton = new JButton("确认");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addTeacherAct(ae);
			}
		});
		submitButton.setFont(new Font("黑体", Font.BOLD, 30));
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setFont(new Font("黑体", Font.BOLD, 30));
		
		JLabel label_4 = new JLabel("登录密码：");
		label_4.setFont(new Font("黑体", Font.PLAIN, 30));
		
		teacherPasswordTextField = new JTextField();
		teacherPasswordTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		teacherPasswordTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(186)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addGap(18)
									.addComponent(teacherAgeTextField, 239, 239, 239))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addGap(18)
									.addComponent(teacherTitleTextField, 239, 239, 239))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addGap(18)
									.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(62)
									.addComponent(teacherSexMaleRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
									.addComponent(teacherSexFemaleRadioButton)
									.addGap(32))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(label_4)
									.addGap(18)
									.addComponent(teacherPasswordTextField, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(207)
							.addComponent(submitButton)
							.addGap(119)
							.addComponent(resetButton)))
					.addGap(191))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
						.addComponent(label))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(teacherSexMaleRadioButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(teacherSexFemaleRadioButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(teacherTitleTextField, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(teacherAgeTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(teacherPasswordTextField, 0, 0, Short.MAX_VALUE)
						.addComponent(label_4))
					.addGap(122)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(123))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		teacherNameTextField.setText("");
		teacherTitleTextField.setText("");
		teacherAgeTextField.setText("");
		teacherPasswordTextField.setText("");
		teacherSexMaleRadioButton.setSelected(true);
	}

	protected void addTeacherAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String teacherName = teacherNameTextField.getText();
		String teacherSex = teacherSexMaleRadioButton.isSelected() ? teacherSexMaleRadioButton.getText() : teacherSexFemaleRadioButton.getText();
		String teacherTitle = teacherTitleTextField.getText();
		String teacherPassword = teacherPasswordTextField.getText();
		int teacherAge;
		try{
			teacherAge = Integer.parseInt(teacherAgeTextField.getText());
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "年龄只允许输入数字。");
			return;
		}
		if(StringUtil.isEmpty(teacherName)) {
			JOptionPane.showMessageDialog(this, "请填写教师姓名。");
			return;
		}
		if(StringUtil.isEmpty(teacherSex)) {
			JOptionPane.showMessageDialog(this, "请填写教师性别。");
			return;
		}
		if(StringUtil.isEmpty(teacherTitle)) {
			JOptionPane.showMessageDialog(this, "请填写教师职称。");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)) {
			JOptionPane.showMessageDialog(this, "请填写登录密码。");
			return;
		}
		if(teacherAge <= 0 || teacherAge > 120) {
			JOptionPane.showMessageDialog(this, "请填写正确教师年龄。");
			return;
		}
		TeacherModel teacher = new TeacherModel();
		teacher.setName(teacherName);
		teacher.setSex(teacherSex);
		teacher.setTitle(teacherTitle);
		teacher.setAge(teacherAge);
		teacher.setPassword(teacherPassword);
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.addTeacher(teacher)) {
			JOptionPane.showMessageDialog(this, "教师添加成功。");
		}else {
			JOptionPane.showMessageDialog(this, "教师添加失败。");
		}
		resetValue(ae);
	}
}
