package com.yajie.huayi.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yajie.huayi.domain.MaterialsRecord;
import com.yajie.huayi.service.ex.MaterialsRecordServiceImpl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/6 9:35
 */
public class MaterialsRecordService implements MaterialsRecordServiceImpl {
    @Override
    public boolean save(MaterialsRecord entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<MaterialsRecord> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<MaterialsRecord> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return false;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<MaterialsRecord> queryWrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(MaterialsRecord entity) {
        return false;
    }

    @Override
    public boolean update(MaterialsRecord entity, Wrapper<MaterialsRecord> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<MaterialsRecord> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(MaterialsRecord entity) {
        return false;
    }

    @Override
    public MaterialsRecord getById(Serializable id) {
        return null;
    }

    @Override
    public Collection<MaterialsRecord> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public Collection<MaterialsRecord> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public MaterialsRecord getOne(Wrapper<MaterialsRecord> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<MaterialsRecord> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<MaterialsRecord> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count(Wrapper<MaterialsRecord> queryWrapper) {
        return 0;
    }

    @Override
    public List<MaterialsRecord> list(Wrapper<MaterialsRecord> queryWrapper) {
        return null;
    }

    @Override
    public IPage<MaterialsRecord> page(IPage<MaterialsRecord> page, Wrapper<MaterialsRecord> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<MaterialsRecord> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<MaterialsRecord> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<MaterialsRecord> page, Wrapper<MaterialsRecord> queryWrapper) {
        return null;
    }

    @Override
    public BaseMapper<MaterialsRecord> getBaseMapper() {
        return null;
    }
}
