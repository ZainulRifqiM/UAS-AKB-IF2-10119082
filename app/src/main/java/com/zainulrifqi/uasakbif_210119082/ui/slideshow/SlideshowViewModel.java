package com.zainulrifqi.uasakbif_210119082.ui.slideshow;

// NIM   : 10119082
// Nama  : Zainul Rifqi Muwaffaq
// Kelas : IF2

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}