import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

// FrameFormat 클래스 이름은 개인적으로 변경하여 사용하시면 됩니다.
public class Search extends JFrame {
	private static final int FRAME_WIDTH = 550;
	// 전체 프로그램의 너비는 600이지만 내부에서 사용하게 될 너비는
	// 이보다 더 작아야 하기 때문에 600에서 50을 낮춘 550을 사용하였습니다.

	public Search() throws IOException {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		add(new TopPanel());
		add(new Display());

		setTitle("영진숙소 예약 프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 800);
		setResizable(false);
		setVisible(true);
	}

	private class TopPanel extends JPanel {
		public TopPanel() {
			setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
			{
				JPanel frame = new JPanel(new BorderLayout(20, 0));
				{
					JPanel panel = new JPanel(new GridLayout(1, 2, 20, 0));
					panel.setPreferredSize(new Dimension(100, 40));
					Font font = new Font("Monospaced", Font.BOLD, 10);
					{
						JButton button = new JButton("<");
						button.setFont(font);
						panel.add(button);
					}
					{
						JButton button = new JButton("H");
						button.setFont(font);
						panel.add(button);
					}
					frame.add(panel, BorderLayout.WEST);
				}
				{
					JPanel panel = new JPanel(new BorderLayout());
					{
						String titleSpace = "  ";
						JTextField field = new JTextField(titleSpace + "숙소 리스트", 15);
						field.setFont(new Font("굴림", Font.BOLD, 15));
						field.setEditable(false);
						field.setBorder(BorderFactory.createLineBorder(Color.GRAY));
						field.setBackground(Color.WHITE);
						panel.add(field);
					}
					frame.add(panel, BorderLayout.CENTER);
				}
				add(frame);
			}
			setPreferredSize(new Dimension(FRAME_WIDTH, 42));
			setFocusable(true);
			requestFocus();

		}
	}

	private class Display extends JPanel {
		JTextField date1, date2, people1, cost1, cost2, house_name;
		JLabel Lb_date, Lb_people1, Lb_people2, Lb_cost, Lb_house_name, cost3;
		JButton Bt_search, Bt_reset;
		JPanel panel2;
		BufferedImage image;
		URL url;

		int cnt3 = 0;
		int x = 15;
		int a;
		int h_number = 0;

		public Display() throws IOException {
			setPreferredSize(new Dimension(FRAME_WIDTH, 660));
			setLayout(null);

			panel2 = new JPanel();
			panel2.setBounds(0, 0, 550, 250);
			panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			panel2.setLayout(null);

			Lb_house_name = new JLabel("숙소명");
			Lb_house_name.setBounds(64, 35, 50, 20);
			Lb_house_name.setFont(new Font("굴림", Font.BOLD, 15));
			panel2.add(Lb_house_name);
			house_name = new JTextField();
			house_name.setBounds(140, 28, 250, 33);
			panel2.add(house_name);

			Lb_people1 = new JLabel("방크기");
			Lb_people1.setBounds(64, 91, 50, 20);
			Lb_people1.setFont(new Font("굴림", Font.BOLD, 15));
			Lb_people2 = new JLabel("(2/4/6 인실)");
			Lb_people2.setBounds(220, 91, 90, 20);
			Lb_people2.setFont(new Font("굴림", Font.BOLD, 12));
			panel2.add(Lb_people1);
			panel2.add(Lb_people2);
			people1 = new JTextField();
			people1.setBounds(140, 85, 70, 33);
			panel2.add(people1);

			Lb_cost = new JLabel("비용");
			Lb_cost.setBounds(70, 149, 50, 20);
			Lb_cost.setFont(new Font("굴림", Font.BOLD, 15));
			panel2.add(Lb_cost);
			cost1 = new JTextField();
			cost1.setBounds(140, 142, 100, 33);
			panel2.add(cost1);
			cost2 = new JTextField();
			cost2.setBounds(290, 142, 100, 33);
			panel2.add(cost2);
			cost3 = new JLabel("(원)");
			cost3.setBounds(400, 147, 30, 20);
			cost3.setFont(new Font("굴림", Font.BOLD, 12));
			panel2.add(cost3);

			Bt_search = new JButton("검색");
			Bt_search.setBounds(380, 200, 70, 40);
			Bt_search.setFont(new Font("Monospaced", Font.BOLD, 10));
			panel2.add(Bt_search);

			Bt_reset = new JButton("초기화");
			Bt_reset.setBounds(467, 200, 70, 40);
			Bt_reset.setFont(new Font("Monospaced", Font.BOLD, 10));
			panel2.add(Bt_reset);

			add(panel2);

			JPanel botpanel1 = new JPanel(new GridLayout(x, 1, 0, 10));

			JScrollPane scrollPane = new JScrollPane(botpanel1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(0, 270, 550, 390);
			scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			scrollPane.getVerticalScrollBar().setUnitIncrement(9);

			JPanel RoomPanel[] = new JPanel[x];
			JPanel RoomLeftPanel[] = new JPanel[x];
			JLabel Roomimg[] = new JLabel[x];

			JPanel RoomMidPanel[] = new JPanel[x];
			JLabel Roomname[] = new JLabel[x];
			JLabel Roomarea[] = new JLabel[x];
			JLabel Roomfurniture[] = new JLabel[x];

			JPanel RoomRightPanel[] = new JPanel[x];
			JButton Roombut[] = new JButton[x];

			for (a = 0; a < x; a++) {
				RoomPanel[a] = new JPanel(new BorderLayout(10, 0));
				RoomPanel[a].setPreferredSize(new Dimension(550, 120));
				botpanel1.add(RoomPanel[a]);
				// 패널 왼쪽
				RoomLeftPanel[a] = new JPanel();
				RoomPanel[a].add(RoomLeftPanel[a], BorderLayout.WEST);
				Roomimg[a] = new JLabel();
				Roomimg[a].setPreferredSize(new Dimension(120, 120));
				RoomLeftPanel[a].add(Roomimg[a]);

				// 패널 중앙
				RoomMidPanel[a] = new JPanel(new GridLayout(4, 1));
				RoomPanel[a].add(RoomMidPanel[a], BorderLayout.CENTER);
				Roomname[a] = new JLabel("숙소 이름");
				RoomMidPanel[a].add(Roomname[a]);
				Roomarea[a] = new JLabel("몇 인실");
				RoomMidPanel[a].add(Roomarea[a]);
				Roomfurniture[a] = new JLabel("min ~ max");
				RoomMidPanel[a].add(Roomfurniture[a]);

				// 패널 오른쪽
				RoomRightPanel[a] = new JPanel(new BorderLayout());
				RoomPanel[a].add(RoomRightPanel[a], BorderLayout.EAST);
				Roombut[a] = new JButton("상세보기");
				Roombut[a].setPreferredSize(new Dimension(100, 40));
				RoomRightPanel[a].add(Roombut[a], BorderLayout.SOUTH);

			}

			SearchDAO dao = new SearchDAO();
			int cnt = 0;
			int r_people = 0;
			int r_people1 = 0;
			int r_cost = 0;
			int r_cost1 = 0;
			int cnt1 = 0;
			int cnt2 = 0;
			String h_name = new String();

			ArrayList<SearchVO> people = dao.people(r_people, r_people1);
			for (SearchVO vo : people) {
				int data = vo.getR_people();
				int data1 = vo.getR_people1();
				if (data == data1) {
					Roomarea[cnt].setText(data + " 인실");
				} else {
					Roomarea[cnt].setText(data1 + "인실 / " + data + "인실");
					cnt++;
				}
			}
			ArrayList<SearchVO> cost = dao.cost(r_cost, r_cost1);
			for (SearchVO vo : cost) {
				int max = vo.getR_cost();
				int min = vo.getR_cost1();
				Roomfurniture[cnt1].setText(min + "원 ~ " + max + "원");
				cnt1++;
			}
			ArrayList<SearchVO> name = dao.name(h_name);
			for (SearchVO vo : name) {
				String data = vo.getH_name();
				String img = vo.getH_image();
				url = new URL(img);
				image = ImageIO.read(url);
				ImageIcon imageIcon = new ImageIcon(image);
				Image i_img = imageIcon.getImage();
				Image updateImg = i_img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
				ImageIcon updateIcon = new ImageIcon(updateImg);

				Roomimg[cnt2].setIcon(updateIcon);
				Roomname[cnt2].setText(data + "");
				cnt2++;
			}

			add(scrollPane);

			Bt_search.addActionListener(new ActionListener() {
				BufferedImage image;
				URL url;
				ImageIcon imageIcon, updateIcon;

				public void actionPerformed(ActionEvent e) {
					botpanel1.removeAll();
					if (e.getSource() == Bt_search) {
						String h_image = new String();
						String h_name = house_name.getText();
						String m_r_people = people1.getText();
						String min = cost1.getText();
						String max = cost2.getText();
						if (m_r_people.length() < 1 || min.length() < 1 || max.length() < 1)// 입력이 안된 경우
						{
							JOptionPane.showMessageDialog(null, "조건을 입력하세요.", " ", JOptionPane.WARNING_MESSAGE);
							return;
							// 처리
						}

						int r_people = Integer.parseInt(m_r_people);
						int r_cost = Integer.parseInt(min);
						int r_cost1 = Integer.parseInt(max);
						SearchDAO dao = new SearchDAO();
						ArrayList<SearchVO> s_name = dao.s_name(h_name, h_image, r_people, r_cost, h_number);
						for (SearchVO vo : s_name) {
							String data = vo.getH_name();
							String img = vo.getH_image();

							try {
								url = new URL(img);
								image = ImageIO.read(url);
								imageIcon = new ImageIcon(image);
								Image i_img = imageIcon.getImage();
								Image updateImg = i_img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
								updateIcon = new ImageIcon(updateImg);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							int data1 = vo.getR_people();
							int data2 = vo.getR_cost();
							int data3 = vo.getR_cost1();

							botpanel1.add(RoomPanel[cnt3]);

							Roomimg[cnt3].setIcon(updateIcon);

							Roomname[cnt3].setText(data + "");
							if (data2 < r_cost && r_cost <= data3) {
								Roomfurniture[cnt3].setText(data2 + "원");
							} else if (r_cost1 < data3 && data2 <= r_cost1) {
								Roomfurniture[cnt3].setText(data2 + "원");
							} else if (r_cost <= data2 && data3 <= r_cost1) {
								Roomfurniture[cnt3].setText(data2 + "원");
							} else {
								botpanel1.removeAll();
							}

							Roomarea[cnt3].setText(data1 + " 인실");
							cnt3++;
						}
						scrollPane.revalidate();
						scrollPane.repaint();
					}
				}
			});

			Bt_reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == Bt_reset) {
						botpanel1.removeAll();
						botpanel1.revalidate();
						date1.setText("");
						date2.setText("");
						people1.setText("");
						cost1.setText("");
						cost2.setText("");
						house_name.setText("");
						for (a = 0; a < x; a++) {
							botpanel1.add(RoomPanel[a]);
						}
						scrollPane.revalidate();
						scrollPane.repaint();
					}

				}
			});

			for (a = 0; a < x; a++) {
				Roombut[a].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							String h_image = new String();
							String h_name = house_name.getText();
							String m_r_people = people1.getText();
							String min = cost1.getText();
							String max = cost2.getText();
							int r_people = Integer.parseInt(m_r_people);
							int r_cost = Integer.parseInt(min);
							int r_cost1 = Integer.parseInt(max);
							SearchDAO dao = new SearchDAO();
							ArrayList<SearchVO> s_name = dao.s_name(h_name, h_image, r_people, r_cost, h_number);
							for (SearchVO vo : s_name) {
								int data = vo.getH_number();
								System.out.println(data);
							}
						}
						
				});
			}

		}

		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, 0));
			g.drawLine(255, 157, 275, 157);

		}

	}

	public static void main(String[] args) throws IOException {
		new Search();

	}

}
