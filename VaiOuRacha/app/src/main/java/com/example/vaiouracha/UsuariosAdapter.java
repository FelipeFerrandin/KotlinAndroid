package com.example.vaiouracha;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosViewHolder> {
    private List<UsuarioPOJO> usuarios;

    public UsuariosAdapter(List<UsuarioPOJO> usuarios) {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_listagem, parent, false);
        return new UsuariosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosViewHolder holder, int position) {
        holder.fill(usuarios.get(position));
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}
