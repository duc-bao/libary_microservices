package ducbao.vn.bookservice.query.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponseModel {
    String name;
    String author;
    boolean isReady;
}
