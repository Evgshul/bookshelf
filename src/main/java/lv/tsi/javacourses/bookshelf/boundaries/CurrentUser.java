package lv.tsi.javacourses.bookshelf.boundaries;


import lv.tsi.javacourses.bookshelf.entities.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class CurrentUser implements Serializable {
    private User signedInUser;

    public boolean isSignedIn() {
        return signedInUser != null;
    }

    public User getSignedInUser() {
        return signedInUser;
    }

    public void setSignedInUser(User signedInUser) {
        this.signedInUser = signedInUser;
    }
}
