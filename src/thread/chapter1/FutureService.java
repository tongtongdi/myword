package thread.chapter1;

import java.util.function.Consumer;

/**
 * @Description:
 * @Date: 2019/7/8
 * @Author 王通
 * @Version 1.0
 */

public class FutureService {
    public <T> Future<T> submit(final FutureTask<T> task) {
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
        }).start();
        return asynFuture;
    }

        public <T> Future<T> submit(final FutureTask<T> task, Consumer<T> consumer) {
            AsynFuture<T> asynFuture = new AsynFuture<>();
            new Thread(() -> {
                T result = task.call();
                asynFuture.done(result);
                consumer.accept(result);
            }).start();
            return asynFuture;
        }
}
