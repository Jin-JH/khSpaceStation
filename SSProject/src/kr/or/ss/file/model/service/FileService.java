package kr.or.ss.file.model.service;

import java.sql.Connection;

import kr.or.ss.common.JDBCTemplate;
import kr.or.ss.file.model.dao.FileDAO;
import kr.or.ss.file.model.vo.FileData;

public class FileService {

	public int insertFile(FileData fd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = FileDAO.insertFile(conn,fd);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
