package com.wladek.pension.service;

import com.wladek.pension.domain.pension.Assets;
import com.wladek.pension.repository.AssetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wladek on 1/14/16.
 */
@Service
public class AssetServiceImpl implements AssetService {
    @Autowired
    AssetRepo assetRepo;
    @Override
    public Assets create(Assets assets) {
        return assetRepo.save(assets);
    }

    @Override
    public Assets findOne(Long id) {
        return assetRepo.findOne(id);
    }

    @Override
    public List<Assets> findAll() {
        return assetRepo.findAll();
    }

    @Override
    public Assets edit(Assets assets) {
        Assets assetInDb = findOne(assets.getId());

        assetInDb.setName(assets.getName());
        assetInDb.setExpectedAnnualReturn(assets.getExpectedAnnualReturn());
        assetInDb.setCost(assets.getCost());
        assetInDb.setType(assets.getType());

        return assetRepo.save(assetInDb);
    }

    @Override
    public boolean delete(Long id) {
        assetRepo.delete(id);
        return true;
    }
}
