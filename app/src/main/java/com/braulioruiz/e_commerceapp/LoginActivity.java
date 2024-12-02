package com.braulioruiz.e_commerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

/**
 * Actividad para manejar el inicio de sesión.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Referencias a los campos de entrada
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        // Botón de inicio de sesión
        MaterialButton btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(v -> handleLogin());
    }

    /**
     * Método que valida las credenciales de inicio de sesión.
     */
    private void handleLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, getString(R.string.error_empty_fields), Toast.LENGTH_SHORT).show();
            return;
        }

        // Simulación de autenticación (email y contraseña predefinidos)
        if (email.equals("user@example.com") && password.equals("password123")) {
            Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_SHORT).show();
        }
    }
}
