package ducbao.vn.bookservice.query.controller;

import ducbao.vn.bookservice.query.model.response.BookResponseModel;
import ducbao.vn.bookservice.query.query.GetAllBookQuery;
import ducbao.vn.bookservice.query.query.GetBookByIdQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookQueryController {
    private  final QueryGateway queryGateway;
    @GetMapping
    public List<BookResponseModel> getAllBooks() {
        GetAllBookQuery getAllBookQuery = new GetAllBookQuery();
        // Xử lí bất đồng bộ khi có Complefeature
        //CompletableFuture<List<BookResponseModel>> listCompletableFuture = queryGateway.query(getAllBookQuery, ResponseTypes.multipleInstancesOf(BookResponseModel.class));
        //listCompletableFuture.thenAccept(bookResponseModels -> {});
        // Dong bo
        List<BookResponseModel> bookResponseModels = queryGateway.query(getAllBookQuery,ResponseTypes.multipleInstancesOf(BookResponseModel.class)).join();
        return  bookResponseModels;
    }
    @GetMapping("/{bookId}")
    public BookResponseModel getBook(@PathVariable String bookId) {
        GetBookByIdQuery getBookByIdQuery = new GetBookByIdQuery(bookId);
        BookResponseModel bookResponseModel = queryGateway.query(getBookByIdQuery,ResponseTypes.instanceOf(BookResponseModel.class)).join();
        return bookResponseModel;
    }
}
