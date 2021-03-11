package com.jkfgdvbt.view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.util.List;
import java.util.Vector;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import com.jkfgdvbt.dao.StudentDao;
import com.jkfgdvbt.dao.TeacherDao;
import com.jkfgdvbt.model.ClassModel;
import com.jkfgdvbt.model.StudentModel;
import com.jkfgdvbt.model.TeacherModel;
import com.jkfgdvbt.util.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 教师管理界面
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年3月8日
 */

public class ManageTeacherFrm extends JInternalFrame {
	private JTable teacherListTable;
	private JTextField searchTeacherNameTextField;
	private JTextField editTeacherNameTextField;
	private JTextField editTeacherPassowrdTextField;
	private JTextField editTeacherTitleTextField;
	private JTextField editTeacherAgeTextField;
	private JButton searchButton;
	private JRadioButton editTeacherSexMaleRadioButton;
	private JRadioButton editTeacherSexFemaleRadioButton;
	private JButton deleteButton;
	private JButton submitButton;
	private ButtonGroup sexButtonGroup;

	/**
	 * Create the frame.
	 */
	public ManageTeacherFrm() {
		setTitle("教师管理");
		setBounds(100, 100, 800, 600);
		setClosable(true);
		setIconifiable(true);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("教师姓名：");
		label.setFont(new Font("黑体", Font.PLAIN, 20));
		
		searchTeacherNameTextField = new JTextField();
		searchTeacherNameTextField.setFont(new Font("黑体", Font.PLAIN, 20));
		searchTeacherNameTextField.setColumns(10);
		
		searchButton = new JButton("查询");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchTeacher(ae);
			}
		});
		searchButton.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("教师姓名：");
		label_2.setFont(new Font("黑体", Font.PLAIN, 20));
		
		editTeacherNameTextField = new JTextField();
		editTeacherNameTextField.setFont(new Font("黑体", Font.PLAIN, 20));
		editTeacherNameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("教师性别：");
		label_3.setFont(new Font("黑体", Font.PLAIN, 20));
		
		editTeacherSexMaleRadioButton = new JRadioButton("男");
		editTeacherSexMaleRadioButton.setFont(new Font("黑体", Font.PLAIN, 20));
		
		editTeacherSexFemaleRadioButton = new JRadioButton("女");
		editTeacherSexFemaleRadioButton.setFont(new Font("黑体", Font.PLAIN, 20));
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(editTeacherSexFemaleRadioButton);
		sexButtonGroup.add(editTeacherSexMaleRadioButton);
		
		JLabel label_4 = new JLabel("教师职称");
		label_4.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_5 = new JLabel("登录密码：");
		label_5.setFont(new Font("黑体", Font.PLAIN, 20));
		
		editTeacherPassowrdTextField = new JTextField();
		editTeacherPassowrdTextField.setFont(new Font("黑体", Font.PLAIN, 20));
		editTeacherPassowrdTextField.setColumns(10);
		
		deleteButton = new JButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteTeacherAct(ae);
			}
		});
		deleteButton.setFont(new Font("黑体", Font.BOLD, 20));
		
		submitButton = new JButton("提交");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editTeacherAct(ae);
			}
		});
		submitButton.setFont(new Font("黑体", Font.BOLD, 20));
		
		editTeacherTitleTextField = new JTextField();
		editTeacherTitleTextField.setFont(new Font("黑体", Font.PLAIN, 20));
		editTeacherTitleTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("教师年龄：");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		
		editTeacherAgeTextField = new JTextField();
		editTeacherAgeTextField.setFont(new Font("黑体", Font.PLAIN, 20));
		editTeacherAgeTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchTeacherNameTextField, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(searchButton))
						.addComponent(scrollPane)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editTeacherTitleTextField))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(5)
									.addComponent(editTeacherNameTextField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editTeacherAgeTextField)))
							.addGap(95)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
									.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(5)
									.addComponent(editTeacherSexMaleRadioButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(77)
									.addComponent(editTeacherSexFemaleRadioButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
									.addComponent(editTeacherPassowrdTextField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))))
					.addGap(86))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(searchTeacherNameTextField, 0, 0, Short.MAX_VALUE)
							.addComponent(searchButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(editTeacherNameTextField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(editTeacherSexMaleRadioButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(editTeacherSexFemaleRadioButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(editTeacherTitleTextField, 0, 0, Short.MAX_VALUE)
							.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
						.addComponent(editTeacherPassowrdTextField, GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
						.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(editTeacherAgeTextField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		
		teacherListTable = new JTable();
		teacherListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		teacherListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6559\u5E08\u7F16\u53F7", "\u6559\u5E08\u59D3\u540D", "\u6559\u5E08\u6027\u522B", "\u6559\u5E08\u804C\u79F0", "\u6559\u5E08\u5E74\u9F84", "\u767B\u5F55\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(teacherListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new TeacherModel());
		setAuthority();
	}
	
	protected void editTeacherAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = teacherListTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要修改的数据。");
			return;
		}
		String teacherName = editTeacherNameTextField.getText();
		String teacherSex = editTeacherSexFemaleRadioButton.isSelected() ? "女" : "男";
		String teacherTitle = editTeacherTitleTextField.getText();
		int teacherAge;
		try{
			teacherAge = Integer.parseInt(editTeacherAgeTextField.getText());
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "年龄只允许输入数字。");
			return;
		}
		String teacherPassword = editTeacherPassowrdTextField.getText();
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
		int teacherId = Integer.parseInt(teacherListTable.getValueAt(row, 0).toString());
		teacher.setName(teacherName);
		teacher.setSex(teacherSex);
		teacher.setTitle(teacherTitle);
		teacher.setPassword(teacherPassword);
		teacher.setAge(teacherAge);
		teacher.setId(teacherId);
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.update(teacher)) {
			JOptionPane.showMessageDialog(this, "修改成功。");
		}else {
			JOptionPane.showMessageDialog(this, "修改失败。");
		}
		teacherDao.closeDao();
		setTable(new TeacherModel());
	}

	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) teacherListTable.getModel();
		editTeacherNameTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 1).toString());
		editTeacherTitleTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 3).toString());
		String sex = dft.getValueAt(teacherListTable.getSelectedRow(), 2).toString();
		sexButtonGroup.clearSelection();
		if(sex.equals(editTeacherSexMaleRadioButton.getText())) editTeacherSexMaleRadioButton.setSelected(true);
		else editTeacherSexFemaleRadioButton.setSelected(true);
		editTeacherAgeTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 4).toString());
		editTeacherPassowrdTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 5).toString());	
	}

	protected void searchTeacher(ActionEvent ae) {
		// TODO Auto-generated method stub
		TeacherModel teacher = new TeacherModel();
		teacher.setName(searchTeacherNameTextField.getText());
		setTable(teacher);
	}

	protected void deleteTeacherAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = teacherListTable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要删除的数据。");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "是否确定删除？") != JOptionPane.OK_OPTION) return;
		int id = Integer.parseInt(teacherListTable.getValueAt(row, 0).toString());
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.delete(id)) {
			JOptionPane.showMessageDialog(this, "删除成功。");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败。");
		}
		teacherDao.closeDao();
		setTable(new TeacherModel());
	}

	private void setTable(TeacherModel teacher) {
		if("教师".equals(MainFrm.userType.getName())) {
			TeacherModel t = (TeacherModel)MainFrm.userObject;
			teacher.setName(t.getName());
		}
		DefaultTableModel defaultTableModel = (DefaultTableModel) teacherListTable.getModel();
		defaultTableModel.setRowCount(0);// 清空列表
		TeacherDao teacherDao = new TeacherDao();
		List<TeacherModel> teacherList = teacherDao.getTeacherList(teacher);
		for (TeacherModel t : teacherList) {
			Vector v = new Vector();
			v.add(t.getId());
			v.add(t.getName());
			v.add(t.getSex());
			v.add(t.getTitle());
			v.add(t.getAge());
			v.add(t.getPassword());
			defaultTableModel.addRow(v);//按顺序填充表格
		}
		teacherDao.closeDao();
	}
	
	private void setAuthority() {
		if("教师".equals(MainFrm.userType.getName())) {
			searchButton.setEnabled(false);
			searchTeacherNameTextField.setEnabled(false);
			submitButton.setEnabled(false);
			deleteButton.setEnabled(false);
		}
	}
	
}
