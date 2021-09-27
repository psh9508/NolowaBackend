package com.example.Nolowa.dataModels;

import lombok.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
public class NolowaImage {
//    private Long userId;
    private String url;
    private String hash;
}
