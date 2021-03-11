package com.jkfgdvbt.view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

import com.jkfgdvbt.dao.ClassDao;
import com.jkfgdvbt.dao.StudentDao;
import com.jkfgdvbt.dao.StudentDao;
import com.jkfgdvbt.model.ClassModel;
import com.jkfgdvbt.model.StudentModel;
import com.jkfgdvbt.model.StudentModel;
import com.jkfgdvbt.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 学生管理界面
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年3月3日
 */

public class ManageStudentFrm extends JInternalFrame {
	private JTable studentListTable;
	private JTextField searchStudentNameTextField;
	private JTextField editStudentNameTextField;
	private JTextField editStudentPasswordTextField;
	private JComboBox searchStudentClassComboBox;
	private List<ClassModel> studentClassList;
	private JComboBox editStudentClassComboBox;
	private ButtonGroup editSexButtonGroup;
	private JRadioButton editStudentSexMaleRadioButton;
	private JRadioButton editStudentSexFemaleRadioButton;
	private JButton deleteButton;
	private JButton submitButton;
	private JButton searchButton;

	/**
	 * Create the frame.
	 */
	public ManageStudentFrm() {
		setTitle("学生管理");
		setBounds(100, 100, 800, 600);
		setClosable(true);
		setIconifiable(true);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("学生姓名：");
		label.setFont(new Font("黑体", Font.PLAIN, 20));
		
		searchStudentNameTextField = new JTextField();
		searchStudentNameTextField.setFont(new Font("黑体", Font.PLAIN, 20));
		searchStudentNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("学生班级：");
		label_1.setFont(new Font("黑体", Font.PLAIN, 20));
		
		searchStudentClassComboBox = new JComboBox();
		searchStudentClassComboBox.setFont(new Font("黑体", Font.PLAIN, 20));
		
		searchButton = new JButton("查询");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchStudent(ae);
			}
		});
		searchButton.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("学生姓名：");
		label_2.setFont(new Font("黑体", Font.PLAIN, 20));
		
		editStudentNameTextField = new JTextField();
		editStudentNameTextField.setFont(new Font("黑体", Font.PLAIN, 20));
		editStudentNameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("学生性别：");
		label_3.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_4 = new JLabel("学生班级：");
		label_4.setFont(new Font("黑体", Font.PLAIN, 20));
		
		editStudentClassComboBox = new JComboBox();
		editStudentClassComboBox.setFont(new Font("黑体", Font.PLAIN, 20));
		
		editStudentSexMaleRadioButton = new JRadioButton("男");
		editStudentSexMaleRadioButton.setFont(new Font("黑体", Font.PLAIN, 20));
		
		editStudentSexFemaleRadioButton = new JRadioButton("女");
		editStudentSexFemaleRadioButton.setFont(new Font("黑体", Font.PLAIN, 20));
		
		editSexButtonGroup = new ButtonGroup();
		editSexButtonGroup.add(editStudentSexMaleRadioButton);
		editSexButtonGroup.add(editStudentSexFemaleRadioButton);
		
		JLabel label_5 = new JLabel("登录密码：");
		label_5.setFont(new Font("黑体", Font.PLAIN, 20));
		
		editStudentPasswordTextField = new JTextField();
		editStudentPasswordTextField.setFont(new Font("黑体", Font.PLAIN, 20));
		editStudentPasswordTextField.setColumns(10);
		
		submitButton = new JButton("确认修改");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submiteditAct(ae);
			}
		});
		submitButton.setFont(new Font("黑体", Font.BOLD, 20));
		
		deleteButton = new JButton("删除学生");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteStudent(ae);
			}
		});
		deleteButton.setFont(new Font("黑体", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchStudentClassComboBox, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(submitButton)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_4)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(editStudentClassComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_5, Alignment.TRAILING)
										.addComponent(label_3, Alignment.TRAILING))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(editStudentSexMaleRadioButton)
											.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
											.addComponent(editStudentSexFemaleRadioButton))
										.addComponent(editStudentPasswordTextField, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
								.addComponent(deleteButton))))
					.addGap(94))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(searchStudentClassComboBox, 0, 0, Short.MAX_VALUE)
							.addComponent(searchButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, 27, Short.MAX_VALUE)
						.addComponent(editStudentSexMaleRadioButton, 0, 0, Short.MAX_VALUE)
						.addComponent(label_3)
						.addComponent(editStudentSexFemaleRadioButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(editStudentClassComboBox, 0, 0, Short.MAX_VALUE)
							.addComponent(label_5)
							.addComponent(editStudentPasswordTextField, 0, 0, Short.MAX_VALUE))
						.addComponent(label_4))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(deleteButton))
					.addGap(50))
		);
		
		studentListTable = new JTable();
		studentListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		studentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751F\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u6240\u5C5E\u73ED\u7EA7", "\u5B66\u751F\u6027\u522B", "\u767B\u5F55\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(studentListTable);
		getContentPane().setLayout(groupLayout);
		setStudentClassInfo();
		setTable(new StudentModel());
		setAuthority();
	}
	
	protected void submiteditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = studentListTable.getSelectedRow();
		String studentName = editStudentNameTextField.getText();
		String studentPassword = editStudentPasswordTextField.getText();
		if(StringUtil.isEmpty(studentName)) {
			JOptionPane.showMessageDialog(this, "请填写学生姓名。");
			return;
		}
		if(StringUtil.isEmpty(studentPassword)) {
			JOptionPane.showMessageDialog(this, "请填写密码。");
			return;
		}
		StudentModel student = new StudentModel();
		student.setName(studentName);
		student.setPassword(editStudentPasswordTextField.getText());
		ClassModel sc = (ClassModel)editStudentClassComboBox.getSelectedItem();
		student.setClassId(sc.getId());
		student.setId(Integer.parseInt(studentListTable.getValueAt(row, 0).toString()));
		if(editStudentSexMaleRadioButton.isSelected()) student.setSex(editStudentSexMaleRadioButton.getText());
		else student.setSex(editStudentSexFemaleRadioButton.getText());
		StudentDao studentDao = new StudentDao();
		if(studentDao.update(student)) {
			JOptionPane.showMessageDialog(this, "修改成功。");
		}else {
			JOptionPane.showMessageDialog(this, "修改失败。");
		}
		setTable(new StudentModel());
		studentDao.closeDao();
	}

	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
		editStudentNameTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 1).toString());
		String className = dft.getValueAt(studentListTable.getSelectedRow(), 2).toString();
		for(int i = 0; i < editStudentClassComboBox.getItemCount(); i++) {
			ClassModel sc = (ClassModel)editStudentClassComboBox.getItemAt(i);
			if(className.equals(sc.getName())) {
				editStudentClassComboBox.setSelectedIndex(i);
			}
		}
		String sex = dft.getValueAt(studentListTable.getSelectedRow(), 3).toString();
		editSexButtonGroup.clearSelection();
		if(sex.equals(editStudentSexMaleRadioButton.getText())) editStudentSexMaleRadioButton.setSelected(true);
		else editStudentSexFemaleRadioButton.setSelected(true);
		editStudentPasswordTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 4).toString());
	}

	protected void deleteStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "是否确认删除？") != JOptionPane.OK_OPTION) {
			return;
		}
		int row = studentListTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选中要删除的学生。");
			return;
		}
		StudentDao studentDao = new StudentDao();
		if(studentDao.delete(Integer.parseInt(studentListTable.getValueAt(row, 0).toString()))) {
			JOptionPane.showMessageDialog(this, "删除成功。");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败。");
		}
		setTable(new StudentModel());
		studentDao.closeDao();
	}

	protected void searchStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		StudentModel student = new StudentModel();
		student.setName(searchStudentNameTextField.getText());
		ClassModel sc = (ClassModel)searchStudentClassComboBox.getSelectedItem();
		student.setClassId(sc.getId());
		setTable(student);
	}

	private void setTable(StudentModel student) {
		if("学生".equals(MainFrm.userType.getName())) {
			StudentModel s = (StudentModel)MainFrm.userObject;
			student.setName(s.getName());
		}
		DefaultTableModel defaultTableModel = (DefaultTableModel) studentListTable.getModel();
		defaultTableModel.setRowCount(0);// 清空列表
		StudentDao studentDao = new StudentDao();
		List<StudentModel> studentList = studentDao.getStudentList(student);
		for (StudentModel s : studentList) {
			Vector v = new Vector();
			v.add(s.getId());
			v.add(s.getName());
			v.add(getClassNameById(s.getClassId()));
			v.add(s.getSex());
			v.add(s.getPassword());
			defaultTableModel.addRow(v);//按顺序填充表格
		}
		studentDao.closeDao();
	}
	
	private void setStudentClassInfo() {
		ClassDao studentClassDao = new ClassDao();
		studentClassList = studentClassDao.getClassList(new ClassModel());
		for(ClassModel scm : studentClassList) {
			searchStudentClassComboBox.addItem(scm);
			editStudentClassComboBox.addItem(scm);
		}
		studentClassDao.closeDao();
		
	}
	
	private String getClassNameById(int id) {
		for(ClassModel scm : studentClassList) {
			if(scm.getId() == id) {
				return scm.getName();
			}
		}
		return "";
	}
	
	private void setAuthority() {
		if("学生".equals(MainFrm.userType.getName())) {
			StudentModel s = (StudentModel)MainFrm.userObject;
			searchStudentNameTextField.setEnabled(false);
			searchStudentClassComboBox.setEnabled(false);
			deleteButton.setEnabled(false);
			searchButton.setEnabled(false);
			submitButton.setEnabled(false);
		}
	}
	
}
