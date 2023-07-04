package tienda.entidades;

public class Product {
    
    private int code;
    private String name;
    private double price;
    private Maker manufacturerCode;

    public Product() {
    }

    public Product(int code, String name, double price, Maker manufacturerCode) {
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

    public Maker getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(Maker manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }
    
}
