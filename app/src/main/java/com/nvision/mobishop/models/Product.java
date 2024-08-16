package com.nvision.mobishop.models;

public class Product {
    private final String pName;
    private final String pBrand;
    private final String pPrice;
    private final String imageUrl;
    private boolean isSelected = false;


    public Product(String pName, String pBrand, String pPrice, String imageUrl, boolean isSelected) {
        this.pName = pName;
        this.pBrand = pBrand;
        this.pPrice = pPrice;
        this.imageUrl = imageUrl;
        this.isSelected = isSelected;
    }

    public String getpName() {
        return pName;
    }

    public String getpBrand() {
        return pBrand;
    }

    public String getpPrice() {
        return pPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "product{" +
                "pName='" + pName + '\'' +
                ", pBrand='" + pBrand + '\'' +
                ", pPrice='" + pPrice + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
