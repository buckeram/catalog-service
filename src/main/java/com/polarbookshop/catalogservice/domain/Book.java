package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

public record Book(
        @Id
        Long id,

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
        Double price,

        @CreatedDate
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate,

        @Version
        int version
) {
        public static Book of(String isbn, String title, String author, Double price) {
                return new Book(null, isbn, title, author, price, null, null, 0);
        }
}
