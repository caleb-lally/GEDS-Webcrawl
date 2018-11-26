


public class Main {

    public static void main(String[] args) {

        webCrawl wC = new webCrawl();
        wC.startCrawl();
        wC.crawlThread.run();
        System.out.println("All is finished!");

    }

}
