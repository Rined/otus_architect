package com.rined.crud.model.dto;

public interface Views {

    interface General {}

    interface PutDto extends General {}

    interface PostDto extends General {}

    interface GetDto extends PostDto {}

}
