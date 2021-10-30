package com.example.Nolowa.dataModels;

import com.example.Nolowa.Helpers.FileHelper;
import lombok.*;

import javax.persistence.*;

@MappedSuperclass
public class NolowaImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String url;
    private String hash;

    public void setUrl(String url) {
        this.url = url;

        try {
            this.hash = FileHelper.extractFileHashSHA256(url);
        } catch (Exception ex) {
            this.hash = "";
        }
    }

    public void setId(Long id) {
        this.id = id;
    }
}
