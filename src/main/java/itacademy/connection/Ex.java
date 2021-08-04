package itacademy.connection;

import itacademy.dao.ArtistDao;
import itacademy.entity.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex {

    public static void main(String[] args) {

        /*try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        /*ArtistDao.getInstance().getAll()
                .stream()
                .map(artist -> artist.toString())
                .forEach(s -> System.out.println(s));*/
    /*List<Artist> artistList=new ArrayList<>();

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM artists");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                artistList.add(new Artist(resultSet.getLong("id"), resultSet.getString("name")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

        String result = ArtistDao.getInstance().getAll()
                .stream()
                .map(artist -> wratToHtml(artist))
                .collect(Collectors.joining());

        System.out.println(result);
    }
    private static String wratToHtml(Artist artist) {
        return "<p>" + artist.getId() + ". " + artist.getName() + "</p>";
    }
}
