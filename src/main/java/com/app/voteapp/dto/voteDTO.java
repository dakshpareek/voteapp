package com.app.voteapp.dto;

import com.app.voteapp.entity.Site;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class voteDTO {

    @NotBlank(message = "User Name can not be empty")
    private String userName;

    private String ipAddress;

    private String voteKey;

    @NotBlank(message = "Site Id can not be empty")
    private long siteId;
}
