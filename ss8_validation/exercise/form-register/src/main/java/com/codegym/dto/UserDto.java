package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Validator {
    @NotBlank(message = "YOU MUST ENTER, OK?")
    @Size(min = 5,max = 45)
    private String firstName;
    @NotBlank(message = "YOU MUST ENTER, OK?")
    @Size(min = 5,max = 45,message = "size must between 5 and 45")
    private String lastName;

    @NotBlank(message = "YOU MUST ENTER, OK?")
    @Pattern(regexp = "^(0|\\+84)\\d{9}$",message = "Sai format")
    private String phoneNumber;


    private String birthDay;

    @NotBlank(message = "YOU MUST ENTER, OK?")
    @Email
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        LocalDate now = LocalDate.now();
        LocalDate birthday = null;
        int age = 0;
        try {
             birthday = LocalDate.parse(userDto.birthDay);
             age = birthday.until(now).getYears();
            if (age < 18){
                errors.rejectValue("birthDay",
                        "birday check",
                        "you are under 18 years old");
            }
        } catch (Exception e){
            errors.rejectValue("birthDay","dvdsv","Select Date");
        }
    }
}
