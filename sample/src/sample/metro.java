package sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class metro {

	private JFrame frame;
	private JTextField tb1;
	protected JComboBox cb1;
	protected JComboBox cb2;
	protected Object cb3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					metro window = new metro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public metro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Metro App");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(118, 11, 103, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(81, 64, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("source");
		lblNewLabel_2.setBounds(81, 108, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("destination");
		lblNewLabel_3.setBounds(81, 156, 67, 17);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("numtickets");
		lblNewLabel_4.setBounds(81, 200, 67, 17);
		frame.getContentPane().add(lblNewLabel_4);
		
		tb1 = new JTextField();
		tb1.setBounds(177, 61, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tb1.getText();
				String source=(String) cb1.getSelectedItem();
				String destination=(String) cb2.getSelectedItem();
				String nt=(String) ((JComboBox) cb3).getSelectedItem();
				int numtickets=Integer.parseInt(nt);
				int bill=0;
				if(source.equals(destination))
				{
					JOptionPane.showConfirmDialog(btnNewButton, "plz check stations");
				}
				else
				{
					bill=bill+45*numtickets;
					JOptionPane.showMessageDialog(btnNewButton, " name "+name+"\nsource"+source+"\n destination"+destination+"\n number tickets "+nt+"\n bill"+bill);
			
				}
			}
		});
		btnNewButton.setBounds(146, 238, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"select", "jbs", "cbs", "kompally"}));
		cb1.setBounds(177, 104, 86, 18);
		frame.getContentPane().add(cb1);
		
		JComboBox cb2 = new JComboBox();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"select", "jbs", "cbs", "kompally"}));
		cb2.setBounds(177, 153, 86, 20);
		frame.getContentPane().add(cb2);
		
		JComboBox cb3 = new JComboBox();
		cb3.setModel(new DefaultComboBoxModel(new String[] {"select", "1", "2", "3", "4", "5", "6"}));
		cb3.setBackground(new Color(255, 255, 255));
		cb3.setBounds(177, 197, 86, 17);
		frame.getContentPane().add(cb3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\on line\\Desktop\\download (2).jfif"));
		lblNewLabel_5.setBounds(301, 47, 123, 163);
		frame.getContentPane().add(lblNewLabel_5);
	}

}
