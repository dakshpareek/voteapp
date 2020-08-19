package com.app.voteapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class siteDTO {

    private long id;

    @NotBlank(message = "Title can not be empty")
    private String title;

    @NotBlank(message = "Vote id can not be empty")
    private String voteId;

    @NotBlank(message = "URL can not be empty")
    private String url;

}
