package roy.aman.sytbackendapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roy.aman.sytbackendapp.Services.UserService;
import roy.aman.sytbackendapp.Utility.UserDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/app/users")
public class UserController {

    @Autowired // this is important
    private UserService userService;

    //POST
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        System.out.println(userDto);
        UserDto dto = this.userService.createUser(userDto);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid) {
        UserDto dto = this.userService.updateUser(userDto, uid);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {

        this.userService.deleteUser(userId);

        return new ResponseEntity<>("User Deleted successfully", HttpStatus.OK);
    }

    //GET
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {
        UserDto user = this.userService.getUserById(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUser() {
        List<UserDto> users = this.userService.getAllUser();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
