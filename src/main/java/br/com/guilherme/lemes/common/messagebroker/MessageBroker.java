package br.com.guilherme.lemes.common.messagebroker;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MessageBroker {

        private static Map<Class<? extends Message>, List<WeakReference<MessageSubscriber<? extends Message>>>> topics = new HashMap<Class<? extends Message>, List<WeakReference<MessageSubscriber<? extends Message>>>>();

    @SuppressWarnings("unchecked")
    public static <T extends Message> void publish(T message) {
        if (!topics.containsKey(message.getClass()))
            return;

        List<WeakReference<MessageSubscriber<? extends Message>>> references = topics.get(message.getClass());

        for (WeakReference<MessageSubscriber<?>> reference : references) {
            MessageSubscriber<T> typedSubscriber = (MessageSubscriber<T>) reference.get();

            if (typedSubscriber == null)
                references.remove(reference);
            else
                typedSubscriber.messageReceived(message);
        }
    }

    public static synchronized void subscribe(Class<? extends Message> messageClass, MessageSubscriber<? extends Message> subscriber) {
        if (!topics.containsKey(messageClass)) {
            topics.put(messageClass, new LinkedList<WeakReference<MessageSubscriber<? extends Message>>>());
        }

        topics.get(messageClass).add(new WeakReference<MessageSubscriber<? extends Message>>(subscriber));
    }

    public static void clear() {
        topics.clear();
    }
}