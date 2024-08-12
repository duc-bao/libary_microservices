package ducbao.vn.bookservice.query.projection;

import ducbao.vn.bookservice.command.model.entity.Book;
import ducbao.vn.bookservice.command.repository.BookRepository;
import ducbao.vn.bookservice.query.model.response.BookResponseModel;
import ducbao.vn.bookservice.query.query.GetAllBookQuery;
import ducbao.vn.bookservice.query.query.GetBookByIdQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookProjection {
    private final BookRepository bookRepository;
    @QueryHandler
    public List<BookResponseModel> findAll(GetAllBookQuery query) {
        List<Book> books = bookRepository.findAll();
        List<BookResponseModel> bookResponseModels  = new ArrayList<>();
                books.forEach(
                book -> {
                    BookResponseModel bookResponseModel = new BookResponseModel();
                    BeanUtils.copyProperties(book, bookResponseModel);
                    bookResponseModels.add(bookResponseModel);
                }
        );
        return  bookResponseModels;
    }
    @QueryHandler
    public BookResponseModel findById(GetBookByIdQuery query) {
        Optional<Book> book = bookRepository.findById(query.getId());
        if (book.isPresent()) {
            BookResponseModel bookResponseModel = new BookResponseModel();
            BeanUtils.copyProperties(book.get(), bookResponseModel);
            return bookResponseModel;
        }
        return null;
    }
}
