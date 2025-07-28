package org.example.services;

import org.example.data.model.Quote;
import org.example.dto.request.QuoteRequest;
import org.example.dto.request.QuoteUpdateRequest;
import org.example.dto.response.QuoteResponse;
import org.example.dto.response.QuoteUpdateResponse;
import org.springframework.stereotype.Service;

@Service
public interface QuoteService {
    QuoteResponse addQuote(QuoteRequest request);

    QuoteUpdateResponse updateQuote(QuoteUpdateRequest quoteUpdateRequest);
    void deleteQuoteById(Quote quote);
}
