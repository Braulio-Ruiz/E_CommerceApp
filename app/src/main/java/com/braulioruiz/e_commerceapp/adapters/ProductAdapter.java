package com.braulioruiz.e_commerceapp.adapters;

import com.braulioruiz.e_commerceapp.R;
import com.braulioruiz.e_commerceapp.models.Product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Adaptador para manejar la lista de productos en un RecyclerView.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<Product> productList;
    private final OnProductCheckedChangeListener listener;

    /**
     * Interfaz para manejar el evento de selección de productos.
     */
    public interface OnProductCheckedChangeListener {
        void onProductCheckedChange(Product product, boolean isChecked);
    }

    public ProductAdapter(List<Product> productList, OnProductCheckedChangeListener listener) {
        this.productList = productList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    /**
     * Clase interna para el ViewHolder que representa cada producto.
     */
    class ProductViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvProductName;
        private final TextView tvProductPrice;
        private final CheckBox cbProduct;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.product_name);
            tvProductPrice = itemView.findViewById(R.id.product_price);
            cbProduct = itemView.findViewById(R.id.product_checkbox);
        }

        /**
         * Vincula los datos de un producto al ViewHolder.
         *
         * @param product El producto que se está vinculando.
         */
        public void bind(final Product product) {
            tvProductName.setText(product.getName());
            tvProductPrice.setText(String.format("$%.2f", product.getPrice()));
            cbProduct.setOnCheckedChangeListener(null); // Evitar conflictos

            cbProduct.setChecked(product.isSelected()); // Configurar estado inicial
            cbProduct.setOnCheckedChangeListener((buttonView, isChecked) -> {
                product.setSelected(isChecked); // Actualizar modelo
                if (listener != null) {
                    listener.onProductCheckedChange(product, isChecked);
                }
            });
        }
    }
}
