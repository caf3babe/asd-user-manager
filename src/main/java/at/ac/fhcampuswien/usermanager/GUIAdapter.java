package at.ac.fhcampuswien.usermanager;

import at.ac.fhcampuswien.usermanager.ui.LoginScreen;
import org.springframework.stereotype.Component;

@Component
public class GUIAdapter {

    public GUIAdapter(UserManager userManager) {
        new LoginScreen(userManager);
    }
}
