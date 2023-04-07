package com.xfactor.openlibrary.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long bookid;

    @Column
    private Long studentid;

    @Column
    private String checkoutDate;

    @Column
    private String dueDate;

    @Column
    private String returnDate;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getBookid() {
        return bookid;
    }
    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }
    public Long getStudentid() {
        return studentid;
    }
    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }
    public String getCheckoutDate() {
        return checkoutDate;
    }
    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
