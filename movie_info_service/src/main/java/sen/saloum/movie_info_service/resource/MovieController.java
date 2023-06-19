package sen.saloum.movie_info_service.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sen.saloum.movie_info_service.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @RequestMapping("/{movieId}")
    public Movie getMoviesInfo(@PathVariable("movieId") String movieId){
        return new Movie(movieId, "the dog");
    }

}
