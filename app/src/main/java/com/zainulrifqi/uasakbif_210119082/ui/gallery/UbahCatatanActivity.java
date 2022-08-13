package com.zainulrifqi.uasakbif_210119082.ui.gallery;

// NIM   : 10119082
// Nama  : Zainul Rifqi Muwaffaq
// Kelas : IF2

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zainulrifqi.uasakbif_210119082.R;

public class UbahCatatanActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_catatan);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM catatan WHERE judul = '" +
                getIntent().getStringExtra("judul") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        btn1 = (Button) findViewById(R.id.button1);
//        btn2 = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update catatan set tanggal='"+
                        text2.getText().toString() +"', judul='" +
                        text3.getText().toString()+"', kategori='"+
                        text4.getText().toString() +"', isi='" +
                        text5.getText().toString() + "' where no='" +
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                GalleryFragment.gf.RefreshList();
                finish();
            }
        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // TODO Auto-generated method stub
//                finish();
//            }
//        });

    }
}