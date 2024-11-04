package roy.aman.sytbackendapp.Services.Implimentation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import roy.aman.sytbackendapp.Entities.Category;
import roy.aman.sytbackendapp.Entities.Post;
import roy.aman.sytbackendapp.Entities.User;
import roy.aman.sytbackendapp.Exceptions.ResourceNotFoundException;
import roy.aman.sytbackendapp.Repository.CategoryRepo;
import roy.aman.sytbackendapp.Repository.PostRepo;
import roy.aman.sytbackendapp.Repository.UserRepo;
import roy.aman.sytbackendapp.Services.PostService;
import roy.aman.sytbackendapp.Utility.PostDto;
import roy.aman.sytbackendapp.Utility.PostResponse;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;


    //CREATE
    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);

        post.setAuthor(user);
        post.setCategory(category);
        post.setImageName("default.png");
        post.setAddedDate(new Date());

        Post savedPost = this.postRepo.save(post);
        return this.modelMapper.map(savedPost, PostDto.class);
    }

    // UPDATE
    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {

        Post post = this.postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "postID", postId));

        post.setPostTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
//		post.setCategory(postDto.getCategory());

        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }


    //DELETE
    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postID", postId));
        this.postRepo.delete(post);
    }


    // GET
    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postID", postId));

        return this.modelMapper.map(post, PostDto.class);
    }


    @Override
    public PostResponse getPostsByCategory(Integer categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        Sort sort = null;

        if (sortDir.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }

        Pageable p = PageRequest.of(pageNumber, pageSize, sort);

        Page<Post> pagePost = this.postRepo.findByCategory(category, p);

        List<Post> posts = pagePost.getContent();
        List<PostDto> postDtos = posts.stream()
                .map(post -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        PostResponse postRes = new PostResponse();

        postRes.setPosts(postDtos);
        postRes.setPageNumber(pagePost.getNumber());
        postRes.setPageSize(pagePost.getSize());
        postRes.setTotalPages(pagePost.getTotalPages());
        postRes.setTotalElements(pagePost.getTotalElements());
        postRes.setLastPage(pagePost.isLast());


        return postRes;
    }


    @Override
    public List<PostDto> getPostsByUser(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        List<Post> posts = this.postRepo.findByAuthor(user);

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }


    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {


        Sort sort = null;

        if (sortDir.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }

        Pageable p = PageRequest.of(pageNumber, pageSize, sort);

        Page<Post> pagePost = this.postRepo.findAll(p);

        List<Post> posts = pagePost.getContent();
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        PostResponse postRes = new PostResponse();

        postRes.setPosts(postDtos);
        postRes.setPageNumber(pagePost.getNumber());
        postRes.setPageSize(pagePost.getSize());
        postRes.setTotalPages(pagePost.getTotalPages());
        postRes.setTotalElements(pagePost.getTotalElements());
        postRes.setLastPage(pagePost.isLast());


        return postRes;
    }


    // Searching for posts

    @Override
    public PostResponse searchPosts(String keyword) {
        // TODO Auto-generated method stub
        return null;
    }


}
