package org.example.utils;

import org.example.data.model.Quote;
import org.example.dto.request.QuoteDeleteRequest;
import org.example.dto.request.QuoteRequest;
import org.example.dto.request.QuoteUpdateRequest;
import org.example.dto.response.QuoteDeleteResponse;
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

    public static Quote mapQuoteRequestToDelete(QuoteDeleteRequest quoteDeleteRequest) {
        Quote quote = new Quote();
        quoteDeleteRequest.setId(quote.getId());
        return quote;
    }

    public static QuoteDeleteResponse mapQuoteToDeleteResponse(Quote quote) {
        QuoteDeleteResponse quoteDeleteResponse = new QuoteDeleteResponse();
        quoteDeleteResponse.setMessage(quote.getId() + " deleted successfully");
        return quoteDeleteResponse;
    }
}
