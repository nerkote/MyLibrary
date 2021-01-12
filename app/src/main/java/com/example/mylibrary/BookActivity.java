package com.example.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private static final String TAG = "BookActivity";
    private Util util = new Util();
    private TextView bookName, authorName, description, pageNumber;
    private ImageView bookImage;
    private Button btnCurentlyReadingB, btnWantToRead, btnAlreadyRead;

    private Book incomingBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        overridePendingTransition(R.anim.in, R.anim.out);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId", 0);

        ArrayList<Book> books = util.getAllBooks();

        for (Book b : books) {
            if (b.getId() == id) {

                incomingBook = b;
                bookName.setText(b.getBookName());
                authorName.setText(b.getAuthor());
                description.setText(b.getDescription());
                pageNumber.setText("Pages" + b.getNumberOfPages());
                Glide.with(this)
                        .asBitmap()
                        .load(b.getImageUrl())
                        .into(bookImage);
            }
        }

        btnCurentlyReadingB.setOnClickListener(view -> btnCurentlyReadingTapped());

        btnAlreadyRead.setOnClickListener(view -> btnAlreadyReadTapped());

        btnWantToRead.setOnClickListener(view -> btnWantToReadTapped());

    }


    private void btnWantToReadTapped() {
        Log.d(TAG, "btnWantToReadTapped: started");
        ArrayList<Book> wantToRead = util.getWantToReadBooks();

        if (wantToRead.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added this book to your want to read list");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

            });

            builder.setCancelable(false);
            builder.create().show();
        } else {

            ArrayList<Book> alreadyReadedBooks = util.getAlreadyReadBooks();
            if (alreadyReadedBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You already readed this book");
                builder.setTitle("Error");

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

                });

                builder.create().show();

            } else {
                ArrayList<Book> curentlyReadingBook = util.getCurentlyReadingBooks();

                if (curentlyReadingBook.contains(incomingBook)) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("You already reading this book");
                    builder.setTitle("Error");

                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

                    });

                    builder.create().show();

                } else {
                    util.addWantToReadBook(incomingBook);
                    Toast.makeText(this, "The book " + incomingBook.getBookName() + " added to your want to read list", Toast.LENGTH_SHORT).show();

                }

            }

        }

    }

    private void btnAlreadyReadTapped() {
        Log.d(TAG, "btnAlreadyReadTapped: started");

        ArrayList<Book> alreadyReadedBooks = util.getAlreadyReadBooks();

            if (alreadyReadedBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You already added this book to your already readed list");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

                });

                builder.create().show();
            } else {

                ArrayList<Book> curentlyReadingBooks = util.getCurentlyReadingBooks();
                if(curentlyReadingBooks.contains(incomingBook)) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Have you finish reading this book");
                    builder.setTitle("Error");
                    builder.setPositiveButton("Ok", (dialogInterface, i) -> {
                        util.removeCurentlyReadingBook(incomingBook);
                        util.addAlreadyReadingBook(incomingBook);
                        Toast.makeText(BookActivity.this, "The book " + incomingBook.getBookName() + " added to your already readed list", Toast.LENGTH_SHORT).show();


                    });

                    builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

                    });

                } else {
                    util.addAlreadyReadingBook(incomingBook);
                    Toast.makeText(this, "The book " + incomingBook.getBookName() + " added to your already readed list", Toast.LENGTH_SHORT).show();
                }
            }
        }



    private void btnCurentlyReadingTapped() {
        Log.d(TAG, "btnCurentlyReadingTapped: started");

        ArrayList<Book> curentlyReadingBooks = util.getCurentlyReadingBooks();

            if (curentlyReadingBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You already added this book to you curently reading list");
                builder.setPositiveButton("Ok", (dialogInterface, i) -> {

                });

                builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

                });

                builder.setCancelable(false);
                builder.create().show();
            } else {

                ArrayList<Book> wantToReadBook = util.getWantToReadBooks();

                if(wantToReadBook.contains(incomingBook)){

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Are you going to start reading this book?");
                    builder.setPositiveButton("Yes", (dialogInterface, i) -> {
                        util.removeWantToReadBook(incomingBook);
                        util.addCurentlyReadingBook(incomingBook);
                    });

                    builder.setNegativeButton("No", (dialogInterface, i) -> {
                        Toast.makeText(BookActivity.this, "The book " + incomingBook.getBookName() + " added to your currently reading shelf", Toast.LENGTH_SHORT).show();

                    });

                    builder.create().show();

                } else {
                    ArrayList<Book> alreadyReadedBooks = util.getAlreadyReadBooks();
                    if(alreadyReadedBooks.contains(incomingBook)) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage("Do you want to read it again?");
                        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
                            util.addCurentlyReadingBook(incomingBook);
                        });

                        builder.setNegativeButton("No", (dialogInterface, i) -> {
                            Toast.makeText(BookActivity.this, "The book " + incomingBook.getBookName() + " added to your currently reading shelf", Toast.LENGTH_SHORT).show();

                        });
                        builder.create().show();

                    } else {
                        util.addCurentlyReadingBook(incomingBook);
                        Toast.makeText(this, "The book " + incomingBook.getBookName() + " added to your currently reading shelf", Toast.LENGTH_SHORT).show();

                    }
                }

                 }
        }



    private void initWidgets() {
        bookName = findViewById(R.id.bookName);
        authorName = findViewById(R.id.authorName);
        description = findViewById(R.id.bookDesc);
        pageNumber = findViewById(R.id.bookPages);
        bookImage = findViewById(R.id.bookImage);

        btnCurentlyReadingB = findViewById(R.id.btnCurentlyReadingB);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }

}

