package com.stefan;

import java.util.Date;


public class Borrow {

    Book book;
    Customer customer;
    Date dateOfBorrowing;
    Date dateOfBookReturn;


    public Borrow(Book book, Customer customer, Date dateOfBorrowing, Date dateOfBookReturn) {
        this.book = book;
        this.customer = customer;
        this.dateOfBorrowing = dateOfBorrowing;
        this.dateOfBookReturn = dateOfBookReturn;
    }



    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateOfBorrowing() {
        return dateOfBorrowing;
    }

    public void setDateOfBorrowing(Date dateOfBorrowing) {
        this.dateOfBorrowing = dateOfBorrowing;
    }

    public Date getDateOfBookReturn() {
        return dateOfBookReturn;
    }

    public void setDateOfBookReturn(Date dateOfBookReturn) {
        this.dateOfBookReturn = dateOfBookReturn;
    }
}
