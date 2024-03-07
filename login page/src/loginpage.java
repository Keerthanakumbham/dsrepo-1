import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class loginpage {

	private JFrame frame;
	private JTextField tb1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage window = new loginpage();
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
	public loginpage() {
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
		
		JLabel lblNewLabel = new JLabel("login page");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(89, 11, 136, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(61, 67, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(41, 148, 66, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tb1.getText();
				String password=p1.getText();
				try {
					 java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","mrec");
					 PreparedStatement stn=con.prepareStatement
							 ("select name,password from users where name=? and password=?");
					 stn.setString(1,name);
					 stn.setString(2, password);
					 ResultSet rs=stn.executeQuery();
					 if(rs.next())
					 {
						 JOptionPane.showMessageDialog(btnNewButton, "valid user");
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(btnNewButton, "invalid user");
					 }
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
				
			}
			
		});
		btnNewButton.setBounds(136, 213, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		tb1 = new JTextField();
		tb1.setBounds(136, 64, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBounds(136, 145, 86, 20);
		frame.getContentPane().add(p1);
	}
}
