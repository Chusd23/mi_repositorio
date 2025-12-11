package com.example.sena.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.sena.R;
import com.example.sena.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    // 1. ViewHolder
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, priceTextView, stockTextView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            // Estos IDs vienen de item_product.xml
            nameTextView = itemView.findViewById(R.id.name_text);
            priceTextView = itemView.findViewById(R.id.price_text);
            stockTextView = itemView.findViewById(R.id.stock_text);
        }
    }

    // 2. Crea los ViewHolder
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    // 3. Vincula los datos
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);

        // Muestra Nombre, Precio y Stock
        holder.nameTextView.setText(product.getNombre());
        holder.priceTextView.setText(String.format("$%.2f", product.getPrecio()));
        holder.stockTextView.setText(String.valueOf(product.getStock()));

        // Opcional: Resaltar stock bajo (ej. stock < 10)
        if (product.getStock() < 10) {
            holder.stockTextView.setTextColor(holder.itemView.getContext().getResources().getColor(android.R.color.holo_red_dark));
        } else {
            holder.stockTextView.setTextColor(holder.itemView.getContext().getResources().getColor(android.R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    // Método para actualizar la lista (usado por LiveData)
    public void setProducts(List<Product> newProducts) {
        this.products = newProducts;
        notifyDataSetChanged();
    }
}
