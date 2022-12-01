import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Database {
	  
	String url = "jdbc:mysql://condors.ddns.net/mydb?serverTimezone=UTC";
	String id = "test";
	String password = "1234";
	
	Connection con = null;
	ResultSet rs = null;
	//ResultSet : 실행한 쿼리문의 값을 받는 객체
	Statement st = null;
	//Statement : 그냥 가져오는것
	PreparedStatement ps = null;
	//PreparedStatement : ?넣어서 집어넣는것
	
	Database() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");
            con = DriverManager.getConnection(url, id, password);
            System.out.println("데이터베이스 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
        }
	}
	
	public String readu_name(int u_number) {
		
		 String u_name = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 회원 where u_number = " + u_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
			u_name = rs.getString("u_name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return u_name;
	}
	
	public String readu_cash(int u_number) {
		
		 String u_cash = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 회원 where u_number = " + u_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
			u_cash = rs.getString("u_cash");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return u_cash;
	}
	
	public String readh_name(int h_number) {
		
		 String h_name = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 숙소 where h_number = " + h_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
			h_name = rs.getString("h_name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return h_name;
	}
	
	public String readh_location(int h_number) {
		
		 String h_location = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 숙소 where h_number = " + h_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				h_location = rs.getString("h_location");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return h_location;
	}
	
	public String readh_check_in(int h_number) {
		
		 String h_check_in = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 숙소 where h_number = " + h_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				h_check_in = rs.getString("h_check_in");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return h_check_in;
	}
	
	public String readh_check_out(int h_number) {
		
		 String h_check_out = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 숙소 where h_number = " + h_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				h_check_out = rs.getString("h_check_out");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return h_check_out;
	}
	
	public int readr_cost(int h_number) {
		
		 String r_cost = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 방 where h_number = " + h_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				r_cost = rs.getString("r_cost");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return Integer.parseInt(r_cost);
	}
	
	public String readr_name(int r_number) {
		
		 String r_name = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 방 where r_number = " + r_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				r_name = rs.getString("r_name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return r_name;
	}
	
	public String readr_room_number(int r_number) {
		
		 String r_room_number = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 방 where r_number = " + r_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				r_room_number = rs.getString("r_room_number");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return r_room_number;
	}
	
	public String readc_name(int h_number) {
		
		 String c_name = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 방 where h_number = " + h_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				c_name = rs.getString("c_name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return c_name;
	}
	
	public String readc_rate(String value) {
		
		 String c_rate = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 쿠폰 where c_name = " + value;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				c_rate = rs.getString("c_rate");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return c_rate;
	}
	
	public String readc_name(String value) {
		
		 String c_name = new String();
		try {

			st = con.createStatement();
			
			String sql = "select * from 쿠폰 where c_name = " + value;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				c_name = rs.getString("c_name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return c_name;
	}
	
	public ArrayList<R_Data> readR_Data(int h_number) {
		ArrayList<R_Data> arr = new ArrayList<R_Data>();
		
		try {

			st = con.createStatement();
			
			String sql = "select r_name , r_room_number, r_room_number, r_max_personnel,r_area_size, r_cost from 방 where h_number = " + h_number;
			
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				arr.add(new R_Data(rs.getString("r_name"), rs.getInt("r_room_number"), rs.getInt("r_max_personnel"), rs.getInt("r_area_size") , rs.getInt("r_cost")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return arr;
	}
	
	public ArrayList<C_Data> readC_Data(int u_number) {
		ArrayList<C_Data> arr = new ArrayList<C_Data>();
		
		try {

			st = con.createStatement();
			
			String sql = "select * from 쿠폰 join 쿠폰_보유상태 on 쿠폰.c_number = 쿠폰_보유상태.c_number and c_min_date <= sysdate() and sysdate() <= c_max_date and " + u_number;
			
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				arr.add(new C_Data(rs.getString("c_name") , rs.getInt("c_rate")));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return arr;
	}
	
	public ArrayList<R_Image> readr_imagelist(int h_number) {
		ArrayList<R_Image> arr = new ArrayList<R_Image>();
		
		try {

			st = con.createStatement();
			
			String sql = "select 방_이미지.r_image from 방 join 방_이미지 on 방.r_number = 방_이미지.r_number and h_number = " + h_number;
			
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				arr.add(new R_Image(rs.getString("r_image")));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return arr;
	}
	
	public String readr_image(int r_number) {
		String r_image = new String();
		 
		try {

			st = con.createStatement();
			
			String sql = "select * from 방_이미지 where r_number = " + r_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				r_image = rs.getString("r_image");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return r_image;
	}
	
	public String readr_count(int h_number) {
		
		 String r_count = new String();
		try {

			st = con.createStatement();
			
			String sql = "select count(*) from 방 where h_number = " + h_number;
			
			rs = st.executeQuery(sql);
			while(rs.next()) {
				r_count = rs.getString("count(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 적용 실패");
		} finally {
			dbClose();
		}
		return r_count;
	}
	
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}
}
