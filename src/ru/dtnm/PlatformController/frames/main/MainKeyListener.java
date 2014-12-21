package ru.dtnm.PlatformController.frames.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * <p>Description: </p>
 * <p>Copyright: (C) 2004-2014 ЗАО "КУБ"</p>
 *
 * @author Белолипов М.И.
 * @version 1.6.5
 */
public class MainKeyListener implements KeyListener {
    private static final int RAISE = 65;       // поднять, "a"
    private static final int LOWER = 90;       // опустить, "z"
    private static final int FORWARD = 38;     // вперёд, стрелка вверх
    private static final int BACK = 40;        // назад, стрелка вниз
    private static final int LEFT = 37;        // поворот влево, стрелка влево
    private static final int RIGHT = 39;       // поворот вправо, стрелка вправо

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case RAISE : raise(); break;
            case LOWER : lower(); break;
            case FORWARD : forward(); break;
            case BACK : back(); break;
            case LEFT : left(); break;
            case RIGHT : right(); break;
            default: System.out.println("type arrows or 'A' / 'Z'.");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    private static void raise () {
        System.out.println("raise");
    }

    private static void lower () {
        System.out.println("lower");
    }

    private static void forward () {
        System.out.println("forward");
    }

    private static void back () {
        System.out.println("backward");
    }

    private static void left () {
        System.out.println("left");
    }

    private static void right () {
        System.out.println("right");
    }
}
