package ui;

import ui.controller.ChangePasswordController;
import ui.controller.DeleteButtonController;
import ui.controller.LogoutButtonController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MainScreen {
    private final JFrame frame;
    private final ArrayList users;
    private JLabel vorname;
    private JLabel nachname;
    private JLabel username;
    private JButton kennwortZuEandernButton;
    private JButton accountZuLoeschenButton;
    private JPanel acc;
    private JButton logoutButton;
    private Timer timer;


    public MainScreen(ArrayList users) {
        this.users = users;
        this.frame = new JFrame("User Manager - Main");
        this.frame.setContentPane(acc);
        this.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.frame.pack();
        this.frame.setVisible(true);
        ArrayList student = (ArrayList) this.users.get(0);
        vorname.setText((String) student.get(0));
        nachname.setText((String) student.get(1));
        username.setText((String) student.get(2));


        accountZuLoeschenButton.addActionListener(new DeleteButtonController(this));
        logoutButton.addActionListener(new LogoutButtonController(this));
        kennwortZuEandernButton.addActionListener(new ChangePasswordController(this));
        acc.addFocusListener(new FocusAdapter() {});
        addAutoCloseToFrame(frame);
    }

    private void addAutoCloseToFrame(JFrame frame) {
        // copyright start
        //http://www.java2s.com/Tutorials/Java/Swing_How_to/JFrame/Close_JFrame_after_user_inactivity.htm
        Toolkit.getDefaultToolkit().addAWTEventListener(
                new AWTEventListener() {
                    int count;
                    @Override
                    public void eventDispatched(AWTEvent event) {
                        Object source = event.getSource();
                        if (source instanceof Component) {
                            Component comp = (Component) source;
                            Window win = null;
                            if (comp instanceof Window) {
                                win = (Window) comp;
                            } else {
                                win = SwingUtilities.windowForComponent(comp);
                            }
                            if (win == frame) {
                                timer.restart();
                            }
                        }
                    }
                },
                AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK
                        | AWTEvent.MOUSE_MOTION_EVENT_MASK
                        | AWTEvent.MOUSE_WHEEL_EVENT_MASK);

        timer = new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        timer.start();
         // // copyright end
    }

    public JFrame getFrame() {
        return frame;
    }

    public ArrayList getUsers() {
        return users;
    }

    public JLabel getVorname() {
        return vorname;
    }

    public JLabel getNachname() {
        return nachname;
    }

    public JLabel getUsername() {
        return username;
    }

    public JButton getKennwortZuEandernButton() {
        return kennwortZuEandernButton;
    }

    public JButton getAccountZuLoeschenButton() {
        return accountZuLoeschenButton;
    }

    public JPanel getAcc() {
        return acc;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public Timer getTimer() {
        return timer;
    }
}
