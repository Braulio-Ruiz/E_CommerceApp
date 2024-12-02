package com.braulioruiz.e_commerceapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

/**
 * Actividad para que el usuario pueda contactar al operador enviando un
 * mensaje.
 */
public class ContactOperatorActivity extends AppCompatActivity {

    private TextInputEditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_operator);

        // Referencias a las vistas
        etMessage = findViewById(R.id.et_message);
        MaterialButton btnSendMessage = findViewById(R.id.btn_send_message);

        // Configuración del listener del botón
        btnSendMessage.setOnClickListener(v -> sendMessage());
    }

    /**
     * Método para manejar el envío del mensaje al operador.
     */
    private void sendMessage() {
        String message = etMessage.getText().toString().trim();

        if (TextUtils.isEmpty(message)) {
            // Mostrar error si el mensaje está vacío
            Toast.makeText(this, getString(R.string.error_message_empty), Toast.LENGTH_SHORT).show();
        } else {
            // Simulación de envío de mensaje exitoso
            Toast.makeText(this, getString(R.string.message_sent_success), Toast.LENGTH_SHORT).show();
            etMessage.setText(""); // Limpiar el campo de entrada
        }
    }
}
