package lv.tsi.javacourses.bookshelf.boundaries;

import lv.tsi.javacourses.bookshelf.entities.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.StringReader;
import java.util.Objects;

@RequestScoped
@Named
public class LoginForm {
    @PersistenceContext
    private EntityManager em;
    @Inject
    private CurrentUser currentUser;

    private String email;
    private String password;

    @Transactional
    public String login() {
        TypedQuery<User> query = em.createQuery(
                "select u from User u where u.email = :email", User.class);
        query.setParameter("email", email);
        try {
            User u = query.getSingleResult();
            if (Objects.equals(u.getPassword(), password)) {
                currentUser.setSignedInUser(u);
                currentUser.setUserId(u.getId());
                return "/index.xhtml";
            } else {
                FacesContext.getCurrentInstance()
                        .addMessage("login:password", new FacesMessage("Incorect password"));
            }
        } catch (NoResultException e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage("Email is not registered"));
        }
        return null;
    }
    //return "/index.xhtml?faces-redirect=true";


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

