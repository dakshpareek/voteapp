package com.app.voteapp.entity;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sites")
@ToString
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "Title can not be empty")
    private String title;

    @NotBlank(message = "Vote id can not be empty")
    private String voteId;

    @NotBlank(message = "URL can not be empty")
    private String url;

    private int visible = 1;

    @JsonIgnore
    @OneToMany( fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "site")
    private Set<Vote> votes = new HashSet<>();

}
