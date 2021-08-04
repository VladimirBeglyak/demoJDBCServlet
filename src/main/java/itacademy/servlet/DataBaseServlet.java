package itacademy.servlet;


import itacademy.dao.ArtistDao;
import itacademy.entity.Artist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet("/artists")
public class DataBaseServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String result = ArtistDao.getInstance().getAll()
                .stream()
                .map(artist -> wratToHtml(artist))
                .collect(Collectors.joining());

        writer.write(result);
    }

    private String wratToHtml(Artist artist) {
        return "<p>" + artist.getId() + ". " + artist.getName() + "</p>";
    }
}
