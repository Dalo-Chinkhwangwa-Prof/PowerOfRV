package com.britishbroadcast.powerofrv;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ablanco.zoomy.Zoomy;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> library;
    private BookDelegate bookDelegate;
    private Zoomy.Builder zoomBuilder;

    public BookAdapter(List<Book> library, BookDelegate bookDelegate) {
        this.library = library;
        this.bookDelegate = bookDelegate;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item_layout, parent, false);
        zoomBuilder = new Zoomy.Builder((Activity) parent.getContext());

        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        zoomBuilder.target(holder.coverImageView);
        zoomBuilder.register();


        Book currentBook = library.get(position);

        holder.authorTextView.setText(holder.itemView.getContext().getString(R.string.written_by, currentBook.getAuthor()));
        holder.isbnTextView.setText(holder.itemView.getContext().getString(R.string.isbn, currentBook.getIsbn()));
        holder.pagesTextView.setText(holder.itemView.getContext().getString(R.string.pages, currentBook.getPages()));
        holder.titleTextView.setText(currentBook.getTitle());

        Glide.with(holder.itemView)
                .setDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(currentBook.getCover())
                .placeholder(R.drawable.ic_book)
                .into(holder.coverImageView);

        holder.itemView.setOnClickListener(view -> {
            bookDelegate.readBook(currentBook);
        });

    }

    @Override
    public int getItemCount() {
        return library.size();
    }


    public interface BookDelegate {
        void readBook(Book book);
    }

    public void swapPositions(int from, int to){
        Book b1 = library.get(to);
        library.set(to, library.get(from));
        library.set(from, b1);
        notifyDataSetChanged();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.poster_imageview)
        public ImageView coverImageView;

        @BindView(R.id.title_textview)
        TextView titleTextView;

        @BindView(R.id.author_textview)
        TextView authorTextView;

        @BindView(R.id.isbn_textview)
        TextView isbnTextView;

        @BindView(R.id.pages_textview)
        TextView pagesTextView;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);//this is for any inflated views
        }
    }
}
