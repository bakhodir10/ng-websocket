package uz.unicon.websocket_demo.base;


public interface BaseService<T> {
    T create(T entity);
}
