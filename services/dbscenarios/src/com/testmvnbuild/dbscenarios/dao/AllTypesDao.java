/*Copyright (c) 2016-2017 vcstest2.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest2.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest2.com*/
package com.testmvnbuild.dbscenarios.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.testmvnbuild.dbscenarios.AllTypes;

/**
 * Specifies methods used to obtain and modify AllTypes related information
 * which is stored in the database.
 */
@Repository("dbscenarios.AllTypesDao")
public class AllTypesDao extends WMGenericDaoImpl<AllTypes, Integer> {

    @Autowired
    @Qualifier("dbscenariosTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

