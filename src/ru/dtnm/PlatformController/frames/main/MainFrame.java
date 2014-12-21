package ru.dtnm.PlatformController.frames.main;

import ru.dtnm.PlatformController.frames.config.Config;

import javax.swing.*;
import java.io.OutputStream;

/**
 * <p>Главное окно приложения - реагирует на нажатия клавиш.. ну и всё.</p>
 * <p>Автор: maxie </p>
 * <p>Версия: 0.0.1 </p>
 */
public class MainFrame extends JFrame {

    private static MainFrame instance = null;
    private static OutputStream out = null;

    private MainFrame (OutputStream os) {
        super("Platform Controller " + Config.VERSION);
        out = os;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new MainFrameListener());
        addKeyListener(new MainKeyListener());
    }

    public static MainFrame getInstance (OutputStream out) {
        if (instance == null) instance = new MainFrame(out);
        return instance;
    }
}
