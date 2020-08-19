package com.app.voteapp.entity;


import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "votes")
@ToString
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "User Name can not be empty")
    private String userName;

    private String ipAddress;

    private String voteKey;

    @CreationTimestamp
    private LocalDateTime startedOn;

    private LocalDateTime voteOn;

    private int claimed = 1;


    @ManyToOne( fetch = FetchType.EAGER, optional = false)
    @JoinColumn( name = "site_id", nullable = false)
    @OnDelete( action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Site site;

}
