package roy.aman.sytbackendapp.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roy.aman.sytbackendapp.Utility.VoteType;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer voteId;

    private VoteType votetype;

    @OneToOne
    private User voter;

    @OneToOne
    private Post post;


}
