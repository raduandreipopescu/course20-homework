package fasttrackit.course20homework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String text;

    @Column
    private String reviewer;

    @ManyToOne
    @JsonIgnore
    private Movie movie;
}
