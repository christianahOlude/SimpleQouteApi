package org.example.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class QuoteRequest {
    private String text;
    private String author;
    private LocalDateTime date;
}