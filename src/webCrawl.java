import com.google.gson.Gson;


public class webCrawl extends crawlReportClass implements Runnable { //implements Runnable

    String jsonPage = "{\n" +
            "  \"pages\":[\n" +
            "    {\n" +
            "      \"address\":\"http://foo.bar.com/p1\",\n" +
            "      \"links\":[\n" +
            "        \"http://foo.bar.com/p2\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"address\":\"http://foo.bar.com/p2\",\n" +
            "      \"links\":[\n" +
            "        \"http://foo.bar.com/p3\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"address\":\"http://foo.bar.com/p3\",\n" +
            "      \"links\":[\n" +
            "        \"http://foo.bar.com/p4\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"address\":\"http://foo.bar.com/p4\",\n" +
            "      \"links\":[\n" +
            "        \"http://foo.bar.com/p5\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"address\":\"http://foo.bar.com/p5\",\n" +
            "      \"links\":[\n" +
            "        \"http://foo.bar.com/p1\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"address\":\"http://foo.bar.com/p6\",\n" +
            "      \"links\":[\n" +
            "        \"http://foo.bar.com/p1\"\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    Pages testPage = new Gson().fromJson(jsonPage, Pages.class);
    Thread crawlThread = new Thread();

    public void run() {
        startCrawl();
    }

    void startCrawl() {

        crawlLink(testPage.pages.get(0).address);

        printReports();
    }
    void crawlLink(String someAddress) {

        if (visitedPages.containsValue(someAddress) && !duplicateReport.containsValue(someAddress)) {

            duplicateReport(someAddress);

        } else if (!visitedPages.containsValue(someAddress) && !searchForAddress(someAddress)) {

            noPageReport(someAddress);

        } else if (!visitedPages.containsValue(someAddress)) {

            successReport(someAddress);
            addToVisited(someAddress);

            //links

            int h = getPage(someAddress);

            if (h > -1) {
                for (int i = 0; i < testPage.pages.get(h).links.size(); i++) {
                    String newCrawl = testPage.pages.get(h).links.get(i);
                    crawlLink(newCrawl);
                }
            } else if (!noPageReport.containsValue(someAddress)) {
                noPageReport(someAddress);

            }
        }
    }

    boolean searchForAddress(String searchAddress) {

        for (int i = 0; i < testPage.pages.size(); i++) { //for each address in page list
            if (searchAddress.equals(testPage.pages.get(i).address)) {
                return true;
            }
        }
        return false;
    }

    int getPage(String address){

        for (int i = 0; i < testPage.pages.size(); i++) {

            if (address.equals(testPage.pages.get(i).address)) {
                return i;
            }
        }
        int fail = -1;
        return fail;
    }


    webCrawl () {

    }
}
