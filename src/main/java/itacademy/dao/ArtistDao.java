package itacademy.dao;

import itacademy.connection.ConnectionManager;
import itacademy.entity.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ArtistDao {

    public static ArtistDao INSTANCE;
    private ArtistDao (){}

    public Set<Artist> getAll(){
        Set<Artist> artists=new HashSet<>();
        try (Connection connection = ConnectionManager.newConnection()) {
            String sql = "SELECT * FROM artists";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                artists.add(new Artist(resultSet.getLong("id"),resultSet.getString("name")));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artists;
    }


    public static ArtistDao getInstance(){
        if (INSTANCE==null){
            synchronized (ArtistDao.class){
                if (INSTANCE==null){
                    INSTANCE=new ArtistDao();
                }
            }
        }
        return INSTANCE;
    }
}
