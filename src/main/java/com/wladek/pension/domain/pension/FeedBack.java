package com.wladek.pension.domain.pension;

import com.wladek.pension.domain.AbstractModel;
import com.wladek.pension.domain.User;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by wladek on 1/13/16.
 * Enquiry feedback
 */
@Entity
public class FeedBack extends AbstractModel {
    @ManyToOne(fetch = FetchType.LAZY)
    private User sender;
    @ManyToOne(fetch = FetchType.LAZY)
    private Enquiry enquiry;
    @Type(type = "text")
    private String message;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Enquiry getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(Enquiry enquiry) {
        this.enquiry = enquiry;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
