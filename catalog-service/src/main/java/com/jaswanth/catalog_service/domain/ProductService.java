package com.jaswanth.catalog_service.domain;


import com.jaswanth.catalog_service.ApplicationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    ProductRepositry productRepo;
    ApplicationProperties applicationProperties;

    ProductService(ProductRepositry productRepo, ApplicationProperties applicationProperties) {
        this.productRepo = productRepo;
        this.applicationProperties=applicationProperties;
    }


    public  PagedResult<Product> getProducts(int pageNo){

        Sort sort=Sort.by("name").ascending();
        pageNo = pageNo <= 1 ? 0 : pageNo - 1;
        Pageable pageable= PageRequest.of(pageNo, applicationProperties.pageSize(),sort);

        //changing Product Entity to product using a mapper
        Page<Product> productsPage=productRepo.findAll(pageable).map(ProductMapper::toProduct);
        //warpping up to custom page
        PagedResult<Product> pagedResult=new PagedResult<>(productsPage.getContent(),
                productsPage.getTotalElements(),
                productsPage.getNumber() + 1,
                productsPage.getTotalPages(),
                productsPage.isFirst(),
                productsPage.isLast(),
                productsPage.hasNext(),
                productsPage.hasPrevious());
        return pagedResult;
    }
}
