package com.app.voteapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class userDTO {

    @NotBlank(message = "User Name can not be empty")
    private String userName;

}
