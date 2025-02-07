package app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "notes")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Note implements BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;
}