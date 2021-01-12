package com.example.mylibrary;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private static final String TAG = "AllBooksActivity";
    private RecyclerView booksRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        overridePendingTransition(R.anim.in, R.anim.out);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d(TAG, "onCreate: started");

        booksRecView = findViewById(R.id.booksRecView);

        BooksRecyclerViewAdapter adapter = new BooksRecyclerViewAdapter(this);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new GridLayoutManager(this, 2));


  /*      books.add(new Book("1Q84", "Haruki Mukrakami", 1350, "https://images-na.ssl-images-amazon.com/images/I/51wYhgDbDnL._SX329_BO1,204,203,200_.jpg", "Great book"));
        books.add(new Book("Iliad", "Homer", 1000, "https://images-na.ssl-images-amazon.com/images/I/61x6rNNMLeL._SX331_BO1,204,203,200_.jpg", "new book adadadasa"));
        books.add(new Book("Beyond good and evil", "Nietzsche", 213, "https://i.pinimg.com/originals/29/c9/96/29c99663b511c0feea319692382bbf08.jpg", "Also one great book from Nietzsche"));
*/


        Util util = new Util();
        ArrayList<Book> books = new ArrayList<>();
        books = util.getAllBooks();
        adapter.setBooks(books);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}