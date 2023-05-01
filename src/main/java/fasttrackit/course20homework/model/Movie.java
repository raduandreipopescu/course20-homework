package fasttrackit.course20homework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private int movieYear;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private MovieRating rating;

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = LAZY)
    private List<Review> reviews;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Studio studio;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Actor> actors;
}
