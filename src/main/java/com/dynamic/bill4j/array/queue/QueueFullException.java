package com.dynamic.bill4j.array.queue;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/11
 */
public class QueueFullException extends RuntimeException {
    public QueueFullException(String s) {
        super(s);
    }
}
