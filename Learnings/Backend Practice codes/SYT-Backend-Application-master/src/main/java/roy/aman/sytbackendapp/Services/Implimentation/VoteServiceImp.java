package roy.aman.sytbackendapp.Services.Implimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roy.aman.sytbackendapp.Entities.Post;
import roy.aman.sytbackendapp.Entities.User;
import roy.aman.sytbackendapp.Entities.Vote;
import roy.aman.sytbackendapp.Exceptions.ResourceNotFoundException;
import roy.aman.sytbackendapp.Repository.PostRepo;
import roy.aman.sytbackendapp.Repository.UserRepo;
import roy.aman.sytbackendapp.Repository.VoteRepository;
import roy.aman.sytbackendapp.Services.VoteServices;
import roy.aman.sytbackendapp.Utility.VoteType;

import java.util.List;


@Service
public class VoteServiceImp implements VoteServices {


    @Autowired
    private PostRepo postRepo;

    @Autowired
    private VoteRepository voteRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<Vote> getAllVotesOfPost(Integer postId) {

        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));

        List<Vote> allVotes = this.voteRepo.findAllByPost(post);

        return allVotes;

    }

    @Override
    public Integer upVote(Integer postId, Integer userId) {


        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        Vote vote = new Vote();
        vote.setPost(post);
        vote.setVoter(user);
        vote.setVotetype(VoteType.UPVOTE);

        this.voteRepo.save(vote);

        Integer votes = post.getVotes();
        post.setVotes(++votes);

        this.postRepo.save(post);

        return votes;
    }


    @Override
    public Integer downVote(Integer postId, Integer userId) {

        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        Vote vote = new Vote();
        vote.setPost(post);
        vote.setVoter(user);
        vote.setVotetype(VoteType.DOWNVOTE);

        this.voteRepo.save(vote);

        Integer votes = post.getVotes();
        post.setVotes(--votes);

        this.postRepo.save(post);

        return votes;
    }


}
