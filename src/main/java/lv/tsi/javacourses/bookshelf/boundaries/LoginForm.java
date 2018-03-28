package lv.tsi.javacourses.bookshelf.boundaries;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.StringReader;
import java.util.Objects;

@RequestScoped
@Named
public class LoginForm {

    @PersistenceContext
    private EntityManager em;


    private String email;
    private String password;

    @Transactional
    public String LogIn() {
        Query e = em.createQuery("SELECT password FROM User  where password = :logpass");
        e.setParameter("logpass", password);
        e.getResultList();
        // if(Objects.equals((e.getResultList()), password){
        if (e.getResultList().isEmpty()) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage("Password incorect!!!"));

            return null;
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

