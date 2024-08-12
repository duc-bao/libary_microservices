package ducbao.vn.bookservice.command.data;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String author;
    private boolean isReady;
}
