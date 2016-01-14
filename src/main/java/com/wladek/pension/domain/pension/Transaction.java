package com.wladek.pension.domain.pension;

import com.wladek.pension.domain.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by wladek on 11/24/15.
 */
@Entity
public class Transaction extends AbstractModel {
    private String type;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    private Date dateOfTransaction;

    /*
      Holds the date for which that contribution belongs
     */
    private Date dateOfContribution;
    private Double amountContributed;
    private Long rate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
