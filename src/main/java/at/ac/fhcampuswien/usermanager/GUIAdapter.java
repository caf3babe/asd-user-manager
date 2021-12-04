package at.ac.fhcampuswien.usermanager;

import at.ac.fhcampuswien.usermanager.ui.LoginScreen;
import org.springframework.stereotype.Component;

@Component
public class GUIAdapter {
    private final UserManager userManager;

    public GUIAdapter(UserManager userManager) {
        this.userManager = userManager;
        new LoginScreen(userManager);
    }
}
