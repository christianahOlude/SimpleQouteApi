package org.example.utils;

import org.example.data.model.Quote;
import org.example.dto.request.QuoteRequest;
import org.example.dto.request.QuoteUpdateRequest;
import org.example.dto.response.QuoteResponse;
import org.example.dto.response.QuoteUpdateResponse;

import java.time.LocalDateTime;

public class QuoteMapper {

    public static Quote mapQuote(QuoteRequest quoteRequest) {
        Quote quote = new Quote();
        quote.setText(quoteRequest.getText());
        quote.setAuthor(quoteRequest.getAuthor());
        quote.setDate(LocalDateTime.now());
        return quote;
    }

    public static QuoteResponse mapQuoteResponse(Quote quote) {
        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setId(quote.getId());
        quoteResponse.setTimestamp(LocalDateTime.now());
        quoteResponse.setMessage("Quote Successfully Added");
        return quoteResponse;
    }

    public static Quote mapQuoteToUpdate(QuoteUpdateRequest quoteUpdateRequest) {
        Quote existingQuote = new Quote();
        existingQuote.setText(quoteUpdateRequest.getUpdatedText());
        existingQuote.setAuthor(quoteUpdateRequest.getAuthor());
        existingQuote.setDate(LocalDateTime.now());
        return existingQuote;
    }

    public static QuoteUpdateResponse mapQuoteUpdateToResponse(Quote updatedQuote) {
        QuoteUpdateResponse quoteUpdateResponse = new QuoteUpdateResponse();
        quoteUpdateResponse.setId(updatedQuote.getId());
        quoteUpdateResponse.setTimestamp(LocalDateTime.now());
        quoteUpdateResponse.setMessage("Quote Successfully Updated");
        return quoteUpdateResponse;
    }
}
