package fasttrackit.course20homework;

import fasttrackit.course20homework.model.*;
import fasttrackit.course20homework.service.MovieService;
import fasttrackit.course20homework.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandRunner implements CommandLineRunner {

    private final MovieService movieService;
    private final ReviewService reviewService;

    @Override
    public void run(String... args) throws Exception {

        log.info("Runner is populating with data");

        Studio studioOne = Studio.builder()
                .name("Studio One")
                .address("Romania")
                .build();
        Studio studioTwo = Studio.builder()
                .name("Studio Two")
                .address("Italy")
                .build();

        Actor actorOne = Actor.builder()
                .name("Ileana")
                .birthYear(1960)
                .build();
        Actor actorTwo = Actor.builder()
                .name("Costel")
                .birthYear(1962)
                .build();
        Actor actorThree = Actor.builder()
                .name("Mihai")
                .birthYear(1970)
                .build();

        List<Actor> movieOneActors = List.of(actorOne, actorTwo);
        List<Actor> movieTwoActors = List.of(actorOne, actorTwo, actorThree);

        movieService.addAll(
                List.of(
                        Movie.builder()
                                .name("Movie 1")
                                .movieYear(2001)
                                .rating(MovieRating.builder()
                                        .agency("Agency One")
                                        .rating(7)
                                        .build())
                                .studio(studioOne)
                                .actors(movieOneActors)
                                .build(),
                        Movie.builder()
                                .name("Movie 2")
                                .movieYear(2002)
                                .rating(MovieRating.builder()
                                        .agency("Agency Two")
                                        .rating(8)
                                        .build())
                                .studio(studioOne)
                                .actors(movieTwoActors)
                                .build(),
                        Movie.builder()
                                .name("Another Movie")
                                .movieYear(2004)
                                .rating(MovieRating.builder()
                                        .agency("Agency Three")
                                        .rating(5)
                                        .build())
                                .studio(studioTwo)
                                .actors(movieTwoActors)
                                .build()
                )
        );

        reviewService.addAll(
                List.of(
                        Review.builder()
                                .reviewer("Ion Tiriac")
                                .text("Good")
                                .movie(movieService.getAll().get(0))
                                .build(),
                        Review.builder()
                                .reviewer("Ilie Nastase")
                                .text("Not that good")
                                .movie(movieService.getAll().get(0))
                                .build(),
                        Review.builder()
                                .reviewer("Ion Tiriac")
                                .text("Better than Movie 1")
                                .movie(movieService.getAll().get(1))
                                .build(),
                        Review.builder()
                                .reviewer("Ilie Nastase")
                                .text("Ok")
                                .movie(movieService.getAll().get(1))
                                .build(),
                        Review.builder()
                                .reviewer("Ion Tiriac")
                                .text("Not a good movie")
                                .movie(movieService.getAll().get(2))
                                .build(),
                        Review.builder()
                                .reviewer("Ilie Nastase")
                                .text("Not a good movie")
                                .movie(movieService.getByName("Another Movie"))
                                .build()
                )
        );
    }
}
