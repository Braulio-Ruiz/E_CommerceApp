package com.braulioruiz.e_commerceapp;

import com.braulioruiz.e_commerceapp.adapters.ProductAdapter;
import com.braulioruiz.e_commerceapp.models.Product;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Actividad para calcular el presupuesto total basado en la cantidad y precio
 * de los productos.
 */
public class BudgetActivity extends AppCompatActivity {

    private TextInputEditText etProductQuantity, etProductPrice;
    private TextView tvBudgetResult;
    private RecyclerView rvProducts;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private List<Product> selectedProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        // Inicialización de vistas
        etProductQuantity = findViewById(R.id.et_product_quantity);
        etProductPrice = findViewById(R.id.et_product_price);
        tvBudgetResult = findViewById(R.id.tv_budget_result);
        MaterialButton btnCalculateBudget = findViewById(R.id.btn_calculate_budget);
        rvProducts = findViewById(R.id.rv_products);

        // Lista de productos de ejemplo
        productList = new ArrayList<>();
        productList.add(new Product("Producto 1", 10.0));
        productList.add(new Product("Producto 2", 20.0));
        productList.add(new Product("Producto 3", 15.0));
        productList.add(new Product("Producto 4", 30.0));
        productList.add(new Product("Producto 5", 20.0));
        productList.add(new Product("Producto 6", 15.0));
        productList.add(new Product("Producto 7", 10.0));
        productList.add(new Product("Producto 8", 20.0));
        productList.add(new Product("Producto 9", 35.0));
        productList.add(new Product("Producto 10", 50.0));

        selectedProducts = new ArrayList<>();

        // Configurar RecyclerView
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new ProductAdapter(productList, new ProductAdapter.OnProductCheckedChangeListener() {
            @Override
            public void onProductCheckedChange(Product product, boolean isChecked) {
                if (isChecked) {
                    selectedProducts.add(product);
                } else {
                    selectedProducts.remove(product);
                }
                updateTotalBudget();
            }
        });
        rvProducts.setAdapter(productAdapter);

        // Configurar el listener del botón
        btnCalculateBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBudget();
            }
        });
    }

    /**
     * Método para calcular el presupuesto total y mostrarlo al usuario.
     */
    private void calculateBudget() {
        String quantityText = etProductQuantity.getText().toString().trim();
        String priceText = etProductPrice.getText().toString().trim();

        if (quantityText.isEmpty() || priceText.isEmpty()) {
            tvBudgetResult.setText(R.string.error_empty_fields);
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityText);
            double price = Double.parseDouble(priceText);
            double total = quantity * price;

            String result = getString(R.string.budget_total, total);
            tvBudgetResult.setText(result);
        } catch (NumberFormatException e) {
            tvBudgetResult.setText(R.string.error_invalid_input);
        }
    }

    /**
     * Método para actualizar el presupuesto total basado en los productos
     * seleccionados.
     */
    private void updateTotalBudget() {
        double total = 0;
        for (Product product : selectedProducts) {
            total += product.getPrice();
        }
        tvBudgetResult.setText(getString(R.string.budget_total, total));
    }
}
