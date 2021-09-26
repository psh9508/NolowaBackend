package com.example.Nolowa.dataModels;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NolowaImage {
    private Long userId;
    private String url;
    private String hash;
}
