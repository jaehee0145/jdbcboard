package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dto.Board;

import java.util.List;

public interface BoardService {

    public Board getBoard(Long id);

    public List<Board> getBoards(int page);

    public void deleteBoard(Long id);

    public void modifyBoard(Long id, String title, String content);

    public void addBoard(Board board);
}
