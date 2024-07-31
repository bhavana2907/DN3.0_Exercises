interface Image {
    void display();
}

class RealImage implements Image {
    private String imageFilename;

    public RealImage(String imageFilename) {
        this.imageFilename = imageFilename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + imageFilename);
    }

    public void display() {
        System.out.println("Displaying image: " + imageFilename);
    }
}

class ProxyImage implements Image {
    private String imageFilename;
    private RealImage realImageInstance;

    public ProxyImage(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    public void display() {
        if (realImageInstance == null) {
            realImageInstance = new RealImage(imageFilename);
        }
        realImageInstance.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image proxyImage1 = new ProxyImage("image1.jpg");
        Image proxyImage2 = new ProxyImage("image2.jpg");

        proxyImage1.display();
        System.out.println("");

        proxyImage1.display();
        System.out.println("");

        proxyImage2.display();
        System.out.println("");

        proxyImage2.display();
    }
}
