package com.entity;

public class PRODUCT {
    private int PRODUCT_ID;
    private String PRODUCT_NAME;
    private String PRODUCT_DESC;
    private float PRODUCT_PRICE;
    private int PRODUCT_STOCK;
    private int PRODUCT_FID;
    private int PRODUCT_CID;
    private String PRODUCT_FILENAME;

    public PRODUCT(int PRODUCT_ID, String PRODUCT_NAME, String PRODUCT_DESC, float PRODUCT_PRICE, int PRODUCT_STOCK, int PRODUCT_FID, int PRODUCT_CID, String PRODUCT_FILENAME) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRODUCT_DESC = PRODUCT_DESC;
        this.PRODUCT_PRICE = PRODUCT_PRICE;
        this.PRODUCT_STOCK = PRODUCT_STOCK;
        this.PRODUCT_FID = PRODUCT_FID;
        this.PRODUCT_CID = PRODUCT_CID;
        this.PRODUCT_FILENAME = PRODUCT_FILENAME;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getPRODUCT_DESC() {
        return PRODUCT_DESC;
    }

    public void setPRODUCT_DESC(String PRODUCT_DESC) {
        this.PRODUCT_DESC = PRODUCT_DESC;
    }

    public float getPRODUCT_PRICE() {
        return PRODUCT_PRICE;
    }

    public void setPRODUCT_PRICE(float PRODUCT_PRICE) {
        this.PRODUCT_PRICE = PRODUCT_PRICE;
    }

    public int getPRODUCT_STOCK() {
        return PRODUCT_STOCK;
    }

    public void setPRODUCT_STOCK(int PRODUCT_STOCK) {
        this.PRODUCT_STOCK = PRODUCT_STOCK;
    }

    public int getPRODUCT_FID() {
        return PRODUCT_FID;
    }

    public void setPRODUCT_FID(int PRODUCT_FID) {
        this.PRODUCT_FID = PRODUCT_FID;
    }

    public int getPRODUCT_CID() {
        return PRODUCT_CID;
    }

    public void setPRODUCT_CID(int PRODUCT_CID) {
        this.PRODUCT_CID = PRODUCT_CID;
    }

    public String getPRODUCT_FILENAME() {
        return PRODUCT_FILENAME;
    }

    public void setPRODUCT_FILENAME(String PRODUCT_FILENAME) {
        this.PRODUCT_FILENAME = PRODUCT_FILENAME;
    }

    @Override
    public String toString() {
        return "PRODUCT{" +
                "PRODUCT_ID=" + PRODUCT_ID +
                ", PRODUCT_NAME='" + PRODUCT_NAME + '\'' +
                ", PRODUCT_DESC='" + PRODUCT_DESC + '\'' +
                ", PRODUCT_PRICE=" + PRODUCT_PRICE +
                ", PRODUCT_STOCK=" + PRODUCT_STOCK +
                ", PRODUCT_FID=" + PRODUCT_FID +
                ", PRODUCT_CID=" + PRODUCT_CID +
                ", PRODUCT_FILENAME='" + PRODUCT_FILENAME + '\'' +
                '}';
    }
}
