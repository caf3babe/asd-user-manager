package core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.util.ArrayList;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Acc {
    private JLabel vorname;
    private JLabel nachname;
    private JLabel username;
    private JButton kennwortZuEandernButton;
    private JButton accountZuLoeschenButton;
    private JPanel acc;
    private JButton logoutButton;
    private Timer timer;


    public Acc(ArrayList students, int i, JFrame frame) {
        ArrayList student = (ArrayList) students.get(i);
        vorname.setText((String) student.get(0));
        nachname.setText((String) student.get(1));
        username.setText((String) student.get(2));

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
        kennwortZuEandernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewPassord.SavePasswordScreen(students, i);
            }
        }); // // copyright end


        accountZuLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Ja", "Nein"};
                int x = JOptionPane.showOptionDialog(null, "Wollen Sie den Account wirklich löschen",
                        "Click a button",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (x == 0){
                    students.remove(i);
                    frame.dispose();
                }

            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        acc.addFocusListener(new FocusAdapter() {
        });
    }
    public static void AccnScreen(ArrayList students, int i) {
        JFrame frame = new JFrame("Registration");
        frame.setContentPane(new Acc(students,i,frame).acc);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
