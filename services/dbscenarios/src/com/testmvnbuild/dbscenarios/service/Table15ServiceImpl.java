/*Copyright (c) 2016-2017 vcstest2.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest2.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest2.com*/
package com.testmvnbuild.dbscenarios.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


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

import com.testmvnbuild.dbscenarios.Table15;
import com.testmvnbuild.dbscenarios.Table15Id;


/**
 * ServiceImpl object for domain model class Table15.
 *
 * @see Table15
 */
@Service("dbscenarios.Table15Service")
public class Table15ServiceImpl implements Table15Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table15ServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.Table15Dao")
    private WMGenericDao<Table15, Table15Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table15, Table15Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
	public Table15 create(Table15 table15) {
        LOGGER.debug("Creating a new Table15 with information: {}", table15);
        Table15 table15Created = this.wmGenericDao.create(table15);
        return table15Created;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Table15 getById(Table15Id table15Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table15 by id: {}", table15Id);
        Table15 table15 = this.wmGenericDao.findById(table15Id);
        if (table15 == null){
            LOGGER.debug("No Table15 found with id: {}", table15Id);
            throw new EntityNotFoundException(String.valueOf(table15Id));
        }
        return table15;
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Table15 findById(Table15Id table15Id) {
        LOGGER.debug("Finding Table15 by id: {}", table15Id);
        return this.wmGenericDao.findById(table15Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
	@Override
	public Table15 update(Table15 table15) throws EntityNotFoundException {
        LOGGER.debug("Updating Table15 with information: {}", table15);
        this.wmGenericDao.update(table15);

        Table15Id table15Id = new Table15Id();
        table15Id.setColumn2(table15.getColumn2());
        table15Id.setColumn3(table15.getColumn3());
        table15Id.setColumn4(table15.getColumn4());
        table15Id.setColumn5(table15.getColumn5());

        return this.wmGenericDao.findById(table15Id);
    }

    @Transactional(value = "dbscenariosTransactionManager")
	@Override
	public Table15 delete(Table15Id table15Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table15 with id: {}", table15Id);
        Table15 deleted = this.wmGenericDao.findById(table15Id);
        if (deleted == null) {
            LOGGER.debug("No Table15 found with id: {}", table15Id);
            throw new EntityNotFoundException(String.valueOf(table15Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Page<Table15> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table15s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<Table15> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table15s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table Table15 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

