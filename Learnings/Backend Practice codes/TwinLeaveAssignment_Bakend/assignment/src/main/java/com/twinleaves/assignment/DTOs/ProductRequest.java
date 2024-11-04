package com.twinleaves.assignment.DTOs;

import com.twinleaves.assignment.Entity.Batch;
import com.twinleaves.assignment.Entity.Gtin;
import com.twinleaves.assignment.Entity.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ProductRequest {
    private Product product;
    private Gtin gtin;
    private List<Batch> batches;
    public Product getProduct() {
        return product;
    }

    public Gtin getGtin() {
        return gtin;
    }

    public List<Batch> getBatches() {
        return batches;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setGtin(Gtin gtin) {
        this.gtin = gtin;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "product=" + product +
                ", gtin=" + gtin +
                ", batches=" + batches +
                '}';
    }
}