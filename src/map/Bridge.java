package map;


public class Bridge {
    @SuppressWarnings("unused")
    public void println(String msg) {
        System.out.println("msg from js: " + msg);
    }

    @SuppressWarnings("unused")
    public void clickMap(double lat, double lng) {
        System.out.println("from js lat:" + lat + " lng:" + lng + ", adding marker");
        Main.browser.webEngine.executeScript("document.addMarker(" + lat + ", " + lng + ")");
    }
}
