package com.braulioruiz.e_commerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

/**
 * Actividad principal que actúa como punto de entrada de la aplicación.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los botones
        MaterialButton btnGenerateBudget = findViewById(R.id.btn_generate_budget);
        MaterialButton btnContactOperator = findViewById(R.id.btn_contact_operator);
        MaterialButton btnViewForum = findViewById(R.id.btn_view_forum);

        // Configuración de listeners para navegación
        btnGenerateBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BudgetActivity.class);
                startActivity(intent);
            }
        });

        btnContactOperator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactOperatorActivity.class);
                startActivity(intent);
            }
        });

        btnViewForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForumActivity.class);
                startActivity(intent);
            }
        });
    }
}
