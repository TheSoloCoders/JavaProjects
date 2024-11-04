package roy.aman.sytbackendapp.Services.Implimentation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roy.aman.sytbackendapp.Entities.Comment;
import roy.aman.sytbackendapp.Entities.Post;
import roy.aman.sytbackendapp.Entities.User;
import roy.aman.sytbackendapp.Exceptions.ResourceNotFoundException;
import roy.aman.sytbackendapp.Repository.CommentRepo;
import roy.aman.sytbackendapp.Repository.PostRepo;
import roy.aman.sytbackendapp.Repository.UserRepo;
import roy.aman.sytbackendapp.Services.CommentService;
import roy.aman.sytbackendapp.Utility.CommentDto;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepo postRepo;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId) {

        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        Comment comment = new Comment();

        comment.setCommenter(user);

        comment.setPost(post);

        comment.setComment(commentDto.getComment());

        post.setNumberOfComments(post.getNumberOfComments() + 1);


        Comment savedComment = this.commentRepo.save(comment);
        this.postRepo.save(post);

        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentID", commentId));

        this.commentRepo.delete(comment);

    }


}
