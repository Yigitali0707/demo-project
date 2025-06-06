package uz.pdp.demoproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginDto(@NotBlank String username,@NotBlank String password) {
}
