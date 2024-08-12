package ducbao.vn.bookservice.command.controller;

import java.util.UUID;

import ducbao.vn.bookservice.command.command.DeleteBookCommand;
import ducbao.vn.bookservice.command.command.UpdateBookCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import ducbao.vn.bookservice.command.command.CreateBookCommand;
import ducbao.vn.bookservice.command.model.request.BookRequestModel;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookCommandController {
    private final CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody BookRequestModel bookRequestModel) {
        CreateBookCommand createBookCommand = new CreateBookCommand(
                UUID.randomUUID().toString(), bookRequestModel.getName(), bookRequestModel.getAuthor(), true);
        return commandGateway.sendAndWait(createBookCommand);
    }
    @PutMapping("/{bookId}")
    public  String updateBook(@PathVariable String bookId, @RequestBody BookRequestModel bookRequestModel) {
        UpdateBookCommand updateBookCommand = new UpdateBookCommand(
              bookId, bookRequestModel.getName(), bookRequestModel.getAuthor(), true);
        return  commandGateway.sendAndWait(updateBookCommand);
    }
    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable String bookId) {
        DeleteBookCommand deleteBookCommand = new DeleteBookCommand(bookId);
        return commandGateway.sendAndWait(deleteBookCommand);
    }
}
