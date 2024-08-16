package com.nvision.mobishop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nvision.mobishop.R;
import com.nvision.mobishop.adapters.ProductRecyclerViewAdapter;
import com.nvision.mobishop.models.Product;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView productRecyclerView;
    ProductRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        productRecyclerView = view.findViewById(R.id.product_recycler);

        // Manually create the array list
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Basmati Rice", "Rathna", "1000", "https://cdn.pixabay.com/photo/2017/09/01/00/15/png-2702691_640.png", false));
        products.add(new Product("Basmati Rice", "Rathna", "1000", "https://cdn.pixabay.com/photo/2017/09/01/00/15/png-2702691_640.png", false));
        products.add(new Product("Basmati Rice", "Rathna", "1000", "https://cdn.pixabay.com/photo/2017/09/01/00/15/png-2702691_640.png", false));
        products.add(new Product("Basmati Rice", "Rathna", "1000", "https://cdn.pixabay.com/photo/2017/09/01/00/15/png-2702691_640.png", false));
        products.add(new Product("Basmati Rice", "Rathna", "1000", "https://cdn.pixabay.com/photo/2017/09/01/00/15/png-2702691_640.png", false));
        products.add(new Product("Basmati Rice", "Rathna", "1000", "https://cdn.pixabay.com/photo/2017/09/01/00/15/png-2702691_640.png", false));
        products.add(new Product("Basmati Rice", "Rathna", "1000", "https://cdn.pixabay.com/photo/2017/09/01/00/15/png-2702691_640.png", false));
        products.add(new Product("Basmati Rice", "Rathna", "1000", "https://cdn.pixabay.com/photo/2017/09/01/00/15/png-2702691_640.png", false));
        products.add(new Product("Basmati Rice", "Rathna", "1000", "https://cdn.pixabay.com/photo/2017/09/01/00/15/png-2702691_640.png", false));
        products.add(new Product("Basmati Rice", "Rathna", "1000", "https://cdn.pixabay.com/photo/2017/09/01/00/15/png-2702691_640.png", false));


        // initiate the recycle view adapter
        adapter = new ProductRecyclerViewAdapter(getContext());
        adapter.setProducts(products);

        productRecyclerView.setAdapter(adapter);

        productRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return view;
    }

    // delete selected item
    public void deleteSelectedItems() {
        adapter.deleteSelectedItems();
    }

    // select all
    public void selectAllItems() {
        adapter.selectAll();
    }

    // Unselect all
    public void unSelectAllItems() {
        adapter.unSelectAll();
    }
}