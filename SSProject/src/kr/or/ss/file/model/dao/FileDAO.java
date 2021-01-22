package kr.or.ss.file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.ss.common.JDBCTemplate;
import kr.or.ss.file.model.vo.FileData;

public class FileDAO {

	public static int insertFile(Connection conn, FileData fd) {
		PreparedStatement pstmt =null;
		int result =0;
		String query = "INSERT INTO FILETBL VALUES(FILE_SEQ.NEXTVAL,?,?,?,?,?,?,'N')";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fd.getOriginalFileName());
			pstmt.setString(2, fd.getChangedFileName());
			pstmt.setString(3, fd.getFilePath());
			pstmt.setLong(4, fd.getFileSize());
			pstmt.setString(5, fd.getFileUser());
			pstmt.setTimestamp(6, fd.getUploadTime());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
