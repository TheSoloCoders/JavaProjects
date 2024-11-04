package roy.aman.sytbackendapp.Services;

import roy.aman.sytbackendapp.Utility.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId);

    void deleteComment(Integer commentId);


}
