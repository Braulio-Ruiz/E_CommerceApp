package com.braulioruiz.e_commerceapp.adapters;

import com.braulioruiz.e_commerceapp.R;
import com.braulioruiz.e_commerceapp.models.Question;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Adaptador para manejar la lista de preguntas en el foro.
 */
public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.QuestionViewHolder> {

    private final List<Question> questions;

    public ForumAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.tvQuestionText.setText(question.getQuestionText());
        holder.tvAskedBy.setText(question.getAskedBy());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvQuestionText;
        private final TextView tvAskedBy;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestionText = itemView.findViewById(R.id.tv_question_text);
            tvAskedBy = itemView.findViewById(R.id.tv_asked_by);
        }
    }
}
