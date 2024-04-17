import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    public T findById(int id) throws SQLException;
    public List<T> findAll() throws SQLException;
    public boolean create(T dto);
    public boolean update(T dto);
    public boolean delete(int id);

}
