package fasttrackit.course20homework.service;

import fasttrackit.course20homework.model.Movie;
import fasttrackit.course20homework.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getAll() {
        return repository.findAll();
    }

    public Movie getByName(String requestedName) {
        return repository.findAll()
                .stream()
                .filter(movie -> movie.getName().equals(requestedName))
                .findFirst()
                .orElse(null);
    }

    public void addAll(List<Movie> movies) {
        repository.saveAll(movies);
    }

}
