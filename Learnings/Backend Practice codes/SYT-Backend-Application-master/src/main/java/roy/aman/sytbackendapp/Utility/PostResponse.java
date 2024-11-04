package roy.aman.sytbackendapp.Utility;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostResponse {

    private List<PostDto> posts;

    private int pageNumber;

    private int pageSize;

    private int totalPages;

    private long totalElements;

    private boolean lastPage;


}
