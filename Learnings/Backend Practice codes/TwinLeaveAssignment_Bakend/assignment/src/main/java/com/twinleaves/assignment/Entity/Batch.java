package com.twinleaves.assignment.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batchId;
    @Setter
    private Integer mrp;
    @Setter
    private Integer sp;
    @Setter
    private Integer purchasePrice;
    @Setter
    private Integer availableQuantity;
    @Setter
    private LocalDate inwardedOn;

    @ManyToOne
    @JoinColumn(name = "gtinId")
    private Gtin gtinId;

//    @ManyToOne
//    @JoinColumn( name = "gtinId")
//    private Gtin gtinId;

    @Override
    public String toString() {
        return "Batch{" +
                "batchId=" + batchId +
                ", mrp=" + mrp +
                ", sp=" + sp +
                ", purchasePrice=" + purchasePrice +
                ", availableQuantity=" + availableQuantity +
                ", inwardedOn=" + inwardedOn +
                ", gtin=" + gtinId +
                '}';
    }

    public Long getBatchId() {
        return batchId;
    }

    public Integer getMrp() {
        return mrp;
    }

    public void setMrp(Integer mrp) {
        this.mrp = mrp;
    }

    public Integer getSp() {
        return sp;
    }

    public void setSp(Integer sp) {
        this.sp = sp;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public LocalDate getInwardedOn() {
        return inwardedOn;
    }

    public void setInwardedOn(LocalDate inwardedOn) {
        this.inwardedOn = inwardedOn;
    }

    public Gtin getGtin() {
        return gtinId;
    }

    public void setGtin(Gtin gtin) {
        this.gtinId = gtin;
    }
}
