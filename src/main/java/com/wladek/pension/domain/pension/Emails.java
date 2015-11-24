package com.wladek.pension.domain.pension;

import com.wladek.pension.domain.AbstractModel;

import javax.persistence.Entity;

/**
 * Created by wladek on 11/24/15.
 */
@Entity
public class Emails extends AbstractModel{
    private String title;
    private String senderEmail;
    private String message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
