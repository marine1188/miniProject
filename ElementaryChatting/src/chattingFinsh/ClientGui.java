package chattingFinsh;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import javazoom.jl.player.Player;

public class ClientGui  extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel  jp =new JPanel();
	private JTextArea jta = new JTextArea(40, 25);
	private JTextField jtf = new JTextField(25);
	private JTextArea jTextArea1=new JTextArea();//총 대화창
	private JTextArea jTextArea2=new JTextArea("현재 접속자\n");
	private JScrollPane jScrollPane1=new JScrollPane(jTextArea2);//접속자들
	private JScrollPane jScrollPane=new JScrollPane(jTextArea1);
	private JLabel jLabel1=new JLabel("대화명");
	private JTextField jTextField1=new JTextField("");
	private JButton jButton2=new JButton("보내기");//이름표(누르면 대화 보내기)
	private JTextField jTextField2=new JTextField();//대화쓰는 창
	private ClientBackground client = new ClientBackground();
	private static String nickName;
	



	//private Player player;//자바줌싸이트 라이브러리중하나


	public ClientGui() {
		jp.setLayout(null);
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

		//JTextArea jTextArea2=new JTextArea("현재 접속자\n");
		jTextArea2.setBounds(4,80,300,50);
		jTextArea2.setEditable(true);
		jScrollPane1.setBounds(50,90,300,100);
		jp.add(jScrollPane1);

		jTextField1.setBounds(50,50,300,30);
		jp.add(jTextField1);//자기 닉네임이 떠야한다.
		jScrollPane.setBounds(50,200,300,370);

		jp.add(jScrollPane);

		//JButton jButton2=new JButton("보내기");//이름표(누르면 대화 보내기)
		jButton2.setBounds(250,570,100,70);
		jp.add(jButton2);

		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Play("C:\\Users\\BIT\\Desktop\\midtom.m4a");
				System.out.println("버튼 누름");
				String msg = nickName+ ":" + jTextField2.getText()+"\n";
				if(jTextField2.getText().equals("바보")){
					ImageIcon ic =new ImageIcon("C:\\Users\\BIT\\Desktop\\abong.jpg");//이미지 불러오기



					//jl.setBounds(800, 100, 400, 700);

					//setSize(300,500);
					/*	jp.add(jl);
					jTextArea1.setVisible(false);
					jTextField2.setVisible(false);*/

					//jp.setVisible(false);
					//jp.setBackground(new Color(255, 0, 0, 0));    //투명
					//jp.setOpaque(false);
					//jTextArea1.setOpaque(false);

					JPanel abong =new JPanel();
					jp.setVisible(false);


					//abong.setVisible(true);
					JLabel jl =new JLabel(ic);
					jl.setSize(800, 500);

					abong.add(jl);
					abong.setBounds(0, 0, 400, 700);
					add(abong);
					setLayout(null);
					setResizable(false);
					setVisible(true);
					/*JTextArea abong =new JTextArea();
					abong.setBounds(50,90,300,100);
					jp.add(abong);
					jTextArea1.remove(jTextArea1);
					jTextField2.enable();*/
				}else {
					client.sendMessage(msg);
					jTextField2.setText("");
				}

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


		jTextField2.addActionListener(this);





		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(800, 100, 400, 700);
		setTitle("클라이언트");

		client.setGui(this);
		client.setNickname(nickName);
		client.connet();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("당신의 닉네임은? : ");
		nickName = scanner.nextLine();
		scanner.close();		

		new ClientGui();

	}





	@Override
	//말치면 보내는 부분
	public void actionPerformed(ActionEvent e) {
		String msg = nickName+ ":" + jTextField2.getText()+"\n";
		if(jTextField2.getText().equals("바보")){
			ImageIcon ic =new ImageIcon("C:\\Users\\BIT\\Desktop\\abong.jpg");//이미지 불러오기



			//jl.setBounds(800, 100, 400, 700);

			//setSize(300,500);
			/*	jp.add(jl);
			jTextArea1.setVisible(false);
			jTextField2.setVisible(false);*/

			//jp.setVisible(false);
			//jp.setBackground(new Color(255, 0, 0, 0));    //투명
			//jp.setOpaque(false);
			//jTextArea1.setOpaque(false);

			JPanel abong =new JPanel();
			jp.setVisible(false);


			//abong.setVisible(true);
			JLabel jl =new JLabel(ic);
			jl.setSize(800, 500);

			abong.add(jl);
			abong.setBounds(0, 0, 400, 700);
			add(abong);
			setLayout(null);
			setResizable(false);
			setVisible(true);
			/*JTextArea abong =new JTextArea();
			abong.setBounds(50,90,300,100);
			jp.add(abong);
			jTextArea1.remove(jTextArea1);
			jTextField2.enable();*/
		}else {
			client.sendMessage(msg);
			jTextField2.setText("");
		}



	}

	public void appendMsg(String msg) {
		jTextArea1.append(msg);
		jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());

	}
	/*public void appendNick(String nickName) {
		// TODO Auto-generated method stub
		jTextfield1.setText(nickName);
	}*/













}
