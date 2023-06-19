package sen.saloum.moviecatalogservice.ressources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sen.saloum.moviecatalogservice.model.CatologItems;
import sen.saloum.moviecatalogservice.model.Movie;
import sen.saloum.moviecatalogservice.model.Rating;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatologItems> getCatalogs(@PathVariable("userId") String userId){

        WebClient.Builder

        RestTemplate restTemplate = new RestTemplate();
        List<Rating> ratings = Arrays.asList(
                new Rating("121",2),
                new Rating("422",3)
        );

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:2100/movies/424"+ rating.getRatingId(),Movie.class);
          return  new CatologItems(movie.getName(), "black cat", rating.getRating());
        }).collect(Collectors.toList());
    }
}
