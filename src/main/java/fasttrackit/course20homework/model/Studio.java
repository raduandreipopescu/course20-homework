package fasttrackit.course20homework.model;

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
public class Studio {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String address;

    @OneToMany(mappedBy = "studio", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = LAZY)
    private List<Movie> movies;
}
