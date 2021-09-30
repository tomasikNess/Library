package com.stefan;

public class ForeignBook extends Book {

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    String language;


    public ForeignBook(String name, String author, Integer numberOfpages, String language) {
        super(name, author, numberOfpages);
        this.language=language;
    }
}
