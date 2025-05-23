package ra.java_web_11.service;

import ra.java_web_11.model.Movie;

import java.util.List;

public interface MovieService {
    void addMovie(Movie movie);
    List<Movie> getAllMovies();
    void update(Movie movie);
    Movie findById(int id);
    void deleteById(int id);
}
