package com.britishbroadcast.powerofrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BookAdapter.BookDelegate {


    private List<Book> library = new ArrayList<>(
            Arrays.asList(
                    new Book("The Revenge", "880088", 187, "Hannah Jayne", "https://images-na.ssl-images-amazon.com/images/I/915WgnGe5SL.jpg"),
                    new Book("The Lord Of The Rings", "770110", 1023, "J.R.R. Tolkien", "https://prodimage.images-bn.com/pimages/9780358380238_p0_v2_s550x406.jpg"),
                    new Book("The Da Vinci Code", "452910", 1523, "Dan Brown", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1361293878l/4248.jpg"),
                    new Book("Meditations", "823418", 302, "Marcus Aurelius", "https://images-na.ssl-images-amazon.com/images/I/51cQEdN9KuL._SX331_BO1,204,203,200_.jpg"),
                    new Book("Hawaii 5-0", "28280", 321, "R. Sidney Bowen", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1248401291l/6512662.jpg"),
                    new Book("Harry Potter & The Philosopher's Stone", "220221", 632, "J.K. Rowling", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1248401291l/6512662.jpg"),
                    new Book("Green Lights", "279211", 632, "Matthew Mac..", ""),
                    new Book("The Lord Of The Rings", "770110", 1023, "J.R.R. Tolkien", "https://prodimage.images-bn.com/pimages/9780358380238_p0_v2_s550x406.jpg"),
                    new Book("The Da Vinci Code", "452910", 1523, "Dan Brown", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1361293878l/4248.jpg"),
                    new Book("Meditations", "823418", 302, "Marcus Aurelius", "https://images-na.ssl-images-amazon.com/images/I/51cQEdN9KuL._SX331_BO1,204,203,200_.jpg"),
                    new Book("Hawaii 5-0", "28280", 321, "R. Sidney Bowen", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1248401291l/6512662.jpg"),
                    new Book("Harry Potter & The Philosopher's Stone", "220221", 632, "J.K. Rowling", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1248401291l/6512662.jpg"),
                    new Book("Green Lights", "279211", 632, "Matthew Mac..", ""),
                    new Book("The Lord Of The Rings", "770110", 1023, "J.R.R. Tolkien", "https://prodimage.images-bn.com/pimages/9780358380238_p0_v2_s550x406.jpg"),
                    new Book("The Da Vinci Code", "452910", 1523, "Dan Brown", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1361293878l/4248.jpg"),
                    new Book("Meditations", "823418", 302, "Marcus Aurelius", "https://images-na.ssl-images-amazon.com/images/I/51cQEdN9KuL._SX331_BO1,204,203,200_.jpg"),
                    new Book("Hawaii 5-0", "28280", 321, "R. Sidney Bowen", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1248401291l/6512662.jpg"),
                    new Book("Harry Potter & The Philosopher's Stone", "220221", 632, "J.K. Rowling", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1248401291l/6512662.jpg"),
                    new Book("Green Lights", "279211", 632, "Matthew Mac..", "")
                    ,new Book("The Lord Of The Rings", "770110", 1023, "J.R.R. Tolkien", "https://prodimage.images-bn.com/pimages/9780358380238_p0_v2_s550x406.jpg"),
                    new Book("The Da Vinci Code", "452910", 1523, "Dan Brown", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1361293878l/4248.jpg"),
                    new Book("Meditations", "823418", 302, "Marcus Aurelius", "https://images-na.ssl-images-amazon.com/images/I/51cQEdN9KuL._SX331_BO1,204,203,200_.jpg"),
                    new Book("Hawaii 5-0", "28280", 321, "R. Sidney Bowen", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1248401291l/6512662.jpg"),
                    new Book("Harry Potter & The Philosopher's Stone", "220221", 632, "J.K. Rowling", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1248401291l/6512662.jpg"),
                    new Book("Green Lights", "279211", 632, "Matthew Mac..", "")

            )
    );
    private BookAdapter bookAdapter = new BookAdapter(library, this);

    @BindView(R.id.main_reyclerview)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(bookAdapter);

        ItemTouchHelper touchHelper = new ItemTouchHelper(new BookTouchCallBack(bookAdapter));
        touchHelper.attachToRecyclerView(recyclerView);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

    }

    @Override
    public void readBook(Book book) {

    }
}