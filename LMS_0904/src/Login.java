import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	public Login() {
		JPanel container = new JPanel();
		JPanel inputContainer = new JPanel();
		JPanel panel = new JPanel();
		JPanel title = new JPanel();
		
		JLabel titleLabel = new JLabel("통합 로그인");
		JLabel labelID = new JLabel("학번 ");
		JLabel labelPW = new JLabel("비밀번호 ");
		
		JTextField  txtID = new JTextField(10);
		JPasswordField txtPW = new JPasswordField(10);
		JButton loginBtn = new JButton("로그인");
		
		container.setLayout(new BorderLayout());
		inputContainer.setLayout(getLayout());
		inputContainer.setLayout(new GridLayout(2,2));
		
		title.add(titleLabel);
		
		inputContainer.add(title);
		
		panel.add(labelID);
		panel.add(txtID);
		panel.add(labelPW);
		panel.add(txtPW);
		
		inputContainer.add(panel);
		
		container.add(title, BorderLayout.NORTH);
		container.add(inputContainer);
		container.add(loginBtn, BorderLayout.SOUTH);

		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = "60222126";
				String pw = "asd";
				
				if((id.equals(txtID.getText())) && (pw.equals(txtPW.getText()))) {
					JOptionPane.showMessageDialog(null, "로그인을 성공하셨습니다");
				} else {
					JOptionPane.showMessageDialog(null, "정보를 확인하고 다시 입력해주세요");

				}
			}
		});
		
		add(container);
		
		setVisible(true);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
