package thread.chapter1;

/**
 * @Description:
 * @Date: 2019/7/8
 * @Author 王通
 * @Version 1.0
 */

public interface Future<T> {
    T get() throws InterruptedException;
}
