package ducbao.vn.bookservice.command.aggregate;

import ducbao.vn.bookservice.command.command.DeleteBookCommand;
import ducbao.vn.bookservice.command.command.UpdateBookCommand;
import ducbao.vn.bookservice.command.event.BookDeleteEvent;
import ducbao.vn.bookservice.command.event.BookUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import ducbao.vn.bookservice.command.command.CreateBookCommand;
import ducbao.vn.bookservice.command.event.BookCreateEvent;
import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class BookAggregate {
    @AggregateIdentifier
    String id;

    String name;
    String author;
    boolean isReady;

    @CommandHandler
    public BookAggregate(CreateBookCommand command) {
        BookCreateEvent bookCreateEvent = new BookCreateEvent();
        //        Class giups thao tác với entity target và object
        BeanUtils.copyProperties(command, bookCreateEvent);
        // Đối tượng của aggregate public đi 1 cái event
        AggregateLifecycle.apply(bookCreateEvent);
    }
    @CommandHandler
    public void handle(UpdateBookCommand command) {
        UpdateBookCommand updateBookCommand = new UpdateBookCommand();
        BeanUtils.copyProperties(command, updateBookCommand);
        AggregateLifecycle.apply(updateBookCommand);
    }
    @CommandHandler
    public void handle(DeleteBookCommand command) {
        DeleteBookCommand deleteBookCommand = new DeleteBookCommand();
        BeanUtils.copyProperties(command, deleteBookCommand);
        AggregateLifecycle.apply(deleteBookCommand);
    }
    // Xử lí sự kiện được phát ra
    @EventSourcingHandler
    public void on(BookCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.author = event.getAuthor();
        this.isReady = event.isReady();
    }
    @EventSourcingHandler
    public void on(BookUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.author = event.getAuthor();
        this.isReady = event.isReady();
    }
    @EventSourcingHandler
    public void on(BookDeleteEvent event) {
        this.id  = event.getBookId();
    }
}
