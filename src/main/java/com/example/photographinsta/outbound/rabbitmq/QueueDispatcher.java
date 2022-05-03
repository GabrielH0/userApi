package com.example.photographinsta.outbound.rabbitmq;

public interface QueueDispatcher<T> {

    void send(T object);
}
