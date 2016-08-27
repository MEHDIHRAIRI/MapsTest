package map;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

class Browser extends Region {

    private WebView browser = new WebView();
    WebEngine webEngine = browser.getEngine();

    Browser() {
        /*webEngine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(()-> {
                        String js = (String)webEngine.executeScript("document.goToLocation(\"" + "USA" + "\")");
                        System.out.println(js);
                    });
                }).start();
            }
        });*/

        //noinspection ConstantConditions
        webEngine.load(ClassLoader.getSystemClassLoader().getResource("resources/google.html").toExternalForm());
        //webEngine.load(ClassLoader.getSystemClassLoader().getResource("resources/bing.html").toExternalForm());
        getChildren().add(browser);

        JSObject jsobj = (JSObject) webEngine.executeScript("window");
        jsobj.setMember("java", new Bridge());
    }

    @Override
    protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
    }

    @Override
    protected double computePrefWidth(double height) {
        return 750;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 500;
    }
}
