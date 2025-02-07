package app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Setter
@Getter
public class NoteUpdateDTO {
    @NotBlank
    private JsonNullable<String> content;
}
