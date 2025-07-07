package org.example.services;

import org.example.data.model.Quote;
import org.example.data.repository.QuoteRepository;
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
    public void deleteQuoteById(Quote quote) {
        if (!quoteRepository.existsById(quote.getId())) {
            throw new RuntimeException("Quote not found with id: " + quote.getId());
        }
        quoteRepository.deleteById(quote.getId());
    }


}
