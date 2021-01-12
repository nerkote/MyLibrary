package com.example.mylibrary;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Util {
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> curentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;

    private static int id = 0;

    public Util() {
        if(allBooks == null){
            allBooks = new ArrayList<>();
            initAllBooks();
        }

        if(curentlyReadingBooks == null){
            curentlyReadingBooks = new ArrayList<>();
        }

        if(wantToReadBooks == null){
            wantToReadBooks = new ArrayList<>();
        }

        if(alreadyReadBooks == null){
            alreadyReadBooks = new ArrayList<>();
        }
    }



    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurentlyReadingBooks() {
        return curentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public boolean addCurentlyReadingBook(Book book) {
       return curentlyReadingBooks.add(book);

    }

    public boolean addWantToReadBook(Book book) {
        return wantToReadBooks.add(book);

    }

    public boolean addAlreadyReadingBook(Book book) {
        return alreadyReadBooks.add(book);

    }

    public boolean removeCurentlyReadingBook(Book book) {
        return curentlyReadingBooks.remove(book);
    }

    public boolean removeWantToReadBook(Book book) {
        return wantToReadBooks.remove(book);
    }

    public boolean removeAlreadyReadBook(Book book) {
        return alreadyReadBooks.remove(book);
    }

    private static void initAllBooks() {
        String name;
        String author;
        int pages = 0;
        String imageUrl = "";
        String description;

        id++;

        name = "Pride and Prejudice";
        author = "Jane Austen";
        pages = 279;
        imageUrl= "https://images-na.ssl-images-amazon.com/images/I/41fCKej5blL._SX331_BO1,204,203,200_.jpg";
        description = "Really good book about pride and prejudice";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        name = "Pride and Prejudice";
        author = "Jane Austen";
        pages = 279;
        imageUrl= "https://images-na.ssl-images-amazon.com/images/I/41fCKej5blL._SX331_BO1,204,203,200_.jpg";
        description = "Really good book about pride and prejudice";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        name = "Pride and Prejudice";
        author = "Jane Austen";
        pages = 279;
        imageUrl= "https://images-na.ssl-images-amazon.com/images/I/41fCKej5blL._SX331_BO1,204,203,200_.jpg";
        description = "Really good book about pride and prejudice";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        name = "Pride and Prejudice";
        author = "Jane Austen";
        pages = 279;
        imageUrl= "https://images-na.ssl-images-amazon.com/images/I/41fCKej5blL._SX331_BO1,204,203,200_.jpg";
        description = "Really good book about pride and prejudice";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        name = "Pride and Prejudice";
        author = "Jane Austen";
        pages = 279;
        imageUrl= "https://images-na.ssl-images-amazon.com/images/I/41fCKej5blL._SX331_BO1,204,203,200_.jpg";
        description = "Really good book about pride and prejudice";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));

        name = "Pride and Prejudice";
        author = "Jane Austen";
        pages = 279;
        imageUrl= "https://images-na.ssl-images-amazon.com/images/I/41fCKej5blL._SX331_BO1,204,203,200_.jpg";
        description = "Really good book about pride and prejudice";
        allBooks.add(new Book(id, name, author, pages, imageUrl, description));



    }





}
