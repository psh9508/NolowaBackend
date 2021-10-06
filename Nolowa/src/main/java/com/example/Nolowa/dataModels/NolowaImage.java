package com.example.Nolowa.dataModels;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
public class NolowaImage {
    @Id
    private  Long id;
    @Lob
    private String url;
    private String hash;
}
