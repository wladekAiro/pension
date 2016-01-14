package com.wladek.pension.domain.pension;

import com.wladek.pension.domain.AbstractModel;
import com.wladek.pension.domain.User;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by wladek on 1/13/16.
 * User Enquirees
 */
@Entity
public class Enquiry extends AbstractModel{
    private String topic;
    @Type(type = "text")
    private String message;

    /*
      The user making an inquiry
     */
    @ManyToOne
    private User enquirer;
    @OneToMany(mappedBy = "enquiry", fetch = FetchType.LAZY)
    private List<FeedBack> feedBacks;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getEnquirer() {
        return enquirer;
    }

    public void setEnquirer(User enquirer) {
        this.enquirer = enquirer;
    }

    public List<FeedBack> getFeedBacks() {
        return feedBacks;
    }

    public void setFeedBacks(List<FeedBack> feedBacks) {
        this.feedBacks = feedBacks;
    }
}
