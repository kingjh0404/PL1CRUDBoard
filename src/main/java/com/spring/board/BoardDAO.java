package com.spring.board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class BoardDAO {
//
//    Connection conn = null;
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
@Autowired
JdbcTemplate jdbcTemplate;

//public void setTemplate(jdbcTemplate template){
//
//}

    private final String BOARD_INSERT = "insert into BOARD2 (title,writer,content,category,topic) values (?,?,?,?,?)";
    private final String BOARD_UPDATE = "update BOARD2 set title=?,writer=?, content=?, category, topic=? where seq=?";
    private final String BOARD_DELETE = "delete from BOARD2  where seq=?";
    private final String BOARD_GET = "select * from BOARD2  where seq=?";
    private final String BOARD_LIST = "select * from BOARD2 order by seq desc";

    public int insertBoard(BoardVO vo){
        String sql = "insert into BOARD2 (title,writer,content,category,topic) values(" + "'" + vo.getTitle() + "'," + "'" + vo.getWriter() + "'," +"'"+vo.getContent()+"',"+"'"+vo.getCategory()+"',"+"'"+vo.getTopic()+"')";
        return jdbcTemplate.update(sql);
    }

    // 글 삭제
    public int deleteBoard(int seq) {
        String sql = "delete from BOARD2 where seq = "+seq;
        return jdbcTemplate.update(sql);
    }
    public int updateBoard(BoardVO vo) {
       String sql = "update BOARD2 set title= '"+ vo.getTitle() +"',"
               +"writer='"+vo.getWriter()+"',"
               +"content='"+vo.getContent()+"',"
               +"category='"+vo.getCategory()+"',"
               +"topic='"+vo.getTopic()+"' where seq="+ vo.getSeq();
       return jdbcTemplate.update(sql);
    }


    /*
    * public int updateBoard(BoardVO vo) {
        String sql="update BOARD set title='"+vo.getTitle()+"',"
                +"writer='"+vo.getWriter()+"',"
                +"content='"+vo.getContent()+"',"
                +"category='"+vo.getCategory()+"' where seq="+vo.getSeq();
        return jdbcTemplate.update(sql);
    }
    * */

    public BoardVO getBoard(int seq) {
        String sql = "select * from BOARD2 where seq="+ seq;
        return jdbcTemplate.queryForObject(sql,new BoardRowMapper());
    }

    public List<BoardVO> getBoardList(){
        String sql= "select * from BOARD2 order by regdate desc";
        return jdbcTemplate.query(sql,new BoardRowMapper());
    }
    class BoardRowMapper implements RowMapper<BoardVO> {
        @Override
        public BoardVO mapRow(ResultSet rs, int rowNum)throws SQLException{
            BoardVO vo = new BoardVO();
            vo.setSeq(rs.getInt("seq"));
            vo.setTitle(rs.getString("title"));
            vo.setWriter(rs.getString("writer"));
            vo.setContent(rs.getString("content"));
            vo.setCategory(rs.getString("category"));
            vo.setRegdate(rs.getDate("regdate"));
            vo.setTopic(rs.getString("topic"));

            return vo;

        }
    }
}
