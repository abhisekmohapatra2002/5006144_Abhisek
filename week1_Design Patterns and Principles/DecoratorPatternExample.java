
public class DecoratorPatternExample {

    interface Notifier {
        void send(String message);
    }

    static class EmailNotifier implements Notifier {
        @Override
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }


    static abstract class NotifierDecorator implements Notifier {
        protected Notifier wrappedNotifier;

        public NotifierDecorator(Notifier notifier) {
            this.wrappedNotifier = notifier;
        }

        @Override
        public void send(String message) {
            wrappedNotifier.send(message);
        }
    }

    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendSMS(message);
        }

        private void sendSMS(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendSlack(message);
        }

        private void sendSlack(String message) {
            System.out.println("Sending Slack message: " + message);
        }
    }

    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("Hello, this is a test notification!");
    }
}

/*
output :-
------
Sending Email: Hello, this is a test notification!
Sending SMS: Hello, this is a test notification!
Sending Slack message: Hello, this is a test notification!

*/

