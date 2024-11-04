package roy.aman.sytbackendapp.Services.Implimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roy.aman.sytbackendapp.Entities.User;
import roy.aman.sytbackendapp.Exceptions.ResourceNotFoundException;
import roy.aman.sytbackendapp.Repository.UserRepo;
import roy.aman.sytbackendapp.Services.UserService;
import roy.aman.sytbackendapp.Utility.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImp implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        this.userRepo.save(user);
        System.out.println(user);
        return userToDto(user);

    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {

        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
//        User user1 = dtoToUser(userDto);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        userRepo.save(user);
        return userToDto(user);
    }

    @Override
    public UserDto getUserById(Integer id) {

        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        return userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> users = userRepo.findAll();

        List<UserDto> userdtos = users.stream().map(u -> this.userToDto(u)).collect(Collectors.toList());
        return userdtos;
    }

    @Override
    public void deleteUser(Integer id) {

        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        userRepo.delete(user);

    }


    public UserDto userToDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserID(user.getUserID());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setAbout(user.getAbout());

        return dto;
    }

    private User dtoToUser(UserDto dto) {
        User user = new User();
//        user.setUserID(dto.getUserID());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setAbout(dto.getAbout());

        return user;
    }
}
