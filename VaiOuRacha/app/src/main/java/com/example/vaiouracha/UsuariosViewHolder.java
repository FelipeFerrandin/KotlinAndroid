package com.example.vaiouracha;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class UsuariosViewHolder extends RecyclerView.ViewHolder {
    private TextView textNomew;
    private TextView textSobrenome;
    private ConstraintLayout constraintLayout;

    public UsuariosViewHolder(@NonNull View itemView) {
        super(itemView);
        this.findUsefulComponents();
    }

    private void findUsefulComponents() {
        this.textNomew = itemView.findViewById(R.id.textViewNome);
        this.textSobrenome = itemView.findViewById(R.id.textViewSobrenome);
        this.constraintLayout = itemView.findViewById(R.id.constraintListagem);
    }

    public void fill(UsuarioPOJO usuarioPOJO) {
        this.textNomew.setText(usuarioPOJO.nome);
        this.textSobrenome.setText(usuarioPOJO.sobrenome);
        this.decideItemRemove();
    }

    private void decideItemRemove(){
        this.constraintLayout.setOnLongClickListener(v -> {
            DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        // TODO: 03/11/2020 Implementar exclusão
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            builder.setMessage("Deseja mesmo remover este item?").setPositiveButton("Sim", dialogClickListener)
                    .setNegativeButton("Não", dialogClickListener).show();
            return true;
        });
    }

}
