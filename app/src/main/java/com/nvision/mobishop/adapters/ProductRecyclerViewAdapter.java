package com.nvision.mobishop.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nvision.mobishop.R;
import com.nvision.mobishop.models.Product;

import java.util.ArrayList;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Product> products = new ArrayList<>();

    private Context context;

    private boolean multiSelectMode = false;

    ArrayList<Product> selectedItemList = new ArrayList<>();



    public ProductRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.productName.setText(products.get(position).getpName());
        holder.productBrand.setText(products.get(position).getpBrand());
        holder.productPrice.setText(products.get(position).getpPrice());

        Product product = products.get(position);

        if (product.isSelected()) {
            holder.itemView.setBackgroundColor(Color.RED);
        } else {
            holder.itemView.setBackground(holder.defaultBackground); // Use the stored default background
        }

        holder.productListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, products.get(position).getpName() + " Clicked", Toast.LENGTH_SHORT).show();
                // ----
                if (multiSelectMode) {
                    toggleSelection(product);
                }
            }
        });

        // Image load through url
        Glide.with(context)
                .asBitmap()
                .load(products.get(position).getImageUrl())
                .into(holder.productImage);

        // LongCLickListener
        holder.itemView.setOnLongClickListener(v -> {
            Toast.makeText(context, products.get(position).getpName() + " Long Clicked", Toast.LENGTH_SHORT).show();
            if (!multiSelectMode) {
                multiSelectMode = true;
                toggleSelection(product);
                notifyDataSetChanged();
            }
            return true;
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView productName, productBrand, productPrice;
        private ImageView productImage;
        // Init the product list item
        private CardView productListItem;
        private Drawable defaultBackground;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productBrand = itemView.findViewById(R.id.product_brand);
            productPrice = itemView.findViewById(R.id.product_price);

            productImage = itemView.findViewById(R.id.product_image);

            productListItem = itemView.findViewById(R.id.product_list_item);

            defaultBackground = itemView.getBackground();


        }
    }

    // ---
    private void toggleSelection(Product product) {
        product.setSelected(!product.isSelected());
        notifyDataSetChanged();
    }

    public void deleteSelectedItems() {

        for (Product item : products) {
            if (item.isSelected()) {
                selectedItemList.add(item);
            }
        }
        products.removeAll(selectedItemList);
        multiSelectMode = false;
        notifyDataSetChanged();
    }

    // select all
    public void selectAll() {
        for (Product product : products) {
            product.setSelected(true);
        }
        notifyDataSetChanged();
    }

    // unselect all
    public void unSelectAll() {
        for (Product product : products) {
            product.setSelected(false);
        }
        notifyDataSetChanged();
    }
}
