package com.wladek.pension.service;

import com.wladek.pension.domain.pension.Enquiry;

/**
 * Created by wladek on 1/14/16.
 */
public interface EnquiryService {
    public Enquiry make(Enquiry enquiry);
    public Enquiry findOne(Long id);
}
