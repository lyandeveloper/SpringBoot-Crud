package api.springboot2essentials.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimeRequestDTO {
    @NotEmpty(message = "The anime name is required")
    @NotNull(message = "The anime name is required")
    private String name;
}
