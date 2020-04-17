package kovalalex.movies.controller;

import kovalalex.movies.domain.Folder;
import kovalalex.movies.domain.Movie;
import kovalalex.movies.repository.FolderRepository;
import kovalalex.movies.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private final MovieRepository movieRepository;
    private final FolderRepository folderRepository;
    @Autowired
    public MovieController(MovieRepository movieRepository, FolderRepository folderRepository) {
        this.movieRepository = movieRepository;
        this.folderRepository = folderRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        logger.info("Movie in JSON is", movie.toString());
        movieRepository.save(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMoviesById(@PathVariable Integer movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        logger.info(movieId.toString());
        if (movie.isPresent())
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
    @GetMapping
    public List<Movie> all() {

        return movieRepository.findAll();
    }

}
