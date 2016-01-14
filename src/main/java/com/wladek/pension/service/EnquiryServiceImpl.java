package com.wladek.pension.service;

import com.wladek.pension.domain.pension.Enquiry;
import com.wladek.pension.repository.EnquiryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wladek on 1/14/16.
 */
@Service
public class EnquiryServiceImpl implements EnquiryService {
    @Autowired
    EnquiryRepo enquiryRepo;

    @Override
    public Enquiry make(Enquiry enquiry) {
        return null;
    }

    @Override
    public Enquiry findOne(Long id) {
        return null;
    }
}
