package org.example;

class Library {
    private String name;

    public Library(String name) {
        this.name = name;
    }

    // Method to display library name
    public void displayLibrary() {
        System.out.println("Welcome to " + name + " Library!");
    }

    // Non-static inner class: Book
    class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        // Method to display book details
        public void displayBookInfo() {
            System.out.println("Book Title: " + title);
            System.out.println("Author: " + author);
        }
    }

    // Static nested class: LibraryAddress
    static class LibraryAddress {
        private String street;
        private String city;

        public LibraryAddress(String street, String city) {
            this.street = street;
            this.city = city;
        }

        // Method to display address information
        public void displayAddress() {
            System.out.println("Library Address: " + street + ", " + city);
        }
    }
}

