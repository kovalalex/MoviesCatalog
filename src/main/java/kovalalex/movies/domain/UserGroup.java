package kovalalex.movies.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usergroup")
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "title")
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name="users_usergroups",
            joinColumns=@JoinColumn (name="usergroup_id"),
            inverseJoinColumns=@JoinColumn(name="user_id"))
    @JsonManagedReference
    private Set<User> users;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
