package org.example.services;

import org.example.data.model.Quote;
import org.example.data.repository.QuoteRepository;
import org.example.dto.request.QuoteDeleteRequest;
import org.example.dto.request.QuoteRequest;
import org.example.dto.request.QuoteUpdateRequest;
import org.example.dto.response.QuoteResponse;
import org.example.dto.response.QuoteUpdateResponse;
import org.example.utils.QuoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public QuoteResponse addQuote(QuoteRequest request) {
        if(request.getText() == null || request.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("Quote text can't be empty");
        }
        if(request.getAuthor() == null || request.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Quote author can't be empty");
        }
        Quote quote = QuoteMapper.mapQuote(request);
        quoteRepository.save(quote);
        return QuoteMapper.mapQuoteResponse(quote);
    }


    @Override
    public QuoteUpdateResponse updateQuote(QuoteUpdateRequest quoteUpdateRequest) {
        String existingText = quoteUpdateRequest.getText();

        if(existingText == null || existingText.trim().isEmpty()) {
            throw new IllegalArgumentException("Quote text can't be empty");
        }
        Quote updatedQuote = QuoteMapper.mapQuoteToUpdate(quoteUpdateRequest);
        quoteRepository.save(updatedQuote);
        return QuoteMapper.mapQuoteUpdateToResponse(updatedQuote);
    }

    @Override
    public void deleteQuoteById(QuoteDeleteRequest quoteDeleteRequest) {
        String quoteId = quoteDeleteRequest.getId();
        if (quoteId == null) {
            throw new IllegalArgumentException("Quote can't be null");
        }
        if (!quoteRepository.existsById(quoteId)) {
            throw new RuntimeException("Quote not found with id: " + quoteId);
        }
        Quote quote = QuoteMapper.mapQuoteRequestToDelete(quoteDeleteRequest);
//        quoteRepository.deleteById(quoteId);
        quoteRepository.delete(quote);
        QuoteMapper.mapQuoteToDeleteResponse(quote);
    }
}
