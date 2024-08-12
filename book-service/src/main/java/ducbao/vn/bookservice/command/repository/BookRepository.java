package ducbao.vn.bookservice.command.repository;

import ducbao.vn.bookservice.command.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {}
