package com.wladek.pension.service;

import com.wladek.pension.domain.pension.Assets;

import java.util.List;

/**
 * Created by wladek on 1/14/16.
 */
public interface AssetService {
    public Assets create(Assets assets);
    public Assets findOne(Long id);
    public List<Assets> findAll();
    public Assets edit(Assets assets);
    public boolean delete(Long id);
}
