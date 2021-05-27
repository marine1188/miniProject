package board.impl;

import org.apache.ibatis.session.SqlSession;

import board.BoardVO;
import session.SqlSessionFactoryBean;

public class BoardDAO {
	
	private SqlSession mybatis;
	
	public BoardDAO() {
		
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
		System.out.println(mybatis.toString());
	}
	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);
		mybatis.commit();
		System.out.println("insert 성공!!");
	}
	
	
}















