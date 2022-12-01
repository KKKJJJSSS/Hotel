import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class SearchDAO {
	private Connection conn;
	// 문장 전송 => SQL
	private PreparedStatement ps;
	// 연결 => 주소
	private final String URL = "jdbc:mysql://condors.ddns.net/mydb?serverTimezone=UTC";
	// 드라이버 등록
	ImageIcon imageIcon;
	Image image;
	public SearchDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "test", "1234");
			//System.out.println("-------------");
		} catch (Exception ex) {
		}
	}

	// 닫기
	public void disConnection() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
			// exit
		} catch (Exception ex) {
		}
	}
	
	public ArrayList<SearchVO> people(int r_people, int r_people1) {
		ArrayList<SearchVO> people = new ArrayList<SearchVO>();
		try {
			// 연결
			getConnection();

			String sql = "SELECT h_number, max(r_max_personnel), min(r_max_personnel) from 방 group by h_number";

			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();// 실행
			while (rs.next()) {
				SearchVO vo = new SearchVO();
				vo.setR_people(rs.getInt(2));
				vo.setR_people1(rs.getInt(3));
				people.add(vo);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return people;
	}
	
	public ArrayList<SearchVO> cost(int r_cost, int r_cost1) {
		ArrayList<SearchVO> cost = new ArrayList<SearchVO>();
		try {
			// 연결
			getConnection();

			String sql = "SELECT h_number, max(r_cost), min(r_cost) from 방 group by h_number";

			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();// 실행
			while (rs.next()) {
				SearchVO vo = new SearchVO();
				vo.setR_cost(rs.getInt(2));
				vo.setR_cost1(rs.getInt(3));
				cost.add(vo);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return cost;
	}
	
	public ArrayList<SearchVO> name(String h_name) {
		ArrayList<SearchVO> name = new ArrayList<SearchVO>();
		try {
			// 연결
			getConnection();

			String sql = "select h_name, h_image from 숙소 group by h_name";

			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();// 실행
			while (rs.next()) {
				SearchVO vo = new SearchVO();
				vo.setH_name(rs.getString(1));
				vo.setH_image(rs.getString(2));
				name.add(vo);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return name;
	}
	
	public ArrayList<SearchVO> s_name(String h_name, String h_image, int r_people, int r_cost, int h_number) {
		ArrayList<SearchVO> s_name = new ArrayList<SearchVO>();
		try {
			// 연결
			getConnection();

			String sql = "select distinct\r\n"
					+ "	s.h_number,\r\n"
					+ "	s.h_name,\r\n"
					+ "	c.r_max_personnel,\r\n"
					+ "	c.r_cost,\r\n"
					+ "    s.h_image\r\n"
					+ "	from 숙소 As s\r\n"
					+ "	inner JOIN 방 AS c\r\n"
					+ "		ON (c.h_number = s.h_number)\r\n"
					+ "	WHERE s.h_name LIKE concat('%', ?, '%')\r\n"
					+ "    and c.r_max_personnel LIKE concat('%', ?, '%')\r\n";
					
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + h_name + "%");
			ps.setString(2, "%" + r_people + "%");
			ResultSet rs = ps.executeQuery();// 실행
			while (rs.next()) {
				SearchVO vo = new SearchVO();
				vo.setH_number(rs.getInt(1));
				vo.setH_name(rs.getString(2));
				vo.setR_people(rs.getInt(3));
				vo.setR_cost(rs.getInt(4));
				vo.setR_cost1(rs.getInt(4));
				vo.setH_image(rs.getString(5));
				s_name.add(vo);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return s_name;
	}

}
