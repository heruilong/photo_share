package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Photo;

public class PhotoDAO {

	
	public ArrayList<Photo> getPhotoByUserId(int userId){
		
		ArrayList<Photo> photos = new ArrayList<Photo>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connection = DBUtil.getConnection();
			stmt = connection.createStatement();
			String sql ="select * from photo_share.photo where user_id = '" +userId+"'";
			rs = stmt.executeQuery(sql);
			Photo photo = new Photo();
			while(rs.next()){
				photo.setPhotoId(rs.getInt("photo_id"));
				photo.setUserId(rs.getInt("user_id"));
				photo.setPhotoPath(rs.getString("photo_path"));
				photos.add(photo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
		        if (stmt != null) try { stmt.close(); } catch (SQLException logOrIgnore) {}
		        if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
		}
		return photos;	
	}
	
	public static void main(String[] args){
		PhotoDAO photoDAO = new PhotoDAO();
		photoDAO.getPhotoByUserId(1);
	}
}
