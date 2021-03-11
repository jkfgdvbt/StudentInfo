package com.jkfgdvbt.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.jkfgdvbt.dao.ClassDao;
import com.jkfgdvbt.dao.StudentDao;
import com.jkfgdvbt.model.ClassModel;
import com.jkfgdvbt.model.StudentModel;
import com.jkfgdvbt.util.StringUtil;

/**
 * 添加学生界面
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月27日
 */

public class AddStudentFrm extends JInternalFrame {
	private JTextField studentNameTextField;
	private JPasswordField studentPasswordField;
	private ButtonGroup sexButtonGroup;
	private JRadioButton studentSexFemaleRadioButton;
	private JRadioButton studentSexMaleRadioButton;
	private JComboBox studentClassComboBox;

	/**
	 * Create the frame.
	 */
	public AddStudentFrm() {
		setTitle("添加学生");
		setBounds(100, 100, 800, 600);
		setClosable(true);
		setIconifiable(true);
		
		JLabel label = new JLabel("学生姓名：");
		label.setFont(new Font("黑体", Font.PLAIN, 30));
		
		studentNameTextField = new JTextField();
		studentNameTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		studentNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("所属班级：");
		label_1.setFont(new Font("黑体", Font.PLAIN, 30));
		
		studentClassComboBox = new JComboBox();
		studentClassComboBox.setFont(new Font("黑体", Font.PLAIN, 30));
		
		JLabel label_2 = new JLabel("登录密码：");
		label_2.setFont(new Font("黑体", Font.PLAIN, 30));
		
		studentPasswordField = new JPasswordField();
		studentPasswordField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		JLabel label_3 = new JLabel("学生性别：");
		label_3.setFont(new Font("黑体", Font.PLAIN, 30));
		
		studentSexMaleRadioButton = new JRadioButton("男");
		studentSexMaleRadioButton.setFont(new Font("黑体", Font.PLAIN, 30));
		
		studentSexFemaleRadioButton = new JRadioButton("女");
		studentSexFemaleRadioButton.setFont(new Font("黑体", Font.PLAIN, 30));
		
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(studentSexFemaleRadioButton);
		sexButtonGroup.add(studentSexMaleRadioButton);
		
		JButton submitButton = new JButton("确认");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				studentAddAct(ae);
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(136)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(submitButton)
							.addPreferredGap(ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
							.addComponent(resetButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addGap(82)
							.addComponent(studentSexMaleRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
							.addComponent(studentSexFemaleRadioButton)
							.addGap(71))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(studentPasswordField, 350, 350, 350))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(studentClassComboBox, 0, 350, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)))
					.addGap(136))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(studentNameTextField, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
						.addComponent(label))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(studentClassComboBox, 0, 0, Short.MAX_VALUE)
						.addComponent(label_1, Alignment.LEADING))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(studentPasswordField, 0, 0, Short.MAX_VALUE)
						.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(studentSexFemaleRadioButton, 0, 0, Short.MAX_VALUE)
						.addComponent(studentSexMaleRadioButton, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(74))
		);
		getContentPane().setLayout(groupLayout);
		setStudentClassInfo();
	}

	protected void studentAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String studentName = studentNameTextField.getText();
		String studentPassword = studentPasswordField.getText();
		if(StringUtil.isEmpty(studentName)) {
			JOptionPane.showMessageDialog(this, "请填写姓名。");
			return;
		}
		if(StringUtil.isEmpty(studentPassword)) {
			JOptionPane.showMessageDialog(this, "请填写密码。");
			return;
		}
		if(!studentSexFemaleRadioButton.isSelected() && !studentSexMaleRadioButton.isSelected()) {
			JOptionPane.showMessageDialog(this, "请选择性别。");
			return;
		}
		ClassModel scm = (ClassModel) studentClassComboBox.getSelectedItem();
		String sex = studentSexMaleRadioButton.isSelected() ? studentSexMaleRadioButton.getText() : studentSexFemaleRadioButton.getText();
		StudentModel sm = new StudentModel();
		sm.setName(studentName);
		sm.setPassword(studentPassword);
		sm.setClassId(scm.getId());
		sm.setSex(sex);
		StudentDao studentDao = new StudentDao();
		if(studentDao.addStudent(sm)) {
			JOptionPane.showMessageDialog(this, "添加成功。");
		}else {
			JOptionPane.showMessageDialog(this, "添加失败。");
		}
		resetValue(ae);
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		studentNameTextField.setText("");
		studentPasswordField.setText("");
		studentClassComboBox.setSelectedIndex(0);
		sexButtonGroup.clearSelection();
	}
	
	private void setStudentClassInfo() {
		ClassDao studentClassDao = new ClassDao();
		List<ClassModel> classList = studentClassDao.getClassList(new ClassModel());
		for(ClassModel scm : classList) {
			studentClassComboBox.addItem(scm);
		}
		studentClassDao.closeDao();
		
	}
}
