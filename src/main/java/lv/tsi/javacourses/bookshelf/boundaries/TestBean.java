package lv.tsi.javacourses.bookshelf.boundaries;

import lv.tsi.javacourses.bookshelf.entities.Book;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class TestBean implements Serializable {
    @PersistenceContext
    private EntityManager em;

    private List<Book> books;
    private List<Integer> allYears;
    private Integer selectedYear;
    private Long bookId;

    public void loadBooks() {
        books = em.createQuery("select b from Book b")
                .getResultList();
        allYears=em.createQuery(" select distinct b.year " +
        "from Book b")
                .getResultList();
    }

    public void processBook() {
        Book selectBook = em.find(Book.class, bookId);
        System.out.println("Book selected: " + selectBook);
    }

    public void processBookYear(){
        System.out.println("Selected year: " + selectedYear);
    }

    public List<Integer> getAllYears() {
        return allYears;
    }

    public void setAllYears(List<Integer> allYears) {
        this.allYears = allYears;
    }

    public Integer getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(Integer selectedYear) {
        this.selectedYear = selectedYear;
    }



    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
