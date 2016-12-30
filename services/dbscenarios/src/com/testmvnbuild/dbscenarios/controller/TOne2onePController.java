/*Copyright (c) 2016-2017 vcstest2.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest2.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest2.com*/
package com.testmvnbuild.dbscenarios.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import java.math.BigInteger;
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
import com.testmvnbuild.dbscenarios.TOne2oneP;
import com.testmvnbuild.dbscenarios.service.TOne2onePService;

/**
 * Controller object for domain model class TOne2oneP.
 * @see TOne2oneP
 */
@RestController("dbscenarios.TOne2onePController")
@Api(value = "TOne2onePController", description = "Exposes APIs to work with TOne2oneP resource.")
@RequestMapping("/dbscenarios/TOne2oneP")
public class TOne2onePController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TOne2onePController.class);

    @Autowired
    @Qualifier("dbscenarios.TOne2onePService")
    private TOne2onePService tOne2onePService;

    @ApiOperation(value = "Creates a new TOne2oneP instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TOne2oneP createTOne2oneP(@RequestBody TOne2oneP tone2oneP) {
        LOGGER.debug("Create TOne2oneP with information: {}", tone2oneP);
        tone2oneP = tOne2onePService.create(tone2oneP);
        LOGGER.debug("Created TOne2oneP with information: {}", tone2oneP);
        return tone2oneP;
    }

    @ApiOperation(value = "Returns the TOne2oneP instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TOne2oneP getTOne2oneP(@PathVariable("id") Short id) throws EntityNotFoundException {
        LOGGER.debug("Getting TOne2oneP with id: {}", id);
        TOne2oneP foundTOne2oneP = tOne2onePService.getById(id);
        LOGGER.debug("TOne2oneP details with id: {}", foundTOne2oneP);
        return foundTOne2oneP;
    }

    @ApiOperation(value = "Updates the TOne2oneP instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TOne2oneP editTOne2oneP(@PathVariable("id") Short id, @RequestBody TOne2oneP tone2oneP) throws EntityNotFoundException {
        LOGGER.debug("Editing TOne2oneP with id: {}", tone2oneP.getByteCol());
        tone2oneP.setByteCol(id);
        tone2oneP = tOne2onePService.update(tone2oneP);
        LOGGER.debug("TOne2oneP details with id: {}", tone2oneP);
        return tone2oneP;
    }

    @ApiOperation(value = "Deletes the TOne2oneP instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTOne2oneP(@PathVariable("id") Short id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TOne2oneP with id: {}", id);
        TOne2oneP deletedTOne2oneP = tOne2onePService.delete(id);
        return deletedTOne2oneP != null;
    }

    @RequestMapping(value = "/serialCol/{serialCol}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching TOne2oneP with given unique key values.")
    public TOne2oneP getBySerialCol(@PathVariable("serialCol") BigInteger serialCol) {
        LOGGER.debug("Getting TOne2oneP with uniques key SerialCol");
        return tOne2onePService.getBySerialCol(serialCol);
    }

    /**
     * @deprecated Use {@link #findTOne2onePs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TOne2oneP instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TOne2oneP> searchTOne2onePsByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TOne2onePs list");
        return tOne2onePService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of TOne2oneP instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TOne2oneP> findTOne2onePs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TOne2onePs list");
        return tOne2onePService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTOne2onePs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return tOne2onePService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of TOne2oneP instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countTOne2onePs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting TOne2onePs");
        return tOne2onePService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TOne2onePService instance
	 */
    protected void setTOne2onePService(TOne2onePService service) {
        this.tOne2onePService = service;
    }
}
