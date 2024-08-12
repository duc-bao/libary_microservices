package ducbao.vn.bookservice.command.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequestModel {
    String id;
    String name;
    String author;
    boolean isReady;
}
