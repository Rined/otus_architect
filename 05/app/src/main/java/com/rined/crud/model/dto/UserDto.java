package com.rined.crud.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.rined.crud.validation.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @JsonProperty("id")
    @JsonView(Views.GetDto.class)
    private Long id;

    @JsonProperty("username")
    @JsonView(Views.GetDto.class)
    @NotNull(message = "Username is mandatory!", groups = {Views.GetDto.class})
    @Size(max = 256, message = "Username must be not more 256 characters")
    private String username;

    @JsonProperty("firstName")
    @JsonView(Views.General.class)
    @NotNull(message = "First name is mandatory!", groups = {Views.General.class})
    private String firstName;

    @JsonProperty("lastName")
    @JsonView(Views.General.class)
    @NotNull(message = "Last name is mandatory!", groups = {Views.General.class})
    private String lastName;

    @JsonProperty("email")
    @JsonView(Views.General.class)
    @Email(message = "Valid email is mandatory!", groups = {Views.General.class})
    @NotNull(message = "Email is mandatory!", groups = {Views.General.class})
    private String email;

    @JsonProperty("phone")
    @JsonView(Views.General.class)
    @PhoneNumber(message = "Invalid phone number!", groups = {Views.General.class})
    private String phone;

}
