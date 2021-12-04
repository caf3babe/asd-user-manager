package at.ac.fhcampuswien.usermanager.ui;

import at.ac.fhcampuswien.usermanager.UserManager;
import at.ac.fhcampuswien.usermanager.ui.controller.ChangePasswordController;
import at.ac.fhcampuswien.usermanager.ui.controller.DeleteButtonController;
import at.ac.fhcampuswien.usermanager.ui.controller.LogoutButtonController;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.util.ArrayList;

@Getter
@Setter
public class MainScreen {

    private final UserManager userManager;
    private final JFrame frame;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel username;
    private JButton changePasswordButton;
    private JButton deleteAccountButton;
    private JPanel panel;
    private JButton logoutButton;
    private Timer timer;


    public MainScreen(UserManager userManager) {
        this.userManager = userManager;
        this.frame = new JFrame("User Manager - Main");
        this.frame.setContentPane(panel);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(500, 500);
        this.frame.setLocationRelativeTo(this.frame);
        this.frame.setVisible(true);
        this.frame.pack();

        this.firstName.setText(this.userManager.getCurrentUser().getFirstName());
        this.lastName.setText(this.userManager.getCurrentUser().getLastName());
        this.username.setText(this.userManager.getCurrentUser().getUsername());

        deleteAccountButton.addActionListener(new DeleteButtonController(this));
        logoutButton.addActionListener(new LogoutButtonController(this));
        changePasswordButton.addActionListener(new ChangePasswordController(this));

        panel.addFocusListener(new FocusAdapter() {});

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
}
