package fasttrackit.course20homework.service;

import fasttrackit.course20homework.model.Review;
import fasttrackit.course20homework.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public void addAll(List<Review> reviews) {
        repository.saveAll(reviews);
    }
}
