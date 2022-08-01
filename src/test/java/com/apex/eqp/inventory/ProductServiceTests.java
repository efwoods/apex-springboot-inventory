package com.apex.eqp.inventory;

import antlr.build.Tool;
import com.apex.eqp.inventory.entities.Product;
import com.apex.eqp.inventory.entities.RecalledProduct;
import com.apex.eqp.inventory.services.ProductService;
import com.apex.eqp.inventory.services.RecalledProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class ProductServiceTests {

    @Autowired
    ProductService productService;

    @Autowired
    RecalledProductService recalledProductService;

    /**
     * Helper method to create test products
     */
    private Product createTestProduct(String productName, Double price, Integer quantity) {
        return Product.builder()
                .name(productName)
                .price(price)
                .quantity(quantity)
                .build();
    }

    /**
     * Helper method to create test recalled products
     */
    private RecalledProduct createTestRecalledProduct(String recalledProductName) {
        return RecalledProduct.builder()
                .name(recalledProductName)
                .build();
    }

    @Test
    void shouldSaveProduct() {
        Product product = createTestProduct("product1", 1.2, 2);

        Product savedProduct = productService.save(product);

        Product loadedProduct = productService.findById(savedProduct.getId()).orElse(null);

        Assertions.assertNotNull(loadedProduct);
        Assertions.assertNotNull(loadedProduct.getId());
    }

    @Test
    void shouldSaveRecalledProduct() {
        RecalledProduct recalledProduct = createTestRecalledProduct("recalledProduct1");
        RecalledProduct savedRecalledProduct = recalledProductService.save(recalledProduct);

        Assertions.assertEquals(savedRecalledProduct.getName(), "recalledProduct1");
    }

    @Test
    void threeProductsOneRecalled() {
        Product product1 = createTestProduct("product1", 1.1, 1);
        Product product2 = createTestProduct("product2", 1.2, 2);
        Product product3 = createTestProduct("product3", 1.3, 3);

        RecalledProduct recalledProduct = createTestRecalledProduct("product1");
        RecalledProduct savedRecalledProduct = recalledProductService.save(recalledProduct);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);

        Collection<Product> productCollection = productService.getAllProduct();

        Assertions.assertEquals(2, productCollection.size());
        Logger console = new Logger() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public boolean isTraceEnabled() {
                return false;
            }

            @Override
            public void trace(String s) {

            }

            @Override
            public void trace(String s, Object o) {

            }

            @Override
            public void trace(String s, Object o, Object o1) {

            }

            @Override
            public void trace(String s, Object... objects) {

            }

            @Override
            public void trace(String s, Throwable throwable) {

            }

            @Override
            public boolean isTraceEnabled(Marker marker) {
                return false;
            }

            @Override
            public void trace(Marker marker, String s) {

            }

            @Override
            public void trace(Marker marker, String s, Object o) {

            }

            @Override
            public void trace(Marker marker, String s, Object o, Object o1) {

            }

            @Override
            public void trace(Marker marker, String s, Object... objects) {

            }

            @Override
            public void trace(Marker marker, String s, Throwable throwable) {

            }

            @Override
            public boolean isDebugEnabled() {
                return false;
            }

            @Override
            public void debug(String s) {

            }

            @Override
            public void debug(String s, Object o) {

            }

            @Override
            public void debug(String s, Object o, Object o1) {

            }

            @Override
            public void debug(String s, Object... objects) {

            }

            @Override
            public void debug(String s, Throwable throwable) {

            }

            @Override
            public boolean isDebugEnabled(Marker marker) {
                return false;
            }

            @Override
            public void debug(Marker marker, String s) {

            }

            @Override
            public void debug(Marker marker, String s, Object o) {

            }

            @Override
            public void debug(Marker marker, String s, Object o, Object o1) {

            }

            @Override
            public void debug(Marker marker, String s, Object... objects) {

            }

            @Override
            public void debug(Marker marker, String s, Throwable throwable) {

            }

            @Override
            public boolean isInfoEnabled() {
                return false;
            }

            @Override
            public void info(String s) {

            }

            @Override
            public void info(String s, Object o) {

            }

            @Override
            public void info(String s, Object o, Object o1) {

            }

            @Override
            public void info(String s, Object... objects) {

            }

            @Override
            public void info(String s, Throwable throwable) {

            }

            @Override
            public boolean isInfoEnabled(Marker marker) {
                return false;
            }

            @Override
            public void info(Marker marker, String s) {

            }

            @Override
            public void info(Marker marker, String s, Object o) {

            }

            @Override
            public void info(Marker marker, String s, Object o, Object o1) {

            }

            @Override
            public void info(Marker marker, String s, Object... objects) {

            }

            @Override
            public void info(Marker marker, String s, Throwable throwable) {

            }

            @Override
            public boolean isWarnEnabled() {
                return false;
            }

            @Override
            public void warn(String s) {

            }

            @Override
            public void warn(String s, Object o) {

            }

            @Override
            public void warn(String s, Object... objects) {

            }

            @Override
            public void warn(String s, Object o, Object o1) {

            }

            @Override
            public void warn(String s, Throwable throwable) {

            }

            @Override
            public boolean isWarnEnabled(Marker marker) {
                return false;
            }

            @Override
            public void warn(Marker marker, String s) {

            }

            @Override
            public void warn(Marker marker, String s, Object o) {

            }

            @Override
            public void warn(Marker marker, String s, Object o, Object o1) {

            }

            @Override
            public void warn(Marker marker, String s, Object... objects) {

            }

            @Override
            public void warn(Marker marker, String s, Throwable throwable) {

            }

            @Override
            public boolean isErrorEnabled() {
                return false;
            }

            @Override
            public void error(String s) {

            }

            @Override
            public void error(String s, Object o) {

            }

            @Override
            public void error(String s, Object o, Object o1) {

            }

            @Override
            public void error(String s, Object... objects) {

            }

            @Override
            public void error(String s, Throwable throwable) {

            }

            @Override
            public boolean isErrorEnabled(Marker marker) {
                return false;
            }

            @Override
            public void error(Marker marker, String s) {

            }

            @Override
            public void error(Marker marker, String s, Object o) {

            }

            @Override
            public void error(Marker marker, String s, Object o, Object o1) {

            }

            @Override
            public void error(Marker marker, String s, Object... objects) {

            }

            @Override
            public void error(Marker marker, String s, Throwable throwable) {

            }
        };
        List<String> MyList = new ArrayList<String>(productCollection.size());
        for (Product x : productCollection){
            MyList.add(x.getName());
            console.info(x.getName());
        }



    };

    @Test
    void shouldUpdateProduct() {
        Product product = createTestProduct("product2", 1.3, 5);

        Product savedProduct = productService.save(product);

        Product loadedProduct = productService.findById(savedProduct.getId()).orElse(null);

        Assertions.assertNotNull(loadedProduct);

        loadedProduct.setName("NewProduct");

        productService.save(loadedProduct);

        Assertions.assertNotNull(productService.findById(loadedProduct.getId()).orElse(null));
    }
}
