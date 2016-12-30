/*Copyright (c) 2016-2017 vcstest2.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest2.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest2.com*/
package com.testmvnbuild.dbscenarios.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.testmvnbuild.dbscenarios.TUcComposites1;
import com.testmvnbuild.dbscenarios.service.TUcComposites1Service;

/**
 * Controller object for domain model class TUcComposites1.
 * @see TUcComposites1
 */
@RestController("dbscenarios.TUcComposites1Controller")
@Api(value = "TUcComposites1Controller", description = "Exposes APIs to work with TUcComposites1 resource.")
@RequestMapping("/dbscenarios/TUcComposites1")
public class TUcComposites1Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(TUcComposites1Controller.class);

    @Autowired
    @Qualifier("dbscenarios.TUcComposites1Service")
    private TUcComposites1Service tUcComposites1Service;

    @ApiOperation(value = "Creates a new TUcComposites1 instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TUcComposites1 createTUcComposites1(@RequestBody TUcComposites1 tucComposites1) {
        LOGGER.debug("Create TUcComposites1 with information: {}", tucComposites1);
        tucComposites1 = tUcComposites1Service.create(tucComposites1);
        LOGGER.debug("Created TUcComposites1 with information: {}", tucComposites1);
        return tucComposites1;
    }

    @ApiOperation(value = "Returns the TUcComposites1 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TUcComposites1 getTUcComposites1(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TUcComposites1 with id: {}", id);
        TUcComposites1 foundTUcComposites1 = tUcComposites1Service.getById(id);
        LOGGER.debug("TUcComposites1 details with id: {}", foundTUcComposites1);
        return foundTUcComposites1;
    }

    @ApiOperation(value = "Updates the TUcComposites1 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TUcComposites1 editTUcComposites1(@PathVariable("id") Integer id, @RequestBody TUcComposites1 tucComposites1) throws EntityNotFoundException {
        LOGGER.debug("Editing TUcComposites1 with id: {}", tucComposites1.getId());
        tucComposites1.setId(id);
        tucComposites1 = tUcComposites1Service.update(tucComposites1);
        LOGGER.debug("TUcComposites1 details with id: {}", tucComposites1);
        return tucComposites1;
    }

    @ApiOperation(value = "Deletes the TUcComposites1 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTUcComposites1(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TUcComposites1 with id: {}", id);
        TUcComposites1 deletedTUcComposites1 = tUcComposites1Service.delete(id);
        return deletedTUcComposites1 != null;
    }

    @RequestMapping(value = "/byteCol-charCol-shortCol-stringCol", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching TUcComposites1 with given unique key values.")
    public TUcComposites1 getByByteColAndCharColAndShortColAndStringCol(@RequestParam(name = "byteCol") Short byteCol, @RequestParam(name = "charCol") Character charCol, @RequestParam(name = "shortCol") Short shortCol, @RequestParam(name = "stringCol") String stringCol) {
        LOGGER.debug("Getting TUcComposites1 with uniques key ByteColAndCharColAndShortColAndStringCol");
        return tUcComposites1Service.getByByteColAndCharColAndShortColAndStringCol(byteCol, charCol, shortCol, stringCol);
    }

    /**
     * @deprecated Use {@link #findTUcComposites1s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TUcComposites1 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TUcComposites1> searchTUcComposites1sByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TUcComposites1s list");
        return tUcComposites1Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of TUcComposites1 instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TUcComposites1> findTUcComposites1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TUcComposites1s list");
        return tUcComposites1Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTUcComposites1s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return tUcComposites1Service.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of TUcComposites1 instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countTUcComposites1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting TUcComposites1s");
        return tUcComposites1Service.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TUcComposites1Service instance
	 */
    protected void setTUcComposites1Service(TUcComposites1Service service) {
        this.tUcComposites1Service = service;
    }
}