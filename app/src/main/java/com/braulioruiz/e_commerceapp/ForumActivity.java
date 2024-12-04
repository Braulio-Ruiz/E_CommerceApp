package com.braulioruiz.e_commerceapp;

import com.braulioruiz.e_commerceapp.adapters.ForumAdapter;
import com.braulioruiz.e_commerceapp.models.Question;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

/**
 * Actividad para mostrar y gestionar un foro de preguntas.
 */
public class ForumActivity extends AppCompatActivity {

    private List<Question> questions;
    private ForumAdapter questionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        // Inicializar lista de preguntas
        questions = new ArrayList<>();
        questions.add(new Question("¿Cuál es el tiempo de envío?", "Usuario1", "Envíos", System.currentTimeMillis()));
        questions.add(new Question("¿Tienen devoluciones?", "Usuario2", "Devoluciones", System.currentTimeMillis()));

        // Configurar RecyclerView
        RecyclerView rvQuestions = findViewById(R.id.rv_questions);
        rvQuestions.setLayoutManager(new LinearLayoutManager(this));
        questionAdapter = new ForumAdapter(questions);
        rvQuestions.setAdapter(questionAdapter);

        // Configurar botón de agregar pregunta
        MaterialButton btnAddQuestion = findViewById(R.id.btn_add_question);
        btnAddQuestion.setOnClickListener(v -> showAddQuestionDialog());
    }

    /**
     * Mostrar un cuadro de diálogo para agregar una nueva pregunta.
     */
    private void showAddQuestionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.add_question_title));

        // Configurar el diseño del cuadro de diálogo
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_question, null);
        builder.setView(dialogView);

        EditText etQuestion = dialogView.findViewById(R.id.et_question);

        builder.setPositiveButton(getString(R.string.add), (dialog, which) -> {
            String questionText = etQuestion.getText().toString().trim();
            if (!questionText.isEmpty()) {
                // Aquí, ahora se deben pasar los nuevos parámetros: categoría y timestamp
                questions.add(new Question(questionText, "Usuario Anónimo", "General", System.currentTimeMillis()));
                questionAdapter.notifyItemInserted(questions.size() - 1);
            }
        });

        builder.setNegativeButton(getString(R.string.cancel), (dialog, which) -> dialog.dismiss());

        builder.create().show();
    }
}
