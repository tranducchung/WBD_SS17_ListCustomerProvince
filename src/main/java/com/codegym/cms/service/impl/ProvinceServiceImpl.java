package com.codegym.cms.service.impl;

import com.codegym.cms.model.Province;
import com.codegym.cms.repository.ProvinceRepositoty;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepositoty provinceRepositoty;


    @Override
    public Iterable<Province> findAll() {
       return provinceRepositoty.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepositoty.findOne(id);
    }

    @Override
    public void save(Province province) {
        provinceRepositoty.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepositoty.delete(id);
    }
}
