package app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BuildRegisterPage {
    private String username = null;
    private List<String> errorMessages = null;
}
