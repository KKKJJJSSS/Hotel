import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// FrameFormat 클래스 이름은 개인적으로 변경하여 사용하시면 됩니다.
public class PayInformation extends JFrame {
	private static final int FRAME_WIDTH = 550;
	Database database = new Database();
	int hotelnum = 2;
	int roomnum = 3;
	int usernum = 1;

	// 전체 프로그램의 너비는 600이지만 내부에서 사용하게 될 너비는
	// 이보다 더 작아야 하기 때문에 600에서 50을 낮춘 550을 사용하였습니다.
	
	public PayInformation() throws IOException {
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		
		add(new TopPanel());
		add(new CenterPanel1());
		add(new CenterPanel2());
		add(new BottomPanel1());
		add(new BottomPanel2());

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
						JTextField field = new JTextField(titleSpace + "결제 정보창", 15);
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
	
	// 다만, 개인적으로 클래스를 만드는 경우 아래 코드처럼 setPreferredSize(new Dimension(FRAME_WIDTH, 높이));
	// 함수를 통해 너비를 FRAME_WIDTH로 맞춰줘야 합니다.
	private class CenterPanel1 extends JPanel {
		public CenterPanel1() throws IOException {
			setPreferredSize(new Dimension(FRAME_WIDTH, 260));
			setLayout(new BorderLayout());
			setBorder(BorderFactory.createLineBorder(Color.black));
			JPanel LPanel = new JPanel();
			LPanel.setPreferredSize(new Dimension(150, 130));
			
			URL url = new URL(database.readr_image(roomnum));
			BufferedImage image = ImageIO.read(url);
			ImageIcon imageIcon = new ImageIcon(image);
			Image img = imageIcon.getImage();
			Image updateImg = img.getScaledInstance(140, 130, Image.SCALE_SMOOTH);
			ImageIcon updateIcon  = new ImageIcon(updateImg);
			
			JLabel imagelabel = new JLabel();
			imagelabel.setIcon(updateIcon);
			LPanel.add(imagelabel);
			
			add(LPanel, BorderLayout.WEST);
			
			JPanel RPanel = new JPanel();
			RPanel.setPreferredSize(new Dimension(350, 130));
			
			add(RPanel, BorderLayout.CENTER);
			//라벨들
			JLabel Label1 = new JLabel("호텔 이름 : " +database.readh_name(hotelnum));
			Label1.setPreferredSize(new Dimension(350,32));
			RPanel.add(Label1);
			JLabel Label2 = new JLabel("호텔 주소 : " +database.readh_location(hotelnum));
			Label2.setPreferredSize(new Dimension(350,32));
			RPanel.add(Label2);
			JLabel Label3 = new JLabel("방 이름 : " +database.readr_name(roomnum) + " " + database.readr_room_number(roomnum) + "호");
			Label3.setPreferredSize(new Dimension(350,32));
			RPanel.add(Label3);
			JLabel Label4 = new JLabel("숙박날짜 : ");
			Label4.setPreferredSize(new Dimension(350,32));
			RPanel.add(Label4);
			
			
			//체크인아웃
			JPanel LP = new JPanel(new GridLayout(2,2));
			LP.setPreferredSize(new Dimension(220,90));
			
			add(LP, BorderLayout.SOUTH);
			
			JLabel c1 = new JLabel("체크인");
			JLabel c2 = new JLabel("체크아웃");
			JLabel c3 = new JLabel(database.readh_check_in(hotelnum));
			JLabel c4 = new JLabel(database.readh_check_out(hotelnum));
			
			c1.setHorizontalAlignment(JLabel.CENTER);
			c2.setHorizontalAlignment(JLabel.CENTER);
			c3.setHorizontalAlignment(JLabel.CENTER);
			c4.setHorizontalAlignment(JLabel.CENTER);
			
			LP.add(c1);
			LP.add(c2);
			LP.add(c3);
			LP.add(c4);
			
			//결제
			
			
		}
	}
	public class CenterPanel2 extends JPanel {
		public CenterPanel2() {		
			setPreferredSize(new Dimension(FRAME_WIDTH, 180));
			
			setBorder(BorderFactory.createLineBorder(Color.black));
			
			JLabel Label1 = new JLabel(database.readu_name(usernum) + "님");
			Label1.setPreferredSize(new Dimension(520,30));
			add(Label1);
			JLabel Label2 = new JLabel("보유포인트 : " + database.readu_cash(usernum));
			Label2.setPreferredSize(new Dimension(520,30));
			add(Label2);
			JLabel Label3 = new JLabel("비용 : " + database.readr_cost(hotelnum) + "원");
			Label3.setPreferredSize(new Dimension(520,30));
			add(Label3);
			JLabel Label4 = new JLabel("할인 비율 : ");
			
			Label4.setPreferredSize(new Dimension(520,30));
			add(Label4);
			JLabel Label5 = new JLabel("총 결제 비용 : " + (int)(database.readr_cost(hotelnum) * 0.8) + "원");
			Label5.setPreferredSize(new Dimension(520,30));
			add(Label5);
			
		}
	}
	private class BottomPanel1 extends JPanel{
		public BottomPanel1() {
			CenterPanel2 dd = new CenterPanel2();
			int x = 2;
			int r;
			setPreferredSize(new Dimension(360, 180));
			setBorder(new TitledBorder(new LineBorder(Color.black), "사용 가능 쿠폰"));
			
			JLabel coponlabel = new JLabel("현재 선택한 쿠폰");
			coponlabel.setPreferredSize(new Dimension(100,30));
			add(coponlabel);
			
			JTextField coponText = new JTextField("쿠폰");
			coponText.setPreferredSize(new Dimension(230,30));
			coponText.setEditable(false);
			add(coponText);
			// 스크롤
			JPanel scroll = new JPanel(new GridLayout(0,1));
			JScrollPane scrollPane = new JScrollPane(scroll , JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			scrollPane.setPreferredSize(new Dimension(340,100));
			add(scrollPane);
			
			
			
			JButton roomBut[] = new JButton[x];
			JPanel coponPanel[] = new JPanel[x];
			
			ArrayList<C_Data> arr1 = new ArrayList<C_Data>();
			arr1 = database.readC_Data(usernum);
			
			for (r = 0; r < x; r++) {
				coponPanel[r] = new JPanel();
				scroll.add(coponPanel[r]);
				
				roomBut[r] = new JButton(arr1.get(r).getC_name());
				roomBut[r].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = e.getActionCommand();
						coponText.setText(value);
						}
					});
				coponPanel[r].add(roomBut[r]);
				roomBut[r].setPreferredSize(new Dimension(330,30));
			}
		}
		
	}
	private class BottomPanel2 extends JPanel {
		public BottomPanel2() {
			setPreferredSize(new Dimension(170, 180));
			
			JButton butbut1 = new JButton("결제하기");
			butbut1.setPreferredSize(new Dimension(150,85));
			add(butbut1);
			
			JButton butbut2 = new JButton("취소하기");
			butbut2.setPreferredSize(new Dimension(150,85));
			add(butbut2);
			
		}
	}
	public static void main(String[] args) throws IOException {
		new PayInformation();
	}
}