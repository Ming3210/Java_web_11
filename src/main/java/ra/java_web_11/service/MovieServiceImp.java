package ra.java_web_11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.java_web_11.model.Movie;
import ra.java_web_11.repository.MovieRepository;

import java.util.List;
@Service
public class MovieServiceImp implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @Override
    public void update(Movie movie) {
        movieRepository.update(movie);
    }

    @Override
    public Movie findById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        movieRepository.deleteById(id);
    }
}
