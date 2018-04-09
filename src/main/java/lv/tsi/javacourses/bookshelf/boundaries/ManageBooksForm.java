package lv.tsi.javacourses.bookshelf.boundaries;

import lv.tsi.javacourses.bookshelf.entities.Book;
import lv.tsi.javacourses.bookshelf.entities.User;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class ManageBooksForm implements Serializable {
    @PersistenceContext
    private EntityManager em;

    private List<User> users;
    private User current;
    private List<Book> book;

    public void prepareUsers() {
        users = em.createQuery("select r.user from Reservation r " +
                "where r.status<> 'REALEASED'")
                .getResultList();
    }

    public void prepareBooks(User user) {

        //System.out.println("Clicked on user " + user.getId());
        book = em.createQuery("select distinct r.book from Reservation r " +
                "where r.user =:user")
                .setParameter("user", user)
                .getResultList();

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getCurrent() {
        return current;
    }

    public void setCurrent(User current) {
        this.current = current;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
