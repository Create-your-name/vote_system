package sx_vote.dao;

import sx_vote.enums.EnuRoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    @NotEmpty
    @Size(min = 3, max = 30)
    private String username = "";

    @NotEmpty
    @Size(min = 3, max = 30)
    private String password = "";

    @NotEmpty
    private String email = "";

    @NotEmpty
    @Size(min = 3, max = 30)
    private String passwordConfirmation = "";


    private Integer role;

    private Integer age;

    @NotEmpty
    @Length(min = 11, max = 11)
    private String phone;

    private String classes;

    private int sex;

}

