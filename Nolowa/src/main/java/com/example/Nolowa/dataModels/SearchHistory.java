package com.example.Nolowa.dataModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private User searchedUser;

    private String keyword;

    @CreatedDate
    private LocalDateTime uploadedDateTime;
}
