/*Copyright (c) 2016-2017 vcstest2.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest2.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest2.com*/
package com.testmvnbuild.dbscenarios.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testmvnbuild.dbscenarios.TOne2oneP;


/**
 * ServiceImpl object for domain model class TOne2oneP.
 *
 * @see TOne2oneP
 */
@Service("dbscenarios.TOne2onePService")
public class TOne2onePServiceImpl implements TOne2onePService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TOne2onePServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.TOne2onePDao")
    private WMGenericDao<TOne2oneP, Short> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TOne2oneP, Short> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
	public TOne2oneP create(TOne2oneP tone2oneP) {
        LOGGER.debug("Creating a new TOne2oneP with information: {}", tone2oneP);
        TOne2oneP tone2onePCreated = this.wmGenericDao.create(tone2oneP);
        return tone2onePCreated;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public TOne2oneP getById(Short tone2onepId) throws EntityNotFoundException {
        LOGGER.debug("Finding TOne2oneP by id: {}", tone2onepId);
        TOne2oneP tone2oneP = this.wmGenericDao.findById(tone2onepId);
        if (tone2oneP == null){
            LOGGER.debug("No TOne2oneP found with id: {}", tone2onepId);
            throw new EntityNotFoundException(String.valueOf(tone2onepId));
        }
        return tone2oneP;
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public TOne2oneP findById(Short tone2onepId) {
        LOGGER.debug("Finding TOne2oneP by id: {}", tone2onepId);
        return this.wmGenericDao.findById(tone2onepId);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public TOne2oneP getBySerialCol(BigInteger serialCol) {
        Map<String, Object> serialColMap = new HashMap<>();
        serialColMap.put("serialCol", serialCol);

        LOGGER.debug("Finding TOne2oneP by unique keys: {}", serialColMap);
        TOne2oneP tone2oneP = this.wmGenericDao.findByUniqueKey(serialColMap);

        if (tone2oneP == null){
            LOGGER.debug("No TOne2oneP found with given unique key values: {}", serialColMap);
            throw new EntityNotFoundException(String.valueOf(serialColMap));
        }

        return tone2oneP;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
	@Override
	public TOne2oneP update(TOne2oneP tone2oneP) throws EntityNotFoundException {
        LOGGER.debug("Updating TOne2oneP with information: {}", tone2oneP);
        this.wmGenericDao.update(tone2oneP);

        Short tone2onepId = tone2oneP.getByteCol();

        return this.wmGenericDao.findById(tone2onepId);
    }

    @Transactional(value = "dbscenariosTransactionManager")
	@Override
	public TOne2oneP delete(Short tone2onepId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TOne2oneP with id: {}", tone2onepId);
        TOne2oneP deleted = this.wmGenericDao.findById(tone2onepId);
        if (deleted == null) {
            LOGGER.debug("No TOne2oneP found with id: {}", tone2onepId);
            throw new EntityNotFoundException(String.valueOf(tone2onepId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Page<TOne2oneP> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TOne2onePs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<TOne2oneP> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TOne2onePs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table TOne2oneP to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

