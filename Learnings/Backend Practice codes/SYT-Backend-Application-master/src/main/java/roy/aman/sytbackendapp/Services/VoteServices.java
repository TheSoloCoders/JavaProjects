package roy.aman.sytbackendapp.Services;

import roy.aman.sytbackendapp.Entities.Vote;

import java.util.List;

public interface VoteServices {

    List<Vote> getAllVotesOfPost(Integer postId);

    Integer upVote(Integer postId, Integer userId);

    Integer downVote(Integer postId, Integer userId);

}
