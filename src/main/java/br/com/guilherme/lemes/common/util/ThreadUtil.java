package br.com.guilherme.lemes.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadUtil {
    static int scheduledCount = 0;

        private static ExecutorService executorService = Executors
            .newCachedThreadPool();

        private static ScheduledExecutorService scheduledExecutorService = Executors
            .newScheduledThreadPool(5);

        private static ExecutorService singleThreadExecutorService = Executors.newSingleThreadExecutor();

    public static void run(Runnable runnable) {
        run(false, runnable);
    }

    public static void run(boolean runInSequence, Runnable runnable) {
        if (runInSequence)
            singleThreadExecutorService.execute(runnable);
        else
            executorService.execute(runnable);
    }

    public static void scheduleWithFixedDelay(Runnable runnable, int milis) {
        scheduledExecutorService.scheduleWithFixedDelay(runnable, milis,
                milis, TimeUnit.MILLISECONDS);
        scheduledCount++;
    }

    public static void scheduleAtFixedDelay(Runnable runnable, int milis) {
        scheduledExecutorService.scheduleAtFixedRate(runnable, milis,
                milis, TimeUnit.MILLISECONDS);
        scheduledCount++;
    }

    public static void clear() {
        executorService.shutdownNow();
        executorService = Executors.newCachedThreadPool();

        scheduledCount = 0;
        scheduledExecutorService.shutdownNow();
        scheduledExecutorService = Executors
                .newScheduledThreadPool(100);
    }
}
