package tienda.entidades;

public class Product {
    
    private int code;
    private String name;
    private double price;
    private int manufacturerCode;

    public Product() {
    }

    public Product(int code, String name, double price, int manufacturerCode) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.manufacturerCode = manufacturerCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(int manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }
    
}
