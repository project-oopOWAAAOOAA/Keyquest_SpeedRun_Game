package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("2D Adventure");

    Gamepanel gamepanel= new Gamepanel();
    window.add(gamepanel);

    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gamepanel.setupGame();
    gamepanel.startGameThread();

    }
}