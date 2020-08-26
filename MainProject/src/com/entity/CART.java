package com.entity;

public class CART {
    private int CART_ID;
    private int CART_USER_ID;
    private int CART_PRO_ID;
    private String CART_PRO_NAME;
    private float CART_PRO_PRICE;
    private int CART_PRO_STOCK;
    private int CART_PRO_VAILD;
    private String CART_PRO_FILENAME;
    private int CART_PRO_QUALITY;
    private float CART_PRO_TOTAL;

    public CART(int CART_ID, int CART_USER_ID, int CART_PRO_ID, String CART_PRO_NAME, float CART_PRO_PRICE, int CART_PRO_STOCK, int CART_PRO_VAILD, String CART_PRO_FILENAME, int CART_PRO_QUALITY, float CART_PRO_TOTAL) {
        this.CART_ID = CART_ID;
        this.CART_USER_ID = CART_USER_ID;
        this.CART_PRO_ID = CART_PRO_ID;
        this.CART_PRO_NAME = CART_PRO_NAME;
        this.CART_PRO_PRICE = CART_PRO_PRICE;
        this.CART_PRO_STOCK = CART_PRO_STOCK;
        this.CART_PRO_VAILD = CART_PRO_VAILD;
        this.CART_PRO_FILENAME = CART_PRO_FILENAME;
        this.CART_PRO_QUALITY = CART_PRO_QUALITY;
        this.CART_PRO_TOTAL = CART_PRO_TOTAL;
    }

    public int getCART_ID() {
        return CART_ID;
    }

    public void setCART_ID(int CART_ID) {
        this.CART_ID = CART_ID;
    }

    public int getCART_USER_ID() {
        return CART_USER_ID;
    }

    public void setCART_USER_ID(int CART_USER_ID) {
        this.CART_USER_ID = CART_USER_ID;
    }

    public int getCART_PRO_ID() {
        return CART_PRO_ID;
    }

    public void setCART_PRO_ID(int CART_PRO_ID) {
        this.CART_PRO_ID = CART_PRO_ID;
    }

    public String getCART_PRO_NAME() {
        return CART_PRO_NAME;
    }

    public void setCART_PRO_NAME(String CART_PRO_NAME) {
        this.CART_PRO_NAME = CART_PRO_NAME;
    }

    public float getCART_PRO_PRICE() {
        return CART_PRO_PRICE;
    }

    public void setCART_PRO_PRICE(float CART_PRO_PRICE) {
        this.CART_PRO_PRICE = CART_PRO_PRICE;
    }

    public int getCART_PRO_STOCK() {
        return CART_PRO_STOCK;
    }

    public void setCART_PRO_STOCK(int CART_PRO_STOCK) {
        this.CART_PRO_STOCK = CART_PRO_STOCK;
    }

    public int getCART_PRO_VAILD() {
        return CART_PRO_VAILD;
    }

    public void setCART_PRO_VAILD(int CART_PRO_VAILD) {
        this.CART_PRO_VAILD = CART_PRO_VAILD;
    }

    public String getCART_PRO_FILENAME() {
        return CART_PRO_FILENAME;
    }

    public void setCART_PRO_FILENAME(String CART_PRO_FILENAME) {
        this.CART_PRO_FILENAME = CART_PRO_FILENAME;
    }

    public int getCART_PRO_QUALITY() {
        return CART_PRO_QUALITY;
    }

    public void setCART_PRO_QUALITY(int CART_PRO_QUALITY) {
        this.CART_PRO_QUALITY = CART_PRO_QUALITY;
    }

    public float getCART_PRO_TOTAL() {
        return CART_PRO_TOTAL;
    }

    public void setCART_PRO_TOTAL(float CART_PRO_TOTAL) {
        this.CART_PRO_TOTAL = CART_PRO_TOTAL;
    }

    @Override
    public String toString() {
        return "CART{" +
                "CART_ID=" + CART_ID +
                ", CART_USER_ID=" + CART_USER_ID +
                ", CART_PRO_ID=" + CART_PRO_ID +
                ", CART_PRO_NAME='" + CART_PRO_NAME + '\'' +
                ", CART_PRO_PRICE=" + CART_PRO_PRICE +
                ", CART_PRO_STOCK=" + CART_PRO_STOCK +
                ", CART_PRO_VAILD=" + CART_PRO_VAILD +
                ", CART_PRO_FILENAME='" + CART_PRO_FILENAME + '\'' +
                ", CART_PRO_QUALITY=" + CART_PRO_QUALITY +
                ", CART_PRO_TOTAL=" + CART_PRO_TOTAL +
                '}';
    }
}
