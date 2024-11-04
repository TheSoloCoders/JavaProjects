package com.twinleaves.assignment.Services;

import com.twinleaves.assignment.Entity.Batch;
import com.twinleaves.assignment.Entity.Gtin;
import com.twinleaves.assignment.Entity.Product;

import java.util.List;

public interface ProductService {
    Boolean createProductWithGtinAndBatches(Product product, Gtin gtin, List<Batch> batches);

    Gtin getGtinByCode(String gtinCode);

    List<Gtin> getGtinsWithPositiveBatchQuantity();

    Gtin getGtinsWithLatestNegativeOrZeroBatch();
}
