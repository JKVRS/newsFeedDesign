package com.development.newsfeed.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SubComments extends BaseModel{
    private String descrption;
    @ManyToOne
    private User CreatedBy;
}
