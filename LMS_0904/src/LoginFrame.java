import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("로그인");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("학번 :");
        JTextField txtID = new JTextField(10);

        JLabel pwLabel = new JLabel("비밀번호 :");
        JPasswordField txtPW = new JPasswordField(10);

        JButton loginButton = new JButton("로그인");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String id = "60222126";
				String pw = "asd";
                
                if((id.equals(txtID.getText())) && (pw.equals(txtPW.getText()))) {
					JOptionPane.showMessageDialog(null, "로그인을 성공했습니다");
				} else {
					JOptionPane.showMessageDialog(null, "정보를 확인하고 다시 입력해주세요");

				}
            }
        });

        panel.add(idLabel);
        panel.add(txtID);
        panel.add(pwLabel);
        panel.add(txtPW);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginFrame frame = new LoginFrame();
                frame.setVisible(true);
            }
        });
    }
}
