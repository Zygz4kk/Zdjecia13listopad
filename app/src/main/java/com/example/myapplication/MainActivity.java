package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected static ArrayList<Integer> imageViewsArray;
    private Button buttonZo, buttonCz, buttonNa;
    private int ktoreZdjecie;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageView2 = findViewById(R.id.imageView3);
        buttonZo = findViewById(R.id.button);
        buttonCz = findViewById(R.id.button2);
        buttonNa = findViewById(R.id.button3);
        View widok = findViewById(R.id.main);
        listaAut();
        buttonNa.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ktoreZdjecie++;
                        if (ktoreZdjecie >= imageViewsArray.size()){
                            ktoreZdjecie = 0;
                        }
                        pokazAuta(ktoreZdjecie);
                    }
                }
        );
        buttonCz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        widok.setBackgroundColor(Color.BLACK);
                    }
                }
        );
        buttonZo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        widok.setBackgroundColor(Color.YELLOW);
                    }
                }
        );
    }
    private void listaAut(){
        imageViewsArray = new ArrayList<Integer>();
        imageViewsArray.add(R.drawable.a1);
        imageViewsArray.add(R.drawable.a2);
        imageViewsArray.add(R.drawable.a3);
        imageViewsArray.add(R.drawable.a4);
    }
    private void pokazAuta (int ktoreZdjecie){
        imageView2.setImageResource(imageViewsArray.get(ktoreZdjecie));
    }
}