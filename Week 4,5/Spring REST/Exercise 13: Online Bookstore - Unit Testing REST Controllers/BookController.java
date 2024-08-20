package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testGetBook_returnsBook() throws Exception {
        mockMvc.perform(get("/api/books")
                .param("title", "Test Book")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Test Book")))
                .andExpect(jsonPath("$.author", is("John Doe")))
                .andExpect(jsonPath("$.isbn", is("123-4567891234")));
    }

    @Test
    public void testGetBook_defaultTitle() throws Exception {
        mockMvc.perform(get("/api/books")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Sample Book")))
                .andExpect(jsonPath("$.author", is("John Doe")))
                .andExpect(jsonPath("$.isbn", is("123-4567891234")));
    }

    @Test
public void testGetBook_invalidInput() throws Exception {
    mockMvc.perform(get("/api/books")
            .param("title", "")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
}

    @Test
public void testGetBook_returnsBookInXml() throws Exception {
    mockMvc.perform(get("/api/books")
            .param("title", "Test Book")
            .accept(MediaType.APPLICATION_XML))
            .andExpect(status().isOk())
            .andExpect(xpath("/book/title").string("Test Book"))
            .andExpect(xpath("/book/author").string("John Doe"))
            .andExpect(xpath("/book/isbn").string("123-4567891234"));
}

}
