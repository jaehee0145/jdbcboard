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

@WebServlet(name = "ModifyServlet", urlPatterns = "/board/modify")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("id");
        Long id = 0L;
        try {
            id = Long.parseLong(idStr);
        } catch (Exception ex) {
            return;
        }
        BoardDao boardDao = new BoardDaoImpl();
        Board board = boardDao.getBoard(id);
        if (board == null) {
            return;
        }
        req.setAttribute("id",id);
        req.setAttribute("board", board);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/modify.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//
//        String writer = req.getParameter("writer");
//        String title = req.getParameter("title");
//        String content = req.getParameter("content");
//
//        BoardDao boardDao = new BoardDaoImpl();
//        Board board = new Board(title, content, writer);
        Long id = 0L;
        String title = null;
        String content = null;
        try {
            String idStr = req.getParameter("id");
            title = req.getParameter("title");
            content = req.getParameter("content");

//            System.out.println(idStr);
//            System.out.println(title);
//            System.out.println(content);
            id = Long.parseLong(idStr);

        } catch (Exception ex) {
        }
        BoardDao boardDao = new BoardDaoImpl();
        boardDao.modifyBoard(id, title, content);
        resp.sendRedirect("/board/list");
    }


}
