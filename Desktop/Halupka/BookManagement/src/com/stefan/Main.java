package com.stefan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;


public class Main {

    public static Integer volba;
    public static List<Book> books = new ArrayList<>();
    public static List<Customer> customers = new ArrayList<>();
    public static List<Borrow> borrows = new ArrayList<>();


    static Library library = new Library();


    public static void main(String[] args) throws Exception {


        do {
            System.out.println("Menu 1-add book 2-add customer 3-update customer address 4 - list of books" +
                    " 5- list of customers  6-borrow book 7-return book 8-end");

            Scanner scanner = new Scanner(System.in);
            volba = Integer.parseInt(scanner.nextLine());
            if (volba == 1) {

                library.addBook(scanner, books);
            }
            if (volba == 2) {
                Customer customer = library.addCustomer();
                customers.add(customer);
            }
            if (volba == 3) {
                library.printNameOfCustomer(customers);
                library.EditAdressOfCustomer(scanner, customers);
            }

            if (volba == 4) {

                for (int i = 0; i < books.size(); i++)
                    System.out.println(books.get(i).getName());
            }

            if (volba == 5) {
                for (int i = 0; i < customers.size(); i++)
                    System.out.println(customers.get(i).firstname + " " + customers.get(i).lastname + " " +
                            customers.get(i).adress.city + " " + customers.get(i).adress.country + " " + customers.get(i).adress.street);
            }

            if (volba == 6) {

              library.makeBorrow(borrows, books, customers, scanner);
            }

            if (volba == 7) {
                library.returnBook(borrows, customers, scanner);


            }

        }

        while (volba != 8);
    }





}



