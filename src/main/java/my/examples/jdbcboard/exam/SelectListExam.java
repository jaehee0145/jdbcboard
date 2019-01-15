package my.examples.jdbcboard.exam;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SelectListExam {
    public static void main(String args[]) {

        BoardDao boardDao = new BoardDaoImpl();
        List<Board> boards = boardDao.getBoards(0, 3);
        for(Board board : boards){
            System.out.println(board);
        }
    }
}
