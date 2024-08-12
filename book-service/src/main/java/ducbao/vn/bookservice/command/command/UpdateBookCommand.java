package ducbao.vn.bookservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBookCommand {
    @TargetAggregateIdentifier
    String id;
    String name;
    String author;
    boolean isReady;
}
