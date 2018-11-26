import java.util.*;

public class crawlReportClass {

    Hashtable successReport = new Hashtable();
    Hashtable duplicateReport = new Hashtable();
    Hashtable noPageReport = new Hashtable();
    Hashtable visitedPages = new Hashtable();
    int noPageCount = 0;
    int successCount = 0;
    int duplicateCount= 0;
    int visitedCount = 0;


    public void duplicateReport(String someLink) {
        duplicateCount++;
        duplicateReport.put(duplicateCount, someLink);
    }

    public void noPageReport(String someLink) {
        noPageCount++;
        noPageReport.put(noPageCount, someLink);
    }

    public void successReport(String someLink) {
        successCount++;
        successReport.put(successCount, someLink);
    }

    public void addToVisited(String someLink) {
        visitedCount++;
        visitedPages.put(visitedCount, someLink);
    }

    public void printReports() {

        System.out.println("Successful Crawls: ");
        System.out.println(successReport + "\n");

        System.out.println("Skipped: ");
        System.out.println(duplicateReport + "\n");

        System.out.println("Error: ");
        System.out.println(noPageReport + "\n");
    }

    crawlReportClass() {}

}
