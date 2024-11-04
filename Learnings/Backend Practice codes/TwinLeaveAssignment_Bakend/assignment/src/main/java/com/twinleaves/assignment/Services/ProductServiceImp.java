package com.twinleaves.assignment.Services;

import com.twinleaves.assignment.Entity.Batch;
import com.twinleaves.assignment.Entity.Gtin;
import com.twinleaves.assignment.Entity.Product;
import com.twinleaves.assignment.Exceptions.CustomException;
import com.twinleaves.assignment.Exceptions.NotFoundException;
import com.twinleaves.assignment.Repository.BatchRepo;
import com.twinleaves.assignment.Repository.GtinRepository;
import com.twinleaves.assignment.Repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private GtinRepository gtinRepository;
    @Autowired
    private BatchRepo batchRepo;

    @Override
    public Boolean createProductWithGtinAndBatches(Product product, Gtin gtin, List<Batch> batches) {
        //Saving product details
        try {

            product.setCreateOn(LocalDate.now());
            Product savedProd = productRepo.save(product);

            gtin.setProduct(savedProd);
            gtin.setGtin(gtin.getGtin());
            gtin = gtinRepository.save(gtin);

            for (Batch batch : batches) {
                batch.setGtin(gtin);
            }
            List<Batch> savedBatches = batchRepo.saveAll(batches);
            return true;
        }catch (Exception e){
            throw new CustomException("GTIN Code already exists: " + gtin.getGtin(), e);
        }

    }

    @Override
    public Gtin getGtinByCode(String gtinCode) {
        Optional<Gtin> byGtin = gtinRepository.findByGtinCode(gtinCode);
        return byGtin.orElse(null);
    }

    @Override
    public List<Gtin> getGtinsWithPositiveBatchQuantity() {
        List<Batch> batches = batchRepo.findAll();
//        System.out.println(batches);
        List<Gtin> gtins = batches.stream().filter(batch -> batch.getAvailableQuantity() > 0)
                .map(Batch::getGtin)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());

        return gtins;
    }
    @Override
    public Gtin getGtinsWithLatestNegativeOrZeroBatch() {
//        return  batchRepo.findAll()
//                .stream().filter(batch -> batch.getAvailableQuantity() <= 0)
//                .sorted(Comparator.comparing(Batch::getInwardedOn).reversed())
//                .findFirst()
//                .map(Batch::getGtin)
//                .orElse(null);

        //findFirst The latest Btach based on the inwardedOn date
        // and return getGtin of that batch

        Long gtinId = batchRepo.findLatestGtinWithNegativeOrZeroBatchNative();
        return gtinId != null ? gtinRepository.findById(gtinId).orElse(null) : null;
    }
}
