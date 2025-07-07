package org.example.services;

import org.example.data.model.Quote;
import org.example.data.repository.QuoteRepository;
import org.example.dto.request.QuoteRequest;
import org.example.dto.request.QuoteUpdateRequest;
import org.example.dto.response.QuoteResponse;
import org.example.dto.response.QuoteUpdateResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QuoteServiceImplTest {

    @Autowired
    private QuoteService quoteService;
    @Autowired
    private QuoteRepository quoteRepository;

    @BeforeEach
    public void setUp() {
        quoteRepository.deleteAll();
    }
    @AfterEach
    public void tearDown() {
        quoteRepository.deleteAll();
    }
    public void setNewText(QuoteRequest quoteRequest) {
        quoteRequest.setAuthor("Author");
        quoteRequest.setText("A thousand years");
    }
    @Test
    public void addQuote() {
        QuoteRequest quoteRequest = new QuoteRequest();
        setNewText(quoteRequest);
        QuoteResponse response = quoteService.addQuote(quoteRequest);
        assertEquals("Quote Successfully Added", response.getMessage());
    }

    @Test
    public void userCanUpdateQuote() {
        QuoteRequest quoteRequest = new QuoteRequest();
        setNewText(quoteRequest);
        QuoteResponse response = quoteService.addQuote(quoteRequest);
        assertEquals("Quote Successfully Added", response.getMessage());
        QuoteUpdateRequest quoteUpdateRequest = new QuoteUpdateRequest();
        quoteUpdateRequest.setAuthor("Authoress succy");
        quoteUpdateRequest.setText("My demon");
        QuoteUpdateResponse quoteUpdateResponse = quoteService.updateQuote(quoteUpdateRequest);
        assertEquals("Quote Successfully Updated", quoteUpdateResponse.getMessage());
    }

    @Test
    public void userCanDeleteQuote() {
        QuoteRequest quoteRequest = new QuoteRequest();
        setNewText(quoteRequest);
        QuoteResponse response = quoteService.addQuote(quoteRequest);
        assertEquals("Quote Successfully Added", response.getMessage());
        quoteRepository.deleteById(response.getId());
        assertFalse(quoteRepository.existsById(response.getId()));
        assertEquals(0, quoteRepository.count());
    }

}