package com.stefan;

public class ScientificBook  extends  Book{
    String field;


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }



    public ScientificBook(String name, String author, Integer numberOfpages, String field) {
        super(name, author, numberOfpages);
        this.field=field;
    }
}
