package com.example.demo.pojo;

public class Product {
    private Integer pid;
    private String name;
    private Double price;
    private Integer pstock;

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pstock=" + pstock +
                '}';
    }

    public Product(Integer pid, String name, Double price, Integer pstock) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.pstock = pstock;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPstock() {
        return pstock;
    }

    public void setPstock(Integer pstock) {
        this.pstock = pstock;
    }
}
