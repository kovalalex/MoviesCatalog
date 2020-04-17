package kovalalex.movies.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private LocalDate creationDate;
    @Getter
    @Setter
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;


    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                active == movie.active &&
                Objects.equals(title, movie.title) &&
                Objects.equals(creationDate, movie.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", active=" + active +
                '}';
    }
}
