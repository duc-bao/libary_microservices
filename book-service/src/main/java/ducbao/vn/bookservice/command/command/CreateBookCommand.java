package ducbao.vn.bookservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateBookCommand {
    @TargetAggregateIdentifier
    String id;

    String name;
    String author;
    boolean isReady;
}
