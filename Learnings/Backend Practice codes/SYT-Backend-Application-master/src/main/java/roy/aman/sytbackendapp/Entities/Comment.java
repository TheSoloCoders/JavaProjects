package roy.aman.sytbackendapp.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    private String comment;

    @OneToOne
    private User commenter;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

}
