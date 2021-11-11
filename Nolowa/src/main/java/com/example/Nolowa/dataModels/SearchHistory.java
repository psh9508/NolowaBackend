package com.example.Nolowa.dataModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class SearchHistory {
    @Id @GeneratedValue
    @JsonIgnore
    private Long searchId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User searchUser;

    @ManyToOne
    @JoinColumn(name = "searched_user_id")
    private User searchedList;

    @CreatedDate
    private LocalDateTime uploadedDateTime;
}
