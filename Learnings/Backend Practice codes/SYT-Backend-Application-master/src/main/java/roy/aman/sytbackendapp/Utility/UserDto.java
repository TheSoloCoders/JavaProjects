package roy.aman.sytbackendapp.Utility;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private Integer userID;

    @Size(min = 4, max = 15, message = "Name should be between 4 to 15 letter")
    private String name;
    @Email(message = "Please provide a valid ")
    private String email;
    @Min(value = 5, message = "password should be minimum of 5")
    private String Password;
    @NotNull
    private String About;
}
