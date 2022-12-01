import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

// FrameFormat 클래스 이름은 개인적으로 변경하여 사용하시면 됩니다.
public class Roominformation extends JFrame {
	private static final int FRAME_WIDTH = 550;
	// 전체 프로그램의 너비는 600이지만 내부에서 사용하게 될 너비는
	// 이보다 더 작아야 하기 때문에 600에서 50을 낮춘 550을 사용하였습니다.
	Database database = new Database();
	int hotelnum = 2;
	public Roominformation() throws IOException {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		add(new TopPanel());
		add(new CenterPanel());
		add(new BottomPanel());
		
		
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
						JTextField field = new JTextField(titleSpace + "방 상세정보", 15);
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
			
			
			// 위 setBorder 구문은 디버깅용입니다. 불필요하면 주석 처리 하시거나 구문을 삭제하시면 됩니다.
		}
	}
	// 아래 CenterPanel과 BottomPanel 클래스들은 샘플로 만들어둔 클래스입니다. 불필요하면 삭제하시면 됩니다.
	// 다만, 개인적으로 클래스를 만드는 경우 아래 코드처럼 setPreferredSize(new Dimension(FRAME_WIDTH, 높이));
	// 함수를 통해 너비를 FRAME_WIDTH로 맞춰줘야 합니다.
	private class CenterPanel extends JPanel {
		public CenterPanel() {
			
			setPreferredSize(new Dimension(FRAME_WIDTH, 320));
			setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			
			// 위 setBorder 구문은 디버깅용입니다. 불필요하면 주석 처리 하시거나 구문을 삭제하시면 됩니다.
			Font font = new Font("Monospaced", Font.BOLD, 15);
			
			
			//centerpane1는 슬라이더 패널
			JPanel centerpanel1 = new JPanel(new BorderLayout(0,0));
			centerpanel1.setPreferredSize(new Dimension(530, 160));
			
			//왼쪽 버튼
			JPanel LeftButPanel = new JPanel();
			centerpanel1.add(LeftButPanel, BorderLayout.WEST);
			LeftButPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 60));
			JButton leftbut = new JButton("<");
			leftbut.setPreferredSize(new Dimension(20, 40));
			leftbut.setFont(font);
			LeftButPanel.add(leftbut);
			
			//중앙 그림 페이지
			JPanel ImgPanel = new JPanel();
			centerpanel1.add(ImgPanel, BorderLayout.CENTER);
			
			//오른쪽 버튼
			JPanel RightButPanel = new JPanel();
			RightButPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 60));

			centerpanel1.add(RightButPanel, BorderLayout.EAST);
			JButton rightbut = new JButton(">");
			rightbut.setFont(font);
			rightbut.setPreferredSize(new Dimension(20, 40));
			RightButPanel.add(rightbut);
			
			add(centerpanel1);
			
			
			
			//centerpane2는 정보 패널 (슬라이더 아래패널)
			JPanel centerpanel2 = new JPanel(new GridLayout(2,1,0,0));
			centerpanel2.setPreferredSize(new Dimension(530,140));
			
			add(centerpanel2);
			// 호텔정보
			JPanel centersub1 = new JPanel(new GridLayout(2,1,0,15));
			centerpanel2.add(centersub1);
			
			
			
			
			JLabel centerlabel1 = new JLabel(database.readh_name(hotelnum));
			centerlabel1.setFont(new Font("굴림", Font.BOLD, 18));
			centersub1.add(centerlabel1);
			
			JLabel centerlabel2 = new JLabel("주소 : " + database.readh_location(hotelnum));
			centerlabel2.setFont(new Font("굴림", Font.BOLD, 15));
			centersub1.add(centerlabel2);
			
			// 체크인아웃 정보
			JPanel centersub2 = new JPanel(new FlowLayout());
			centersub2.setPreferredSize(new Dimension(FRAME_WIDTH,80));
			centerpanel2.add(centersub2);
			
			JPanel checkinoutPanel = new JPanel(new GridLayout(2,2));
			checkinoutPanel.setPreferredSize(new Dimension(530,60)); 
			centersub2.add(checkinoutPanel);
			
			JLabel c1 = new JLabel(" 체크인 ");
			JLabel c2 = new JLabel(" 체크아웃 ");
			JLabel c3 = new JLabel(database.readh_check_in(hotelnum));
			JLabel c4 = new JLabel(database.readh_check_out(hotelnum));
			
			c1.setHorizontalAlignment(JLabel.CENTER);
			c2.setHorizontalAlignment(JLabel.CENTER);
			c3.setHorizontalAlignment(JLabel.CENTER);
			c4.setHorizontalAlignment(JLabel.CENTER);
			
			checkinoutPanel.add(c1);
			checkinoutPanel.add(c2);
			checkinoutPanel.add(c3);
			checkinoutPanel.add(c4);
			checkinoutPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			
			setLayout(new FlowLayout(FlowLayout.CENTER));
			requestFocus();
			setFocusable(true);
		}
	}
	private class BottomPanel extends JPanel {
		int x = Integer.parseInt(database.readr_count(hotelnum));
		public BottomPanel() throws IOException {
			setPreferredSize(new Dimension(FRAME_WIDTH, 320));
			
			
			// 위 setBorder 구문은 디버깅용입니다. 불필요하면 주석 처리 하시거나 구문을 삭제하시면 됩니다.
			JPanel botpanel1 = new JPanel(new GridLayout(x,1,0,10));
			
			
			
			JScrollPane scrollPane = new JScrollPane(botpanel1 , JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setPreferredSize(new Dimension(550, 320));
			
			JPanel RoomPanel[] = new JPanel[x];
			JPanel RoomLeftPanel[] = new JPanel[x];
			ImageIcon Ri[] = new ImageIcon[x];
			JLabel Roomimg[] = new JLabel[x];
			
			JPanel RoomMidPanel[] = new JPanel[x];
			JLabel Roomname[] = new JLabel[x];
			JLabel Roomarea[] = new JLabel[x];
			JLabel Roomcost[] = new JLabel[x];
			JLabel Roommaxpeo[] = new JLabel[x];
			
			JPanel RoomRightPanel[] = new JPanel[x];
			JButton Roombut[] = new JButton[x];
			
			ArrayList<R_Data> arr = new ArrayList<R_Data>();
			arr = database.readR_Data(hotelnum);
			ArrayList<R_Image> art = new ArrayList<R_Image>();
			art = database.readr_imagelist(hotelnum);
			
			
			
			for (int a = 0 ; a < x ; a++) {
				RoomPanel[a] = new JPanel(new BorderLayout(10,0));
				RoomPanel[a].setPreferredSize(new Dimension(550,120));
				botpanel1.add(RoomPanel[a]);
				
				// 패널 왼쪽
				RoomLeftPanel[a] = new JPanel();
				RoomPanel[a].add(RoomLeftPanel[a], BorderLayout.WEST);
				
				URL url = new URL(art.get(a).getR_image());
				BufferedImage image = ImageIO.read(url);
				
				ImageIcon imageIcon = new ImageIcon(image);
				Image img = imageIcon.getImage();
				Image updateImg = img.getScaledInstance(140, 130, Image.SCALE_SMOOTH);
				Ri[a] = new ImageIcon(updateImg);
				
				Roomimg[a] = new JLabel(Ri[a]);
				Roomimg[a].setPreferredSize(new Dimension(120, 120));
				RoomLeftPanel[a].add(Roomimg[a]);
				
				
				// 패널 중앙
				RoomMidPanel[a] = new JPanel(new GridLayout(4,1));
				RoomPanel[a].add(RoomMidPanel[a], BorderLayout.CENTER);
				
				
				
				Roomname[a] = new JLabel("" + arr.get(a).getR_name());
				RoomMidPanel[a].add(Roomname[a]);
				
				Roomarea[a] = new JLabel("방 면적 : " + arr.get(a).getR_area_size());
				RoomMidPanel[a].add(Roomarea[a]);
				
				Roommaxpeo[a] = new JLabel("최대 인원 : " +arr.get(a).getR_max_personnel());
				RoomMidPanel[a].add(Roommaxpeo[a]);
				
				Roomcost[a] = new JLabel("가격 : " + arr.get(a).getR_cost());
				RoomMidPanel[a].add(Roomcost[a]);
				
				
				
				//패널 오른쪽
				RoomRightPanel[a] = new JPanel(new BorderLayout());
				RoomPanel[a].add(RoomRightPanel[a] , BorderLayout.EAST);
				Roombut[a] = new JButton("예약하기");
				Roombut[a].setPreferredSize(new Dimension(100,40));
				RoomRightPanel[a].add(Roombut[a], BorderLayout.SOUTH);
				
				
				
			}
		
			
			add(scrollPane);
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException{
		
		new Roominformation();
	}
}