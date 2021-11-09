import java.util.List;

public interface AuthorMapper {
	 Author find(String id);
	 List<Author> findAll();
	 void regist(Author author);
	 void update(Author author);
	 void delete(String id); 
}
