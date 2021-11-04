package com.example.Nolowa.dataModels;

import com.example.Nolowa.Helpers.FileHelper;
import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class NolowaImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String url;
    protected String hash;

    public void setUrlAndHash(String url) {
        this.url = url;

        try {
            this.hash = FileHelper.extractFileHashSHA256(url);
        } catch (Exception ex) {
            this.hash = "";
        }
    }
}
