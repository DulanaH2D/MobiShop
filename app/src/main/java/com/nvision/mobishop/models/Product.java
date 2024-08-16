package com.nvision.mobishop.models;

public class Product {
    private String pName;
    private String pBrand;
    private String pPrice;
    private String imageUrl;
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

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpBrand() {
        return pBrand;
    }

    public void setpBrand(String pBrand) {
        this.pBrand = pBrand;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
