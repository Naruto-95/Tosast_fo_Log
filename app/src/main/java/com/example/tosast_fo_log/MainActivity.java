package com.example.tosast_fo_log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView2 = findViewById(R.id.textView2);
        Button butlog2 = findViewById(R.id.button2);
        butlog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo(textView2.getText().toString(),butlog2);//Вывод тоста текст приложения
                //Это кнопка номер 2. отображает текст приложение


            }
        });
    }
    private void ShowAlert(String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Подказка")//Главна надпись на подсказке
                .setMessage(text)//Сам текс в подсказке
                .setCancelable(false)//нельзя скрыть подсказку или tru
                .setPositiveButton("ДА", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();//нажатие,значит выход из приложения
            }
        })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();//нажатие,значит подсказка закроется
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();//Для отображения
    }

    // метод который показывает в тостах название кнопок 1 и 3
    public void btnClick(View v){
        showInfo(((Button) v).getText().toString(),((Button) v));
        ShowAlert("Вы хотите закрыть приложение?");

    }
    //Сам тосто(метод)
    private void showInfo(String text, Button btn) {
        btn.setText("Уже нажали");//При нажатии меняется текст
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));//При нажатии меняется цвет кнопки
        btn.setTextColor(Color.RED);//При нажатии меняется цвет текста
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}