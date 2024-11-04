package roy.aman.sytbackendapp.Utility;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {

    @NotNull
    @Size(min = 3, message = "Title should be at least 3 letter")
    private String categoryTitle;
    @NotNull()
    private String categoryDescription;


}
