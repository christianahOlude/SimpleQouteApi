package org.example.controller;

import org.example.data.model.Quote;
import org.example.dto.request.QuoteRequest;
import org.example.dto.request.QuoteUpdateRequest;
import org.example.dto.response.QuoteResponse;
import org.example.dto.response.QuoteUpdateResponse;
import org.example.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class QuoteController {

    private final QuoteService quoteService;
    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping("/addQuote")
    public ResponseEntity<QuoteResponse> addQuotes(@RequestBody QuoteRequest quoteRequest) {
        QuoteResponse response = quoteService.addQuote(quoteRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/updateQuote")
    public ResponseEntity<QuoteUpdateResponse> updateQuote(@RequestBody QuoteUpdateRequest quoteUpdateRequest) {
        QuoteUpdateResponse response = quoteService.updateQuote(quoteUpdateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteQuote")
    public ResponseEntity<String> deleteQuote(@RequestBody Quote quote) {
        quoteService.deleteQuoteById(quote);
        return new ResponseEntity<>("Quote deleted successfully!", HttpStatus.OK);
    }
}

