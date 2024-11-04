package roy.aman.sytbackendapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roy.aman.sytbackendapp.Exceptions.ApiResponse;
import roy.aman.sytbackendapp.Services.CommentService;
import roy.aman.sytbackendapp.Utility.CommentDto;


@RestController
@RequestMapping("/app/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/users/{userId}/posts/{postId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId, @PathVariable Integer userId) {

        System.out.println("We are here ");
        CommentDto createComment = this.commentService.createComment(commentDto, userId, postId);

        return new ResponseEntity<>(createComment, HttpStatus.CREATED);

    }


    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer commentId) {

        this.commentService.deleteComment(commentId);

        return new ResponseEntity<>(new ApiResponse("This comment has been deleted Successfuly !", true), HttpStatus.CREATED);

    }


}
