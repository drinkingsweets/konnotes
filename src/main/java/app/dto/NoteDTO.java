package app.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NoteDTO {
    private Long id;
    private String slug;
    private String author;
    private String content;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
