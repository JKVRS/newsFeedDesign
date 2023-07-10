package com.development.newsfeed.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Post extends BaseModel{

    private String description;
    private int upvote;
    private int downvote;
    @OneToMany
    private List< Comments> comment;
    private Date date;
    @ManyToOne
    private User createdByUser;
}
