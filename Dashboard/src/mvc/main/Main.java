package mvc.main;

import mvc.controller.DashController;

public class Main {

    static DashController controller;

    /**
     * Diese Klasse wird nur dazu benutzt alle nötigen
     * Komponenten zu Initialisieren und die erste
     * View anzuzeigen
     */
    public static void main(String [] args){
        controller = new DashController();

        controller.showView();
    }
}
