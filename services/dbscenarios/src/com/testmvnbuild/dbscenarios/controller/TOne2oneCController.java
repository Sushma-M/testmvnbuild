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
import com.testmvnbuild.dbscenarios.TOne2oneC;
import com.testmvnbuild.dbscenarios.service.TOne2oneCService;

/**
 * Controller object for domain model class TOne2oneC.
 * @see TOne2oneC
 */
@RestController("dbscenarios.TOne2oneCController")
@Api(value = "TOne2oneCController", description = "Exposes APIs to work with TOne2oneC resource.")
@RequestMapping("/dbscenarios/TOne2oneC")
public class TOne2oneCController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TOne2oneCController.class);

    @Autowired
    @Qualifier("dbscenarios.TOne2oneCService")
    private TOne2oneCService tOne2oneCService;

    @ApiOperation(value = "Creates a new TOne2oneC instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TOne2oneC createTOne2oneC(@RequestBody TOne2oneC tone2oneC) {
        LOGGER.debug("Create TOne2oneC with information: {}", tone2oneC);
        tone2oneC = tOne2oneCService.create(tone2oneC);
        LOGGER.debug("Created TOne2oneC with information: {}", tone2oneC);
        return tone2oneC;
    }

    @ApiOperation(value = "Returns the TOne2oneC instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TOne2oneC getTOne2oneC(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting TOne2oneC with id: {}", id);
        TOne2oneC foundTOne2oneC = tOne2oneCService.getById(id);
        LOGGER.debug("TOne2oneC details with id: {}", foundTOne2oneC);
        return foundTOne2oneC;
    }

    @ApiOperation(value = "Updates the TOne2oneC instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TOne2oneC editTOne2oneC(@PathVariable("id") String id, @RequestBody TOne2oneC tone2oneC) throws EntityNotFoundException {
        LOGGER.debug("Editing TOne2oneC with id: {}", tone2oneC.getStringCol());
        tone2oneC.setStringCol(id);
        tone2oneC = tOne2oneCService.update(tone2oneC);
        LOGGER.debug("TOne2oneC details with id: {}", tone2oneC);
        return tone2oneC;
    }

    @ApiOperation(value = "Deletes the TOne2oneC instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTOne2oneC(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TOne2oneC with id: {}", id);
        TOne2oneC deletedTOne2oneC = tOne2oneCService.delete(id);
        return deletedTOne2oneC != null;
    }

    /**
     * @deprecated Use {@link #findTOne2oneCs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TOne2oneC instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TOne2oneC> searchTOne2oneCsByQueryFilters(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TOne2oneCs list");
        return tOne2oneCService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the list of TOne2oneC instances matching the search criteria.")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TOne2oneC> findTOne2oneCs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TOne2oneCs list");
        return tOne2oneCService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTOne2oneCs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return tOne2oneCService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns the total count of TOne2oneC instances.")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Long countTOne2oneCs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting TOne2oneCs");
        return tOne2oneCService.count(query);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TOne2oneCService instance
	 */
    protected void setTOne2oneCService(TOne2oneCService service) {
        this.tOne2oneCService = service;
    }
}
