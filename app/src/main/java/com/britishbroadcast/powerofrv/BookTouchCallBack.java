package com.britishbroadcast.powerofrv;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class BookTouchCallBack extends ItemTouchHelper.SimpleCallback {

    private BookAdapter bookAdapter;

    public BookTouchCallBack(BookAdapter bookAdapter) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN);
        this.bookAdapter = bookAdapter;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        if(direction == ItemTouchHelper.LEFT)
            Log.d("TAG_X", "Swiped...LEFT " );
        else if(direction == ItemTouchHelper.RIGHT)
            Log.d("TAG_X", "Swiped...RIGHT " );

//        int to = viewHolder.getAdapterPosition();
//        int from = viewHolder.getOldPosition();
        //Log.d("TAG_X", "from: "+from + " to: "+to );
        //bookAdapter.swapPositions(from, to);

    }
}
