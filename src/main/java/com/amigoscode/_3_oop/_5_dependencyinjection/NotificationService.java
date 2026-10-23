package com.amigoscode._3_oop._5_dependencyinjection;

import javax.swing.*;

/**
 * Exercise: Dependency Injection - Notification Service
 *
 * Build a notification system where the NotificationService does NOT
 * create its own dependencies. Instead, it receives them through its
 * constructor (constructor injection). This makes the code flexible,
 * testable, and follows the Dependency Inversion Principle.
 *
 * Key concepts:
 * - Defining an interface for the dependency
 * - Constructor injection (passing dependencies via constructor)
 * - Swapping implementations without changing the dependent class
 * - Programming to an interface
 */

// TODO: 1 - Create a MessageSender interface with a single method:
//   void send(String to, String message)
interface MessageSender{
    void send(String to, String message);
}

// TODO: 2 - Create an EmailSender class that implements MessageSender.
//   Implement send() to print:
//   "[Email] Sending to <to>: <message>"
class EmailSender implements MessageSender{

    @Override
    public void send(String to, String message) {
        System.out.printf("[Email] Sending to %s: %s%n", to, message);
    }
}

// TODO: 3 - Create an SmsSender class that implements MessageSender.
//   Implement send() to print:
//   "[SMS] Sending to <to>: <message>"
class SmsSender implements MessageSender{

    @Override
    public void send(String to, String message) {
        System.out.printf("[SMS] Sending to %s: %s%n", to, message);
    }
}

// TODO: 4 - Create the NotificationService class.
//   - Add a private final field: messageSender (MessageSender)
//   - Create a constructor that takes a MessageSender parameter
//     and assigns it to the field. This is constructor injection —
//     the dependency is provided from outside, not created inside.
class NotificationService{
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
    void sendNotification(String to, String message){
        this.messageSender.send(to, message);
    }
}

// TODO: 5 - In NotificationService, add a method:
//   void sendNotification(String to, String message)
//   This method should delegate to messageSender.send(to, message).
//   NotificationService does NOT know whether it is using email or SMS.


class NotificationDemo {
    public static void main(String[] args) {
        // TODO: 6 - Create a NotificationService with an EmailSender.
        //   Call sendNotification("alice@example.com", "Hello via email!").
        //   Then create ANOTHER NotificationService with an SmsSender.
        //   Call sendNotification("+1234567890", "Hello via SMS!").
        NotificationService notificationService1 = new NotificationService(new EmailSender());
        notificationService1.sendNotification("alice@example.com", "Hello via email");

        NotificationService notificationService2= new NotificationService(new SmsSender());
        notificationService2.sendNotification("+123456789", "Hello via SMS");

        // TODO: 7 - Demonstrate swapping implementations:
        //   Create a MessageSender variable, assign EmailSender to it,
        //   pass it to NotificationService and send a message.
        //   Then reassign the variable to SmsSender,
        //   create a new NotificationService and send a message.
        //   Notice how NotificationService code never changed —
        //   only the injected dependency changed.
        MessageSender sender = new EmailSender();
        NotificationService notificationService3 = new NotificationService(sender);
        notificationService3.sendNotification("email@email.com","Swapping implementations part 1");
        sender = new SmsSender();
        notificationService3 = new NotificationService(sender);
        notificationService3.sendNotification("+15626516271","Swapping implementations part 2");

    }
}
