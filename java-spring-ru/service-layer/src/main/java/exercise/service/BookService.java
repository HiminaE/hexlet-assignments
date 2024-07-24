package exercise.service;

import exercise.dto.AuthorDTO;
import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.model.Book;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.MethodInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public List<BookDTO> getAll() {
        var books = bookRepository.findAll();
        return books.stream().map(bookMapper::map).toList();
    }

    public BookDTO findById(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found!"));
        return bookMapper.map(book);
    }

    public BookDTO create(BookCreateDTO bookData) {
        var book = bookMapper.map(bookData);
        if (isAuthorExists(bookData.getAuthorId())) {
            bookRepository.save(book);
            return bookMapper.map(book);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author with id " + bookData.getAuthorId() + " not found!");
        }
    }

    public BookDTO update(BookUpdateDTO bookData, Long id) {
        if (isAuthorExists(id)) {
            var book = bookRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found!"));
            bookMapper.update(bookData, book);
            bookRepository.save(book);
            return bookMapper.map(book);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author with id " + bookData.getAuthorId() + " not found!");
        }
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public boolean isAuthorExists(Long id) {
        return authorRepository.existsById(id);
    }
    // END
}