package com.market.admin.brand;

import com.market.common.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository repo;

    public List<Brand> listAll() {
        return (List<Brand>) repo.findAll();
    }
}
