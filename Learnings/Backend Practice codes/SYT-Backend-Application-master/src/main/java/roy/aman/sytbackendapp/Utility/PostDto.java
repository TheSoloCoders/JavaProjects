package roy.aman.sytbackendapp.Utility;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Integer postId;
    @NotNull
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;

    // Optional for POST
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto author;
    private Integer votes;
    private Integer numberOfCommenrt;

//    private Set<CommentDto> commnets = new HashSet<>(); 

}
