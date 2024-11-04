package roy.aman.sytbackendapp.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;

    @Column(name = "user_name", nullable = false, length = 100)
    @Size(min = 4, max = 15, message = "Name should be between 4 to 15 letter")
    private String name;
    @Email(message = "Use valid email")
    private String email;
    @Min(value = 5, message = "password should be minimum of 5")
    private String Password;
    @NotNull
    private String About;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Post> posts = new HashSet<>();

}
