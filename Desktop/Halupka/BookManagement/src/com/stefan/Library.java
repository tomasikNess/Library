package com.stefan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    static int indexCustomer = 0;
    public static LocalDate today = LocalDate.now();
    public static String formattedDate = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    public static Date date;
    public static Date date2 = java.util.Date.from(today.atStartOfDay().plusDays(30)
            .atZone(ZoneId.systemDefault())
            .toInstant());

    public Customer addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter firstname");
        String tempFirstName = scanner.nextLine();
        System.out.println("enter lastname");
        String tempLastName = scanner.nextLine();
        System.out.println("address");
        System.out.println("enter street");
        String tempStreet = scanner.nextLine();
        System.out.println("enter streetNumber");
        Integer tempStreetNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("enter city");
        String tempCity = scanner.nextLine();
        System.out.println("enter country");
        String tempCountry = scanner.nextLine();
        Customer customer = new Customer(tempFirstName, tempLastName, new Customer.Address(tempStreet,
                tempStreetNumber, tempCity, tempCountry));
        return customer;
    }

    public Customer findCustomer(List<Customer> customers, String tempName) {
        for (int i = 0; i < customers.size(); i++)
            if (tempName.equals(customers.get(i).getLastname())) indexCustomer = i;

        Customer selectedCustomer = customers.get(indexCustomer);
        return selectedCustomer;

    }


    public void EditAdressOfCustomer(Scanner scanner, List<Customer>customers) {


        System.out.println("Enter index (indexing is from 0) of customer which want you edit");
        int index = Integer.parseInt(scanner.nextLine());
        Customer tempCustomer = customers.get(index);
        System.out.println("Enter  new adress");
        System.out.println("enter street");
        String tempStreet = scanner.nextLine();
        System.out.println("enter streetNumber");
        Integer tempStreetNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("enter city");
        String tempCity = scanner.nextLine();
        System.out.println("enter country");
        String tempCountry = scanner.nextLine();
        tempCustomer = new Customer(tempCustomer.getFirstname(), tempCustomer.getLastname(),
                new Customer.Address(tempStreet, tempStreetNumber, tempCity, tempCountry));
        customers.add(index, tempCustomer);
    }

    public  void addBook(Scanner scanner, List<Book> books){

        System.out.println("Enter type of book, possible are Standard, Scientific, Foreign");
        String typeOfBook = scanner.nextLine();

        if (typeOfBook.equals("Standard")) {
            System.out.println("enter name");
            String tempName = scanner.nextLine();
            System.out.println("enter author");
            String tempAuthor = scanner.nextLine();
            System.out.println("enter numberofpages");
            Integer tempNumberOfpages = Integer.parseInt(scanner.nextLine());
            Book book = new Book(tempName, tempAuthor, tempNumberOfpages);
            books.add(book);
        }

        if (typeOfBook.equals("Scientific")) {

            System.out.println("enter name");
            String tempName = scanner.nextLine();
            System.out.println("enter author");
            String tempAuthor = scanner.nextLine();
            System.out.println("enter numberofpages");
            Integer tempNumberOfpages = Integer.parseInt(scanner.nextLine());
            System.out.println("enter Field");
            String tempField = scanner.nextLine();
            ScientificBook scientificBook = new ScientificBook(tempName, tempAuthor, tempNumberOfpages, tempField);
            books.add(scientificBook);
        }

        if (typeOfBook.equals("Foreign")) {
            System.out.println("enter name");
            String tempName = scanner.nextLine();
            System.out.println("enter author");
            String tempAuthor = scanner.nextLine();
            System.out.println("enter numberofpages");
            Integer tempNumberOfpages = Integer.
                    parseInt(scanner.nextLine());
            System.out.println("enter language");
            String tempLanguage = scanner.nextLine();
            ForeignBook foreignBook = new ForeignBook(tempName, tempAuthor, tempNumberOfpages, tempLanguage);
            books.add(foreignBook);
        }
    }


    public void returnBook(List<Borrow> borrows, List<Customer> customers, Scanner scanner){

        System.out.println("Returning books");
        System.out.println("Not returned books");
        for (int i = 0; i < borrows.size(); i++) System.out.println(borrows.get(i).book.getName());
        System.out.println("enter your lastname");
        String tempName = scanner.nextLine();
        Customer selectedCustomer = findCustomer(customers, tempName);
        if (selectedCustomer instanceof Customer) {
            for (int i = 0; i < borrows.size(); i++) System.out.println(borrows.get(i).book.getName());
            System.out.println("enter index of book, please enter index of book (indexing from 0)");
            int index = Integer.parseInt(scanner.nextLine());
            Book selectedBook = borrows.get(index).getBook();
            borrows.remove(selectedBook);
            System.out.println("Book was returned");
        }
    }

    public  void addBorrow(List<Book> books, List<Customer> customers, List<Borrow> borrows, Scanner
            scanner) throws ParseException {

        date = new SimpleDateFormat("dd/MM/yyyy").parse(formattedDate);

        if (books.size() <= 0) {
            System.out.println("no free books");
        }
        if (books.size() > 0) {
            int index;

            System.out.println("Borrowing books, Possible books: ");
            for (int i = 0; i < books.size(); i++) System.out.println(i + " " + books.get(i).name);


            System.out.println("enter your lastname");
            String tempName = scanner.nextLine();
            Customer selectedCustomer = findCustomer(customers, tempName);
            if (selectedCustomer instanceof Customer) {
                System.out.println("enter index of book, please enter index of book (indexing from 0)");
                index = Integer.parseInt(scanner.nextLine());

                Book selectedBook = books.get(index);
                Borrow borrow = new Borrow(selectedBook, selectedCustomer, date, date2);
                borrows.add(borrow);
                books.remove(selectedBook);

            } else System.out.println("no free books 2");

        } else System.out.println("error");

    }

    public  void printNameOfCustomer(List<Customer> customers) {
        for (int i = 0; i < customers.size(); i++)
            System.out.println(customers.get(i).lastname);
    }

    public  void printBorrowsBook(List<Borrow> borrows) {
        for (int i = 0; i < borrows.size(); i++)
            System.out.println("borrowed" + borrows.get(i).getBook().getName());
    }


    public void makeBorrow (List<Borrow> borrows,List<Book> books, List<Customer> customers, Scanner scanner) throws ParseException {
        List<Long> sublist = new ArrayList();
        Set<String> setOfNames = new HashSet();

        if (borrows.size() == 0) {
            addBorrow(books, customers, borrows, scanner);

            setOfNames.add(borrows.get(0).customer.getFirstname());

            sublist = getSublist(borrows);
            System.out.println("sub0" + sublist);


            for (int i = 0; i < sublist.size(); i++) {
                if ((sublist.get(i) == 3) && (setOfNames.size() == 1)) {
                    System.out.println("change customer");

                    break;
                }

                if ((sublist.get(i) >= 5) && (setOfNames.size() >= 2)) {
                    System.out.println("change customer");
                    break;
                }
            }


        } else {

            for (int d = 0; d < borrows.size(); d++)
                setOfNames.add(borrows.get(d).customer.getFirstname());
            sublist = getSublist(borrows);


            System.out.println("sub1" + sublist);
            int size = setOfNames.size();

            System.out.println("size" + size);

            for (int i = 0; i < sublist.size(); i++) {
                if ((sublist.get(i) == 3) && (setOfNames.size() == 1)) {
                    System.out.println("change customer");

                    break;
                }
                if ((sublist.get(i) >= 5) && (setOfNames.size() >= 2)) {
                    System.out.println("change customer");
                    break;
                } else
                    addBorrow(books, customers, borrows, scanner);
            }
        }}

    public static Map getMap(List<List<String>> duplicateList) {
        Map<String, Long> couterMap = duplicateList.stream().collect(Collectors.groupingBy(e -> e.toString(), Collectors.counting()));
        return couterMap;
    }


    public static List getSublist(List<Borrow>borrows) {
        List result = new ArrayList();
        List<List<String>> listOfAll = new ArrayList<List<String>>();
        List<String> setOfnames = new ArrayList<>();
        Map<String, Long> map;

        for (int d = 0; d < borrows.size(); d++) {
            setOfnames.add(borrows.get(d).customer.getFirstname());
            listOfAll.add(Arrays.asList(borrows.get(d).getBook().getName()));
            Collections.addAll(listOfAll, setOfnames);
            map = getMap(listOfAll);
            result = new ArrayList(map.values());
            Collections.sort(result, Collections.reverseOrder());
            System.out.println("list" + listOfAll);
        }
        listOfAll = listOfAll.stream().distinct().collect(Collectors.toList());
        System.out.println("after" + listOfAll);


        return Arrays.asList(result.get(0));

    }


}
