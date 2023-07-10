package com.development.newsfeed.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    private String name;
    private String responseMessage;
    private int responseStatus;

}
