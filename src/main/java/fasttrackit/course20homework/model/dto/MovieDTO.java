package fasttrackit.course20homework.model.dto;

import fasttrackit.course20homework.model.Actor;
import fasttrackit.course20homework.model.MovieRating;
import fasttrackit.course20homework.model.Review;
import fasttrackit.course20homework.model.Studio;
import lombok.Builder;

import java.util.List;

@Builder
public record MovieDTO(
        Integer id,
        String name,
        int year,
        MovieRating rating,
        List<Review> reviews,
        Studio studio,
        List<Actor> actors
) {
}
