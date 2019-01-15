package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dto.Board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListServlet", urlPatterns = "/board/list")
public class ListServlet extends HttpServlet {
    private static final int SIZE = 5; // 설정 파일에서 읽어들이도록 수정해야 한다.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String pageStr = req.getParameter("page");
    int page = 1;
    try{
        page = Integer.parseInt(pageStr);
    }
    catch(Exception ignore){}

    int start = page *SIZE -SIZE;
    int limit = SIZE;

        BoardDao boardDao = new BoardDaoImpl();
        List<Board> boards = boardDao.getBoards(start,limit);

        req.setAttribute("boards", boards);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/list.jsp");
        requestDispatcher.forward(req, resp);


    }
}
