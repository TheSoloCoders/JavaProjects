package roy.aman.sytbackendapp.Services;

import roy.aman.sytbackendapp.Utility.PostDto;
import roy.aman.sytbackendapp.Utility.PostResponse;

import java.util.List;


public interface PostService {

    //create

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update

    PostDto updatePost(PostDto postDto, Integer postId);

    // delete

    void deletePost(Integer postId);

    //get all posts

    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    //get single post

    PostDto getPostById(Integer postId);

    //get all posts by category

    PostResponse getPostsByCategory(Integer categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir);


    //get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    //search posts
    PostResponse searchPosts(String keyword);


}

