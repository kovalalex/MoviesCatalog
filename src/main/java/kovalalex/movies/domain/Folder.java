package kovalalex.movies.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "folder")
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    private boolean active;
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "folder", fetch = FetchType.EAGER )
    private Set<Movie> movies;
    public boolean isActive() {
        return active;
    }
    public boolean setActive() { return active; }
    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
