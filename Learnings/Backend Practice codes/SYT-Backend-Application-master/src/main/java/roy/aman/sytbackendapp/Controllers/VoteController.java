package roy.aman.sytbackendapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roy.aman.sytbackendapp.Entities.Vote;
import roy.aman.sytbackendapp.Services.VoteServices;

import java.util.List;

@RestController
@RequestMapping("/app/votes")
public class VoteController {

    @Autowired
    private VoteServices voteService;

    @PostMapping("/posts/{postId}/users/{userId}/upvote")
    public ResponseEntity<Integer> upvoteToPost(@PathVariable Integer postId, @PathVariable Integer userId) {

        Integer upVote = this.voteService.upVote(postId, userId);

        return new ResponseEntity<>(upVote, HttpStatus.OK);

    }


    @PostMapping("/posts/{postId}/users/{userId}/downvote")
    public ResponseEntity<Integer> downvoteToPost(@PathVariable Integer postId, @PathVariable Integer userId) {

        Integer upVote = this.voteService.downVote(postId, userId);

        return new ResponseEntity<>(upVote, HttpStatus.OK);

    }


    @GetMapping("/posts/{postId}")
    public ResponseEntity<List<Vote>> upvoteToPost(@PathVariable Integer postId) {

        List<Vote> totalVotes = this.voteService.getAllVotesOfPost(postId);

        return new ResponseEntity<>(totalVotes, HttpStatus.OK);

    }

}
