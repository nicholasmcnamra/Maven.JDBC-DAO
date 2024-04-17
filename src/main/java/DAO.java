public interface DAO<T> {

    public T findById(int id);
    public T findAll();
    public T create(T dto);
    public T update(T dto);
    public T delete(int id);

}
