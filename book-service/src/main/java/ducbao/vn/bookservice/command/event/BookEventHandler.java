package ducbao.vn.bookservice.command.event;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ducbao.vn.bookservice.command.model.entity.Book;
import ducbao.vn.bookservice.command.repository.BookRepository;

import java.util.Optional;

@Component
public class BookEventHandler {
    @Autowired
    BookRepository bookRepository;

    @EventHandler
    public void on(BookCreateEvent event) {
        Book book = new Book();
        BeanUtils.copyProperties(event, book);
        bookRepository.save(book);
    }
    @EventHandler
    public void on(BookUpdateEvent event) {
        Optional<Book> book = bookRepository.findById(event.getId());
        if (book.isPresent()) {
            Book book1 = book.get();
            book1.setName(book1.getName());
            book1.setAuthor(book1.getAuthor());
            book1.setReady(book1.isReady());
            bookRepository.save(book1);
        }
    }
    @EventHandler
    public void on(BookDeleteEvent event) {
        Optional<Book> bookOptional = bookRepository.findById(event.getBookId());
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            bookRepository.delete(book);
        }
    }
}
