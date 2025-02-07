package app.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserDTO {
    private long id;

    private String username;

    private LocalDate createdAt;
}

