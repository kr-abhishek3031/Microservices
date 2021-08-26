package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.exceptionHandler.ApplicationException;
import com.example.demo.service.Greet;
import com.example.demo.service.Greeting;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/inventory")
public class Inventory {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping("")
    public ResponseEntity<String> greetGuest(){
        return new Greeting().greet();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewProduct(@RequestBody Product p, UriComponentsBuilder ucBuilder){
        inventoryService.addProduct(p);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(p.getpId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getProductbyId(@PathVariable("id") Long id){
        Product p = inventoryService.searchProductByID(id);
        if(p!=null){
            return new ResponseEntity<Product>(p, HttpStatus.OK);
        }
        else{
            ApplicationException aex = new ApplicationException("Product with id " + id
                    + " not found");
            return new ResponseEntity<String>(aex.getErrorMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<?> getProductbyId(@PathVariable("name") String name){
        Product p = inventoryService.searchProductByName(name);
        if(p!=null){
            return new ResponseEntity<Product>(p, HttpStatus.OK);
        }
        else{
            ApplicationException aex = new ApplicationException("Product with name " + name
                    + " not found");
            return new ResponseEntity<String>(aex.getErrorMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        Product p = inventoryService.searchProductByID(id);
        if(p!=null){
            inventoryService.deleteProduct(p.getpId());
            return new ResponseEntity<String>("Product Successfully removed", HttpStatus.OK);
        }
        else{
            ApplicationException aex = new ApplicationException("Product with id " + id
                    + " not found");
            return new ResponseEntity<String>(aex.getErrorMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatePrice/{id}/{priceChange}")
    public ResponseEntity<?> updatePrice(@PathVariable("id") Long id, @PathVariable("priceChange") Double change){
        Product p = inventoryService.searchProductByID(id);
        if(p!=null){
            inventoryService.updateProductPrice(id, change);
            return new ResponseEntity<String>("Price of the product successfully updated", HttpStatus.OK);
        }
        else{
            ApplicationException aex = new ApplicationException("Product with id " + id
                    + " not found");
            return new ResponseEntity<String>(aex.getErrorMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
