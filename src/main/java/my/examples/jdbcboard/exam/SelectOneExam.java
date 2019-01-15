package my.examples.jdbcboard.exam;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dto.Board;

import java.sql.*;

public class SelectOneExam {
    public static void main (String args[]){
        BoardDao boardDao = new BoardDaoImpl();
        Board board = boardDao.getBoard(2L);
        System.out.println(board);
    }
}
