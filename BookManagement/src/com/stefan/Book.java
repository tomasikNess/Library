package com.stefan;

public class Book {
    String  name;
    String author;
    Integer numberOfpages;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumberOfpages() {
        return numberOfpages;
    }

    public void setNumberOfpages(Integer numberOfpages) {
        this.numberOfpages = numberOfpages;
    }





    public Book(String name, String author, Integer numberOfpages) {
        this.name = name;
        this.author = author;
        this.numberOfpages = numberOfpages;
    }





}
