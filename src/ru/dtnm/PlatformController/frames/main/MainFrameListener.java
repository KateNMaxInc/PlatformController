package ru.dtnm.PlatformController.frames.main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * <p>Description: </p>
 * <p>Copyright: (C) 2004-2014 ЗАО "КУБ"</p>
 *
 * @author Белолипов М.И.
 * @version 1.6.5
 */
public class MainFrameListener implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("trying to close window - need to close connections");
        Object[] options = { "Да", "Нет!" };
        int n = JOptionPane
                .showOptionDialog(e.getWindow(), "Закрыть окно?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
        if (n == 0) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
