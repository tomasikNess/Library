package com.stefan;

public class Customer {
    String firstname;
    String lastname;
    Address adress;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }



    public Customer(String firstname, String lastname, Address adress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.adress = adress;
    }




    public static class Address {

        String street;
        Integer streetNumber;
        String city;
        String country;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public Integer getStreetNumber() {
            return streetNumber;
        }

        public void setStreetNumber(Integer streetNumber) {
            this.streetNumber = streetNumber;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }



        public Address(String street, Integer streetNumber, String city, String country) {
            this.street = street;
            this.streetNumber = streetNumber;
            this.city = city;
            this.country = country;
        }




    }

}
