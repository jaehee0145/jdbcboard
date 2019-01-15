package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardDaoImpl implements BoardDao {
    @Override
    public Board getBoard(Long idParam) {
        Board board = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //a. DB연결 - connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            conn = DBUtil.getInstance().getConnection();

            //b. select SQL 준비
            String sql = "select id, title, content, writer, regdate, read_count from board where id =?";
            ps = conn.prepareStatement(sql);

            //c. 바인딩
            ps.setLong(1, idParam);

            // d. SQL 실행
            rs = ps.executeQuery();

            if (rs.next()) {
                long id = rs.getLong(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                String writer = rs.getString(4);
                Date regdate = rs.getDate(5);
                int readCount = rs.getInt(6);

                board = new Board(id, title, content, writer, regdate, readCount);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(rs, ps, conn);
        }

        return board;
    }

    @Override
    public List<Board> getBoards(int start, int limit) {
        List<Board> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password
            conn = DBUtil.getInstance().getConnection();
            if (conn != null) {
                System.out.println("conn ok!");
                System.out.println(conn.getClass().getName());
            }
            // b. SELECT SQL 준비 - Connection
            String sql = "SELECT id, title, content, writer, regdate, read_count FROM board ORDER BY id DESC LIMIT ?, ?";
            ps = conn.prepareStatement(sql);
            // c. 바인딩 - PreparedStatement
            ps.setLong(1, start); // 첫번째 물음표에 5를 바인딩한다.
            ps.setInt(2, limit);

            // d. SQL 실행 - PreparedStatement
            rs = ps.executeQuery(); // SELECT 문장을 실행, executeUpdate() - insert, update, delete

            // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
            // f. e에서 읽어오지 못하는 경우도 있다.
            while (rs.next()) {
                long id = rs.getLong(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                String writer = rs.getString(4);
                Date regdate = rs.getDate(5);
                int readCount = rs.getInt(6);

                Board board = new Board(id, title, content, writer, regdate, readCount);
                list.add(board);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // g. ResultSet, PreparedStatement, Connection 순으로 close를 한다.
            DBUtil.close(rs, ps, conn);
        }
        return list;
    }

    @Override
    public void addBoard(Board board) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "INSERT INTO board(title, writer, content) VALUES(?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, board.getTitle());
            ps.setString(2, board.getWriter());
            ps.setString(3, board.getContent());
            ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(ps, conn);
        }
    }

    @Override
    public void deleteBoard(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "DELETE FROM board WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(ps, conn);
        }
    }

    @Override
    public void modifyBoard(Long id,String title, String content) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "update board set title=?, content=? where id =?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2,content);
            ps.setLong(3, id);
            ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(ps, conn);
        }
    }

    @Override
    public void updateReadCount(long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "UPDATE board SET read_count = read_count + 1 WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(ps, conn);
        }
    }
}
