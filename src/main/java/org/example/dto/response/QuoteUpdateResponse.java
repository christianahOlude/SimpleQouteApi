package org.example.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class QuoteUpdateResponse {
    @Id
    private String id;
    private String message;
    private LocalDateTime timestamp;
}
