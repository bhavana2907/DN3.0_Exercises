interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier baseNotifier;

    public NotifierDecorator(Notifier baseNotifier) {
        this.baseNotifier = baseNotifier;
    }

    public void send(String message) {
        baseNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier baseNotifier) {
        super(baseNotifier);
    }

    public void send(String message) {
        baseNotifier.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier baseNotifier) {
        super(baseNotifier);
    }

    public void send(String message) {
        baseNotifier.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack notification: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);
        slackNotifier.send("Hello, this is a test notification!");
    }
}
