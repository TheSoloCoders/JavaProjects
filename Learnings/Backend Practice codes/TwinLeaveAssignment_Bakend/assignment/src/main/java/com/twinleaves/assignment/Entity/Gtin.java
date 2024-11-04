package com.twinleaves.assignment.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Gtin {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long gtinId;

    @NonNull
    @Column(name = "gtinCode", unique = true)
    private String gtinCode;

    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;

    @OneToMany(mappedBy = "gtinId", cascade = CascadeType.ALL)
    private List<Batch> batches;


    @Override
    public String toString() {
        return "Gtin{" +
                "id=" + gtinId +
                ", Gtin='" + gtinCode + '\'' +
                ", product=" + product +
                '}';
    }

    public String getGtin() {
        return gtinCode;
    }

    public void setGtin(String gtin) {
        this.gtinCode = gtin;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }
}
