package br.com.guilherme.lemes.common.messagebroker;

public interface MessageSubscriber<T extends Message> {

    void messageReceived(T message);
}
