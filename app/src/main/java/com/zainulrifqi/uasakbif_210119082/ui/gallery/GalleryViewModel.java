package com.zainulrifqi.uasakbif_210119082.ui.gallery;

// NIM   : 10119082
// Nama  : Zainul Rifqi Muwaffaq
// Kelas : IF2

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}