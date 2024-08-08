package br.com.soat8.techchallenge.adapter.in.controller;

import br.com.soat8.techchallenge.core.port.in.CustomerUseCase;
import br.com.soat8.techchallenge.core.port.in.ProductCategoryUseCase;
import br.com.soat8.techchallenge.domain.Customer;
import br.com.soat8.techchallenge.domain.ProductCategory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(ProductCategoryController.BASE_URL)
public class ProductCategoryController {

    public static final String BASE_URL = "/lanchonete/category";

    private final ProductCategoryUseCase productCategoryUseCase;

    public ProductCategoryController(ProductCategoryUseCase productCategoryUseCase) {
        this.productCategoryUseCase = productCategoryUseCase;
    }

    @GetMapping
    public ResponseEntity<ProductCategory> searchCategory(@PathVariable("categoriaId") UUID id) {
        ProductCategory productCategory = productCategoryUseCase.findProductCategory(id);
        return ResponseEntity.ok(productCategory);
    }

    /*@PostMapping
    public ResponseEntity<Void> createCategory(@Valid @RequestBody ProductCategory productCategory) {
        productCategoryUseCase.saveCategory(productCategory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }*/

}
