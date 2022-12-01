import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class MainPage extends JFrame {
	int i;
	Font f1;
	ImageIcon img_slider1[], img_slider2[], sign[];
	JPanel panel1, panel2, panel3;
	JLabel logo_img, user_name, go_label[];
	JButton button_mypage, button_logout, left_slider, right_slider, button_slider1, button_slider2, go_button[];
	JRadioButton img_JRadio[];
	Thread th;
	ButtonGroup bg;

	public MainPage() {
		frame();

		panel1 = new JPanel();

		logo_img = new JLabel(new ImageIcon("logo.png"));
		logo_img.setBounds(20, 20, 150, 80);
		panel1.add(logo_img);

		f1 = new Font("Aharoni", Font.BOLD, 13);
		user_name = new JLabel("홍길동 님 환영합니다.");
		user_name.setFont(new Font("Aharoni 굵게", Font.BOLD, 20));
		user_name.setBounds(350, 10, 300, 50);
		panel1.add(user_name);

		button_mypage = new JButton("마이페이지");
		button_mypage.setFont(f1);
		button_mypage.setBounds(380, 70, 110, 50);
		button_mypage.setBorderPainted(false);
		button_mypage.setContentAreaFilled(false);
		button_mypage.setFocusPainted(false);
		button_mypage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel1.add(button_mypage);

		button_logout = new JButton("로그아웃");
		button_logout.setFont(f1);
		button_logout.setBounds(470, 70, 100, 50);
		button_logout.setBorderPainted(false);
		button_logout.setContentAreaFilled(false);
		button_logout.setFocusPainted(false);
		button_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel1.add(button_logout);

		panel1.setPreferredSize(new Dimension(600, 120));
		panel1.setLayout(null);
		add(panel1, BorderLayout.NORTH);

		panel2 = new JPanel();

		th = new Thread(rr);
		th.start();
		
		img_JRadio = new JRadioButton[4];
		for (int t=0; t<4; t++) {
			img_JRadio[t] = new JRadioButton();
			img_JRadio[t].setBorderPainted(false);
			img_JRadio[t].setContentAreaFilled(false);
			img_JRadio[t].setFocusPainted(false);
			img_JRadio[t].setEnabled(false);
			img_JRadio[t].setBounds(240+30*t,220, 32, 32);
			panel2.add(img_JRadio[t]);
		}
		img_JRadio[0].setSelected(true);
		
		img_slider1 = new ImageIcon[4];
		img_slider1[0] = new ImageIcon("1.png");
		img_slider1[1] = new ImageIcon("2.png");
		img_slider1[2] = new ImageIcon("3.png");
		img_slider1[3] = new ImageIcon("4.png");
		img_slider2 = new ImageIcon[4];
		img_slider2[0] = new ImageIcon("2.png");
		img_slider2[1] = new ImageIcon("3.png");
		img_slider2[2] = new ImageIcon("4.png");
		img_slider2[3] = new ImageIcon("1.png");
		sign = new ImageIcon[2];
		sign[0] = new ImageIcon("left.png");
		sign[1] = new ImageIcon("right.png");


		left_slider = new JButton(sign[0]);
		left_slider.setBounds(25, 100, 40, 40);
		left_slider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (img_JRadio[0].isSelected() == true) {
					img_JRadio[0].setSelected(false);
					img_JRadio[3].setSelected(true);
					button_slider1.setIcon(img_slider1[3]);
					button_slider2.setIcon(img_slider2[3]);
				} 
				else if (img_JRadio[1].isSelected() == true) {
					img_JRadio[1].setSelected(false);
					img_JRadio[0].setSelected(true);
					button_slider1.setIcon(img_slider1[0]);
					button_slider2.setIcon(img_slider2[0]);
				}
				else if (img_JRadio[2].isSelected() == true) {
					img_JRadio[2].setSelected(false);
					img_JRadio[1].setSelected(true);
					button_slider1.setIcon(img_slider1[1]);
					button_slider2.setIcon(img_slider2[1]);
				}
				else if (img_JRadio[3].isSelected() == true) {
					img_JRadio[3].setSelected(false);
					img_JRadio[2].setSelected(true);
					button_slider1.setIcon(img_slider1[2]);
					button_slider2.setIcon(img_slider2[2]);
				} 
			}
		});
		panel2.add(left_slider);

		right_slider = new JButton(sign[1]);
		right_slider.setBounds(520, 100, 40, 40);
		right_slider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (img_JRadio[3].isSelected() == true) {
					img_JRadio[3].setSelected(false);
					img_JRadio[0].setSelected(true);
					button_slider1.setIcon(img_slider1[0]);
					button_slider2.setIcon(img_slider2[0]);
				} 
				else if (img_JRadio[1].isSelected() == true) {
					img_JRadio[1].setSelected(false);
					img_JRadio[2].setSelected(true);
					button_slider1.setIcon(img_slider1[2]);
					button_slider2.setIcon(img_slider2[2]);
				}
				else if (img_JRadio[2].isSelected() == true) {
					img_JRadio[2].setSelected(false);
					img_JRadio[3].setSelected(true);
					button_slider1.setIcon(img_slider1[3]);
					button_slider2.setIcon(img_slider2[3]);
				}
				else if (img_JRadio[0].isSelected() == true){
					img_JRadio[0].setSelected(false);
					img_JRadio[1].setSelected(true);
					button_slider1.setIcon(img_slider1[1]);
					button_slider2.setIcon(img_slider2[1]);
				}

			}
		});
		panel2.add(right_slider);

		button_slider1 = new JButton();
		button_slider1.setBounds(120, 45, 160, 160);
		button_slider1.setBorderPainted(false);
		button_slider1.setContentAreaFilled(false);
		button_slider1.setFocusPainted(false);
		button_slider1.setIcon(img_slider1[0]);
		button_slider1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel2.add(button_slider1);

		button_slider2 = new JButton();
		button_slider2.setBounds(310, 45, 160, 160);
		button_slider2.setBorderPainted(false);
		button_slider2.setContentAreaFilled(false);
		button_slider2.setFocusPainted(false);
		button_slider2.setIcon(img_slider2[0]);
		button_slider2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel2.add(button_slider2);

		panel2.setLayout(null);
		panel2.setPreferredSize(new Dimension(600, 250));
		add(panel2, BorderLayout.CENTER);

		panel3 = new JPanel();

		go_button = new JButton[12];
		go_label = new JLabel[12];

		go_label[0] = new JLabel("숙소");
		go_label[0].setFont(f1);
		go_label[0].setBounds(54, 80, 70, 70);
		panel3.add(go_label[0]);
		go_button[0] = new JButton(new ImageIcon("house.png"));
		go_button[0].setBorderPainted(false);
		go_button[0].setContentAreaFilled(false);
		go_button[0].setFocusPainted(false);
		go_button[0].setBounds(32, 30, 70, 70);
		go_button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[0]);

		go_label[1] = new JLabel("호텔/모텔");
		go_label[1].setFont(f1);
		go_label[1].setBounds(127, 80, 70, 70);
		panel3.add(go_label[1]);
		go_button[1] = new JButton(new ImageIcon("hotel.png"));
		go_button[1].setBorderPainted(false);
		go_button[1].setContentAreaFilled(false);
		go_button[1].setFocusPainted(false);
		go_button[1].setBounds(122, 30, 70, 70);
		go_button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[1]);

		go_label[2] = new JLabel("예약");
		go_label[2].setFont(f1);
		go_label[2].setBounds(234, 80, 70, 70);
		panel3.add(go_label[2]);
		go_button[2] = new JButton(new ImageIcon("reservation.png"));
		go_button[2].setBorderPainted(false);
		go_button[2].setContentAreaFilled(false);
		go_button[2].setFocusPainted(false);
		go_button[2].setBounds(212, 30, 70, 70);
		go_button[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[2]);

		go_label[3] = new JLabel("차트");
		go_label[3].setFont(f1);
		go_label[3].setBounds(324, 80, 70, 70);
		panel3.add(go_label[3]);
		go_button[3] = new JButton(new ImageIcon("chart.png"));
		go_button[3].setBorderPainted(false);
		go_button[3].setContentAreaFilled(false);
		go_button[3].setFocusPainted(false);
		go_button[3].setBounds(302, 30, 70, 70);
		go_button[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[3]);

		go_button[4] = new JButton(new ImageIcon("icon.png"));
		go_button[4].setBorderPainted(false);
		go_button[4].setContentAreaFilled(false);
		go_button[4].setFocusPainted(false);
		go_button[4].setBounds(392, 30, 70, 70);
		go_button[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[4]);

		go_button[5] = new JButton(new ImageIcon("icon.png"));
		go_button[5].setBorderPainted(false);
		go_button[5].setContentAreaFilled(false);
		go_button[5].setFocusPainted(false);
		go_button[5].setBounds(482, 30, 70, 70);
		go_button[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[5]);

		go_label[6] = new JLabel("단체버스");
		go_label[6].setFont(f1);
		go_label[6].setBounds(40, 205, 70, 70);
		panel3.add(go_label[6]);
		go_button[6] = new JButton(new ImageIcon("bus.png"));
		go_button[6].setBorderPainted(false);
		go_button[6].setContentAreaFilled(false);
		go_button[6].setFocusPainted(false);
		go_button[6].setBounds(32, 150, 70, 70);
		go_button[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[6]);

		go_button[7] = new JButton(new ImageIcon("icon.png"));;
		go_button[7].setBorderPainted(false);
		go_button[7].setContentAreaFilled(false);
		go_button[7].setFocusPainted(false);
		go_button[7].setBounds(122, 150, 70, 70);
		go_button[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[7]);

		go_button[8] = new JButton(new ImageIcon("icon.png"));;
		go_button[8].setBorderPainted(false);
		go_button[8].setContentAreaFilled(false);
		go_button[8].setFocusPainted(false);
		go_button[8].setBounds(212, 150, 70, 70);
		go_button[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[8]);

		go_button[9] = new JButton(new ImageIcon("icon.png"));;
		go_button[9].setBorderPainted(false);
		go_button[9].setContentAreaFilled(false);
		go_button[9].setFocusPainted(false);
		go_button[9].setBounds(302, 150, 70, 70);
		go_button[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[9]);

		go_button[10] = new JButton(new ImageIcon("icon.png"));;
		go_button[10].setBorderPainted(false);
		go_button[10].setContentAreaFilled(false);
		go_button[10].setFocusPainted(false);
		go_button[10].setBounds(392, 150, 70, 70);
		go_button[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[10]);

		go_button[11] = new JButton(new ImageIcon("icon.png"));;
		go_button[11].setBorderPainted(false);
		go_button[11].setContentAreaFilled(false);
		go_button[11].setFocusPainted(false);
		go_button[11].setBounds(482, 150, 70, 70);
		go_button[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel3.add(go_button[11]);

		panel3.setLayout(null);
		panel3.setPreferredSize(new Dimension(600, 380));
		add(panel3, BorderLayout.SOUTH);
		
		validate();
		repaint();
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, 0));
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(0, 160, 900, 160);
		g.drawLine(0, 405, 900, 405);
	}

	public void frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 800);
		setLocationRelativeTo(null); // 창이 가운데 출력
		setResizable(false); // 프레임 size 변경 불가
		setVisible(true);
	}

	Runnable rr = () -> {
		try { 
			while (true) {
				th.sleep(5000);
				if (img_JRadio[0].isSelected() == true) {
				img_JRadio[0].setSelected(false);
				img_JRadio[1].setSelected(true);
				img_JRadio[2].setSelected(false);
				img_JRadio[3].setSelected(false);
				button_slider1.setIcon(img_slider1[1]);
				button_slider2.setIcon(img_slider2[1]);
				}
				else if (img_JRadio[1].isSelected() == true) {
				img_JRadio[0].setSelected(false);
				img_JRadio[1].setSelected(false);
				img_JRadio[2].setSelected(true);
				img_JRadio[3].setSelected(false);
				button_slider1.setIcon(img_slider1[2]);
				button_slider2.setIcon(img_slider2[2]);
				}
				else if (img_JRadio[2].isSelected() == true) {
				img_JRadio[0].setSelected(false);
				img_JRadio[1].setSelected(false);
				img_JRadio[2].setSelected(false);
				img_JRadio[3].setSelected(true);
				button_slider1.setIcon(img_slider1[3]);
				button_slider2.setIcon(img_slider2[3]);
				}
				else if (img_JRadio[3].isSelected() == true) {
				img_JRadio[0].setSelected(true);
				img_JRadio[1].setSelected(false);
				img_JRadio[2].setSelected(false);
				img_JRadio[3].setSelected(false);
				button_slider1.setIcon(img_slider1[0]);
				button_slider2.setIcon(img_slider2[0]);
				}
			}
		} catch(InterruptedException e){
		    e.printStackTrace();
		} 
	};

	public static void main(String[] args) {
		new MainPage();
	}
}
