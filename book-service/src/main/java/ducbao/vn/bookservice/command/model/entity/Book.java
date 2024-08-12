package ducbao.vn.bookservice.command.model.entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    private String id;

    private String name;
    private String author;
    private boolean isReady;
}
