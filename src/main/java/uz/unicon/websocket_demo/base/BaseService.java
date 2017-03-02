package uz.unicon.websocket_demo.base;


public interface BaseService<T> {
    T save(T entity);
}
