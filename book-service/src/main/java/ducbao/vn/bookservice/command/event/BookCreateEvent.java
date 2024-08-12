package ducbao.vn.bookservice.command.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateEvent {
    String id;
    String name;
    String author;
    boolean isReady;
}
