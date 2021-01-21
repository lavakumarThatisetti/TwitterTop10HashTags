package com.example.TwiiterTrendingHashTags.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Access(AccessType.FIELD)
@Table(name = "tweets")
public class Tweets {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="user_name")
    @NotNull
    private String username;

    @Column(name="tweet")
    @NotNull
    private String tweet;
}
