package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public record Book(
        @NotBlank(message = "The book ISBN must be defined")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The book ISBN must be a valid ISBN-10 or ISBN-13 number"
        )
        String isbn,

        @NotBlank(message = "The book title must be defined")
        String title,

        @NotBlank(message = "The book author must be defined")
        String author,

        @NotNull(message = "The book price must be defined")
        @PositiveOrZero(message = "The book price must be greater than zero")
        Double price
) {}
