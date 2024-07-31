import java.util.ArrayList;
import java.util.List;

interface Stock {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class StockExchange implements Stock {
    private List<Observer> observers;
    private double currentStockPrice;

    public StockExchange() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentStockPrice);
        }
    }

    public void updateStockPrice(double newStockPrice) {
        this.currentStockPrice = newStockPrice;
        notifyObservers();
    }
}

interface Observer {
    void update(double stockPrice);
}

class MobileNotification implements Observer {
    private String appName;

    public MobileNotification(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(appName + " received stock price update: " + stockPrice);
    }
}

class WebNotification implements Observer {
    private String appName;

    public WebNotification(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(appName + " received stock price update: " + stockPrice);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange();

        Observer mobileNotification = new MobileNotification("MobileApp");
        Observer webNotification = new WebNotification("WebApp");

        stockExchange.addObserver(mobileNotification);
        stockExchange.addObserver(webNotification);

        stockExchange.updateStockPrice(105.00);
        stockExchange.updateStockPrice(109.50);

        stockExchange.removeObserver(webNotification);
        stockExchange.updateStockPrice(102.50);
    }
}
