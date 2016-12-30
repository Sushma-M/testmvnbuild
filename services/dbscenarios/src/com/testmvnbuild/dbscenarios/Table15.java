/*Copyright (c) 2016-2017 vcstest2.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest2.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest2.com*/
package com.testmvnbuild.dbscenarios;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Table15 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE15`")
@IdClass(Table15Id.class)
public class Table15 implements Serializable {

    private String column2;
    private String column3;
    private String column4;
    private String column5;

    @Id
    @Column(name = "`COLUMN2`", nullable = true, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Id
    @Column(name = "`COLUMN3`", nullable = true, length = 255)
    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    @Id
    @Column(name = "`COLUMN4`", nullable = true, length = 255)
    public String getColumn4() {
        return this.column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    @Id
    @Column(name = "`COLUMN5`", nullable = true, length = 255)
    public String getColumn5() {
        return this.column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table15)) return false;
        final Table15 table15 = (Table15) o;
        return Objects.equals(getColumn2(), table15.getColumn2()) &&
                Objects.equals(getColumn3(), table15.getColumn3()) &&
                Objects.equals(getColumn4(), table15.getColumn4()) &&
                Objects.equals(getColumn5(), table15.getColumn5());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn2(),
                getColumn3(),
                getColumn4(),
                getColumn5());
    }
}

