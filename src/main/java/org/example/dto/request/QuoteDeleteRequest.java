package org.example.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class QuoteDeleteRequest {
    private String id;
}
