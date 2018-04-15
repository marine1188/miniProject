package chattingFinsh;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextArea jta = new JTextArea(40, 25);
	private JTextField jtf = new JTextField(25);
	private JPanel  jp =new JPanel();
	private ServerBackground server = new ServerBackground();
	private JLabel jLabel1=new JLabel("대화명");//펫말
	private JTextArea jTextArea1=new JTextArea();//총 대화창
	private JTextArea jTextArea2=new JTextArea("현재 접속자\n");
	private JScrollPane jScrollPane1=new JScrollPane(jTextArea2);//접속자들
	private JScrollPane jScrollPane=new JScrollPane(jTextArea1);
	private JTextField jTextField2=new JTextField();//대화쓰는 창
	private JButton jButton2=new JButton("보내기");//이름표(누르면 대화 보내기)
	private JTextField jTextField1=new JTextField("");



	public ServerGui() throws IOException {
		jp.setLayout(null);
		//-------------------------------------------------
		
		add(jp); 
		
		JMenu menu1=new JMenu("메뉴");
		menu1.setForeground(Color.WHITE);
		menu1.setFont(new Font("serif", Font.BOLD,15));
		menu1.setBounds(4,10,60,50);
		jp.add(menu1);
		
		JMenu menu2=new JMenu("개발자 정보");
		menu2.setForeground(Color.WHITE);
		menu2.setFont(new Font("serif", Font.BOLD,15));
		menu2.setBounds(70,10,130,50);
		jp.add(menu2);
		
		
		
		
		//JLabel jLabel1=new JLabel("대화명");//펫말
		jLabel1.setBounds(4,55,50,30);
		jLabel1.setForeground(Color.WHITE);
		jp.add(jLabel1);

		//JTextArea jTextArea2=new JTextArea("현재 접속자\n");
		jTextArea2.setBounds(4,80,300,50);

		
		jLabel1=new JLabel("현재");
		jLabel1.setForeground(Color.WHITE);
		jLabel1.setBounds(4,90,50,30);
		jp.add(jLabel1);
		
		jLabel1=new JLabel("접속자");
		jLabel1.setForeground(Color.WHITE);
		jLabel1.setBounds(4,110,50,30);
		jp.add(jLabel1);
		
		
		
		
		jTextArea2.setEditable(true);
		//JScrollPane jScrollPane=new JScrollPane(jTextArea2);
		jScrollPane1.setBounds(50,90,300,100);
		//this.add(jScrollPane);//현재 접속자들
		jp.add(jScrollPane1);
		//JTextField jTextField1=new JTextField("");
		jTextField1.setBounds(50,50,300,30);
		jp.add(jTextField1);//자기 닉네임이 떠야한다.


		/*	//-----------------------------------------------
	      JButton jButton1 =new JButton(" 로그아웃");//걍 뒤로가기
	      jButton1.setBounds(250,10,100,30);
	      add(jButton1);
	//---------------------------------------------------
		 */	      //JTextArea jTextArea1=new JTextArea();//총 대화창
		//JScrollPane jScrollPane=new JScrollPane(jTextArea1);//스크롤
		jScrollPane.setBounds(50,200,300,370);
		//jTextArea1.setBounds(50,200,300,370);
		//jp.add(jTextArea1);
		jp.add(jScrollPane);


		//JButton jButton2=new JButton("보내기");//이름표(누르면 대화 보내기)
		jButton2.setBounds(250,570,100,70);
		jp.add(jButton2);
		jButton2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String msg = "서버 : "+ jTextField2.getText() + "\n";
				System.out.print(msg);
				server.sendMessage(msg);
				jTextField2.setText("");
				
		    }
		});
		ImageIcon ic =new ImageIcon("C:\\Users\\BIT\\Desktop\\galaxy.jpg");//이미지 불러오기
		JLabel lbmage1 =new JLabel(ic);  // 프래임 안에 들어갈 객첵 생성
		
		
		lbmage1.setBounds(0,0,400,700);//  ,가로 ,세로
		//JpaneTest에 들어 가게 하는 코드
		jp.add(lbmage1);  
		//JTextField jTextField2=new JTextField();//대화쓰는 창
		jTextField2.setBounds(50,570,200,70);
		jp.add(jTextField2);



		//---------------------------------------------------

		//jp.add(jTextArea1);
		//jp.add(jTextField2);
		jTextField2.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200, 100, 400, 700);
		setTitle("서버부분");

		server.setGui(this);
		server.setting();
		
	}

	public static void main(String[] args) throws IOException {
		
		new ServerGui();
		 

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = "서버 : "+ jTextField2.getText() + "\n";
		System.out.print(msg);
		server.sendMessage(msg);
		jTextField2.setText("");
	}

	public void appendMsg(String msg) {
		jTextArea1.append(msg);
		jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());

	}

	public void appendNick(String nickname) {
		// TODO Auto-generated method stub
		jTextArea2.append(nickname);
		
	}


	

}
