package com.jkns.jenkins.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDto {
    @NotBlank(message = "Movie name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Movie name must contain only letters and spaces")
    private String name;

    @NotBlank(message = "Movie genre is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Movie genre must contain only letters and spaces")
    private String genre;

    @NotNull(message = "Movie release year is required")
    private int year;
}
