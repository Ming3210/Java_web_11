package ra.java_web_11.repository;

import org.springframework.stereotype.Repository;
import ra.java_web_11.model.Movie;
import ra.java_web_11.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class MovieRepositoryImp implements MovieRepository{
    @Override
    public void addMovie(Movie movie) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "{call add_movie(?, ?, ?, ?, ?)}";
            callableStatement = connection.prepareCall(sql);

            callableStatement.setString(1, movie.getTitle());
            callableStatement.setString(2, movie.getDirector());
            if (movie.getReleaseDate() != null) {
                callableStatement.setDate(3, new java.sql.Date(movie.getReleaseDate().getTime()));
            } else {
                callableStatement.setNull(3, java.sql.Types.DATE);
            }
            callableStatement.setString(4, movie.getGenre());
            callableStatement.setString(5, movie.getPoster());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (callableStatement != null) {
                try { callableStatement.close(); } catch (SQLException ignored) {}
            }
            ConnectionDB.closeConnection(connection, null);
        }
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call getAllMovies()}");
            rs = cs.executeQuery();

            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                Date releaseDate = rs.getDate("releaseDate");
                if (releaseDate != null) {
                    movie.setReleaseDate(new java.util.Date(releaseDate.getTime()));
                }
                movie.setGenre(rs.getString("genre"));
                movie.setPoster(rs.getString("poster"));

                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignored) {}
            if (cs != null) try { cs.close(); } catch (SQLException ignored) {}
            ConnectionDB.closeConnection(conn, null);
        }
        return movies;
    }

    @Override
    public void update(Movie movie) {
        try (Connection conn = ConnectionDB.openConnection()) {
            CallableStatement cs = conn.prepareCall("{call update_movie(?, ?, ?, ?, ?, ?)}");
            cs.setInt(1, movie.getId());
            cs.setString(2, movie.getTitle());
            cs.setString(3, movie.getDirector());
            cs.setDate(4, new java.sql.Date(movie.getReleaseDate().getTime()));
            cs.setString(5, movie.getGenre());
            cs.setString(6, movie.getPoster());
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Movie findById(int id) {
        Movie movie = null;
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        try {
            connection = ConnectionDB.openConnection();
            String sql = "{call get_movie_by_id(?)}";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setInt(1, id);
            rs = callableStatement.executeQuery();

            if (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setReleaseDate(rs.getDate("releaseDate"));
                movie.setGenre(rs.getString("genre"));
                movie.setPoster(rs.getString("poster"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }

        return movie;
    }

    @Override
    public void deleteById(int id) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            String sql = "{CALL delete_movie(?)}";
            cstmt = conn.prepareCall(sql);
            cstmt.setInt(1, id);
            cstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
    }



}
