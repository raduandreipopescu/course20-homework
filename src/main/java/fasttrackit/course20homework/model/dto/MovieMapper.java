package fasttrackit.course20homework.model.dto;

import fasttrackit.course20homework.model.Movie;

public class MovieMapper {
    public static MovieDTO toDto(Movie entity) {
        return MovieDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .year(entity.getMovieYear())
                .rating(entity.getRating())
                .reviews(entity.getReviews())
                .studio(entity.getStudio())
                .actors(entity.getActors())
                .build();
    }

    public static Movie toEntity(MovieDTO movieDTO) {
        return Movie.builder()
                .id(movieDTO.id())
                .name(movieDTO.name())
                .movieYear(movieDTO.year())
                .rating(movieDTO.rating())
                .reviews(movieDTO.reviews())
                .studio(movieDTO.studio())
                .actors(movieDTO.actors())
                .build();
    }
}
