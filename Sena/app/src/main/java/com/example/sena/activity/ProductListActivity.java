package com.example.sena.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import com.example.sena.R;
import com.example.sena.adapter.ProductAdapter;
import com.example.sena.model.Product;

public class ProductListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list); // Usaremos activity_product_list.xml

        recyclerView = findViewById(R.id.products_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 1. Crear la lista estática de productos
        List<Product> staticProducts = createStaticInventory();

        // 2. Inicializar y configurar el adaptador con la lista estática
        adapter = new ProductAdapter(staticProducts);
        recyclerView.setAdapter(adapter);
    }

    // Método para crear los productos de ejemplo
    private List<Product> createStaticInventory() {
        List<Product> products = new ArrayList<>();
        // Producto(id, nombre, precio, stock)
        products.add(new Product(101, "Leche Entera 1L", 1.85, 40));
        products.add(new Product(102, "Pan Integral", 2.50, 75));
        products.add(new Product(103, "Refresco Cola 2L", 3.25, 20));
        products.add(new Product(104, "Huevo x 12", 4.00, 15));
        products.add(new Product(105, "Manzanas kg", 1.99, 10)); // Stock bajo
        products.add(new Product(106, "Queso Fresco 500g", 5.50, 30));
        return products;
    }
}