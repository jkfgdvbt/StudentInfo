package com.jkfgdvbt.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.jkfgdvbt.dao.ClassDao;
import com.jkfgdvbt.model.ClassModel;
import com.jkfgdvbt.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 添加班级界面
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月9日
 */

public class AddClassFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField classNameTextField;
	private JTextArea classInfoTextArea;

	/**
	 * Create the frame.
	 */
	public AddClassFrm() {
		setTitle("添加班级");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		
		JLabel label = new JLabel("班级名称：");
		label.setFont(new Font("黑体", Font.PLAIN, 30));
		
		classNameTextField = new JTextField();
		classNameTextField.setFont(new Font("黑体", Font.PLAIN, 30));
		classNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("班级信息：");
		label_1.setFont(new Font("黑体", Font.PLAIN, 30));
		
		classInfoTextArea = new JTextArea();
		classInfoTextArea.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JButton submitButton = new JButton("提交");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitClass(ae);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(186)
							.addComponent(submitButton))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(113, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label))
							.addGap(20)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(classInfoTextArea)
								.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(89, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(resetButton)
							.addGap(177))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(122)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(classInfoTextArea, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(65))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void submitClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		String className = classNameTextField.getText();
		String classInfo = classInfoTextArea.getText();
		if(StringUtil.isEmpty(className)) {
			JOptionPane.showMessageDialog(this, "班级名不能为空");
			return;
		}
		ClassModel scl = new ClassModel();
		scl.setInfo(classInfo);
		scl.setName(className);
		ClassDao classDao = new ClassDao();
		if(classDao.addClass(scl)) {
			JOptionPane.showMessageDialog(this, "班级添加成功");
		}else {
			JOptionPane.showMessageDialog(this, "班级添加失败");
		}
		classDao.closeDao();
		resetValue(ae);
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		classNameTextField.setText("");
		classInfoTextArea.setText("");
	}
}
