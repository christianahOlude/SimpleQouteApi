package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class QuoteUpdateRequest {
    private String text;
    private String updatedText;
    private String author;
}
