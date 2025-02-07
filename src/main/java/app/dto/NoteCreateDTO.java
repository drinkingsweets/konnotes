package app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteCreateDTO {
    @NotBlank
    private String slug;

    @NotBlank
    private String content;
}
