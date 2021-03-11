package com.jkfgdvbt.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.jkfgdvbt.dao.ClassDao;
import com.jkfgdvbt.model.ClassModel;
import com.jkfgdvbt.util.StringUtil;

/**
 * 班级管理界面
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月11日
 */

public class ManageClassFrm extends JInternalFrame {
	private JTextField searchStudentClassNameTextField;
	private JTable classListTable;
	private JTextField editClassNameTextField;
	private JTextArea editClassInfoTextArea;

	/**
	 * Create the frame.
	 */
	public ManageClassFrm() {
		setTitle("班级信息管理");
		setBounds(100, 100, 800, 600);
		setClosable(true);
		setIconifiable(true);
		
		JLabel label = new JLabel("班级名称：");
		label.setFont(new Font("黑体", Font.PLAIN, 30));
		
		searchStudentClassNameTextField = new JTextField();
		searchStudentClassNameTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		searchStudentClassNameTextField.setColumns(10);
		
		JButton SearchButton = new JButton("查询");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ClassModel sc = new ClassModel();
				sc.setName(searchStudentClassNameTextField.getText());
				setTable(sc);
			}
		});
		SearchButton.setFont(new Font("黑体", Font.PLAIN, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_1 = new JLabel("班级名称：");
		label_1.setFont(new Font("黑体", Font.PLAIN, 30));
		
		editClassNameTextField = new JTextField();
		editClassNameTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		editClassNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("班级信息：");
		label_2.setFont(new Font("黑体", Font.PLAIN, 30));
		
		editClassInfoTextArea = new JTextArea();
		
		JButton submitEditButton = new JButton("修改");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
			}
		});
		submitEditButton.setFont(new Font("黑体", Font.PLAIN, 30));
		
		JButton submitDeleteButton = new JButton("删除");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitDeleteAct(ae);
			}
		});
		submitDeleteButton.setFont(new Font("黑体", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editClassInfoTextArea, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editClassNameTextField, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(submitDeleteButton)
								.addComponent(submitEditButton)))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchStudentClassNameTextField, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(SearchButton)))
					.addGap(73))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(searchStudentClassNameTextField, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)
							.addComponent(SearchButton, GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(submitEditButton, GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_2)
						.addComponent(editClassInfoTextArea, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
						.addComponent(submitDeleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		classListTable = new JTable();
		classListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		classListTable.setFont(new Font("黑体", Font.PLAIN, 20));
		classListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"班级编号", "班级名称", "班级信息"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		classListTable.getColumnModel().getColumn(2).setPreferredWidth(261);
		scrollPane.setViewportView(classListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new ClassModel());
	}
	
	protected void submitDeleteAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "是否确认删除？") != JOptionPane.OK_OPTION) {
			return;
		}
		int index = classListTable.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(this, "请选中要删除的班级。");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		ClassDao classDao = new ClassDao();
		if(classDao.delete(id)) {
			JOptionPane.showMessageDialog(this, "删除成功。");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败。");
		}
		classDao.closeDao();
		setTable(new ClassModel());//无论成功失败都要刷新表格
	}

	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int index = classListTable.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(this, "请选中要修改的班级。");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		String className = dft.getValueAt(classListTable.getSelectedRow(), 1).toString();
		String classInfo = dft.getValueAt(classListTable.getSelectedRow(), 2).toString();
		String editClassName = editClassNameTextField.getText();
		String editClassInfo = editClassInfoTextArea.getText();
		if(StringUtil.isEmpty(editClassName)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的班级名称。");
			return;
		}
		if(className.equals(editClassName) && classInfo.equals(editClassInfo)) {
			JOptionPane.showMessageDialog(this, "未做任何修改。");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "是否确认修改？") != JOptionPane.OK_OPTION) {
			return;
		}
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		ClassModel sc = new ClassModel();
		sc.setId(id);
		sc.setInfo(editClassInfo);
		sc.setName(editClassName);
		
		ClassDao classDao = new ClassDao();
		if(classDao.update(sc)) {
			JOptionPane.showMessageDialog(this, "修改成功。");
		}else {
			JOptionPane.showMessageDialog(this, "修改失败。");
		}
		classDao.closeDao();
		setTable(new ClassModel());//无论成功失败都要刷新表格
	}

	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(), 1).toString());
		editClassInfoTextArea.setText(dft.getValueAt(classListTable.getSelectedRow(), 2).toString());
	}

	private void setTable(ClassModel studentClass) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) classListTable.getModel();
		defaultTableModel.setRowCount(0);// 清空列表
		ClassDao classDao = new ClassDao();
		List<ClassModel> classList = classDao.getClassList(studentClass);
		for (ClassModel sc : classList) {
			Vector v = new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getInfo());
			defaultTableModel.addRow(v);//按顺序填充表格
		}
		classDao.closeDao();
	}
}
