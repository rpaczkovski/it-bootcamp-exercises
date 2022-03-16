package application;

import application.views.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = Menu.getInstance();
        menu.execute();
    }
}
