package lv.tsi.javacourses.bookshelf.boundaries;

import lv.tsi.javacourses.bookshelf.controle.UserControl;
import lv.tsi.javacourses.bookshelf.controle.Util;
import lv.tsi.javacourses.bookshelf.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.io.StringReader;
import java.util.Objects;

@ViewScoped
@Named
public class LoginForm implements Serializable{
    private static final Logger logger = LoggerFactory.getLogger(LoginForm.class);
    @Inject
    private UserControl userControl;
    @Inject
    private CurrentUser currentUser;
    @Inject
    private HttpServletRequest request;

    private String email;
    private String password;

    @Transactional
    public String login() {
        User user = userControl.findUserByEmail(email, true);
        if (user == null) {
            Util.addError("login:email", "Unknown email");
            return null;
        }
        try {
            request.login(email, password);
            currentUser.setSignedInUser(user);
            logger.debug("User {} is signed in", user);
            return "/user-space/mybook.xhtml?faces-reditect=true";
        } catch (ServletException e) {
            logger.error("Sign in error", e);
            Util.addError("login:password", "Wrong password");

        }
        return null;
    }

    public String signOut() {
        try {
            request.logout();
            currentUser.setSignedInUser(null);
        } catch (ServletException e) {
            logger.error("Sign out error", e);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

