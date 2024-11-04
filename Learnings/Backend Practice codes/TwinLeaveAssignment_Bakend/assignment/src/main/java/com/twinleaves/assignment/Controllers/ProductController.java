package com.twinleaves.assignment.Controllers;

import com.twinleaves.assignment.DTOs.GtinDto;
import com.twinleaves.assignment.DTOs.ProductRequest;
import com.twinleaves.assignment.Entity.Batch;
import com.twinleaves.assignment.Entity.Gtin;
import com.twinleaves.assignment.Entity.Product;
import com.twinleaves.assignment.Exceptions.NotFoundException;
import com.twinleaves.assignment.Services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;


    /**
     * 1. Post Api TO Add Products, GTINs and BAtches
     */
    @PostMapping("/product")
    public ResponseEntity<String> addProducts(@RequestBody ProductRequest productRequest) {
        System.out.println(productRequest);
        Product product = productRequest.getProduct();
        Gtin gtin = productRequest.getGtin();
        List<Batch> batches = productRequest.getBatches();
        System.out.println(gtin);
        productService.createProductWithGtinAndBatches(product, gtin, batches);
        return ResponseEntity.ok("Products created successfully");
    }

    /**
     * 2. GET apis: to query based on gtins
     */
    @GetMapping("/gtins/{gtinCode}")
    public ResponseEntity<Gtin> getGtinByCode(@PathVariable String gtinCode) {
        Gtin gtin = productService.getGtinByCode(gtinCode);
        if(gtin != null){
            return ResponseEntity.ok(gtin);
        }else{
            throw new NotFoundException("No GTIN found for the given gtinCode - " + gtinCode);
        }
    }

    /**
     * 3. GET Api - Toget all the gtins containing batches with
     * positive available quantity
     */
    @GetMapping("/gtins/positive-batch")
    public ResponseEntity<List<GtinDto>> getGtinsWithPositiveBatchQuantity() {
        List<Gtin> gtins = productService.getGtinsWithPositiveBatchQuantity();
        List<GtinDto> gtinDtoList = gtins.stream().map(gtin -> modelMapper.map(gtin, GtinDto.class)).collect(Collectors.toList());

        return ResponseEntity.ok(gtinDtoList);
    }

    /**
     * 4. GET API:- To Get latest batches containing
     * negative or zero available quantity,
     *  latest batch (based on inwardedOn filter)
     */
    @GetMapping("/gtins/latest-negative-batch")
    public ResponseEntity<GtinDto> getGtinsWithLatestNegativeOrZeroBatch() {
        Gtin gtin = productService.getGtinsWithLatestNegativeOrZeroBatch();
        GtinDto gtinDto = modelMapper.map(gtin, GtinDto.class);
        return ResponseEntity.ok(gtinDto);
    }
}
