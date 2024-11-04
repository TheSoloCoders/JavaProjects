package roy.aman.sytbackendapp.Controllers;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import roy.aman.sytbackendapp.Services.FileService;
import roy.aman.sytbackendapp.Services.PostService;
import roy.aman.sytbackendapp.Utility.PostDto;
import roy.aman.sytbackendapp.Utility.PostResponse;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/app")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private FileService fileService;
    @Value("${project.image}")
    private String path;


    @PostMapping("/user/{userId}/category/{categoryId}/post")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,
                                              @RequestParam(value = "image", required = false) MultipartFile image,
                                              @PathVariable Integer userId, @PathVariable Integer categoryId) throws IOException {

        PostDto post = this.postService.createPost(postDto, userId, categoryId);

        if (image != null) {
            String fileName = this.fileService.uploadImage(path, image);
            postDto.setImageName(fileName);
            post = this.postService.updatePost(postDto, post.getPostId());

        }

        return new ResponseEntity<PostDto>(post, HttpStatus.CREATED);

    }

    @PatchMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId) {
        PostDto post = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@Valid @PathVariable Integer postId) {
        this.postService.deletePost(postId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {

        List<PostDto> posts = this.postService.getPostsByUser(userId);

        return new ResponseEntity<>(posts, HttpStatus.OK);

    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<PostResponse> getPostByCategory(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir,
            @PathVariable Integer categoryId
    ) {

        PostResponse postResponse = this.postService.getPostsByCategory(categoryId, pageNum, pageSize, sortBy, sortDir);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {

        PostDto post = this.postService.getPostById(postId);

        return new ResponseEntity<>(post, HttpStatus.OK);

    }


    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {

        PostResponse postResponse = this.postService.getAllPost(pageNum, pageSize, sortBy, sortDir);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);

    }


    // post image upload
    @PostMapping("/post/image/upload/{postId}")
    public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image,
                                                   @PathVariable Integer postId) throws IOException {

        PostDto postDto = this.postService.getPostById(postId);

        String fileName = this.fileService.uploadImage(path, image);
        System.out.println("image uploaded!");
        postDto.setImageName(fileName);

        PostDto updatePost = this.postService.updatePost(postDto, postId);

        System.out.println("post uploaded with " + fileName);

        return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);

    }


    //method to serve files
    @GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName,
            HttpServletResponse response
    ) throws IOException {

        InputStream resource = this.fileService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());

    }


}

