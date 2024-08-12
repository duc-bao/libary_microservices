package ducbao.vn.bookservice.command.event;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ducbao.vn.bookservice.command.data.Book;
import ducbao.vn.bookservice.command.data.BookRepository;

@Component
public class BookEventHandler {
    @Autowired
    BookRepository bookRepository;

    @EventListener
    public void on(BookCreateEvent event) {
        Book book = new Book();
        BeanUtils.copyProperties(event, book);
        bookRepository.save(book);
    }
}
