package com.example.fakeflix.Controllers;

import android.view.View;

import com.example.fakeflix.Models.Enums.Category;

import java.util.List;

public interface RecyclerViewOnClickListener {

    void onClickListener(View view, int positon, Category category);
}
