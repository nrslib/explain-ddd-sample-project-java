package com.nrslib.scrum.domain.models.task;

import com.nrslib.applicationsupportstack.domainsupport.valueobjects.ValueObject;

public class EstimatedValue extends ValueObject<Integer> {
    public EstimatedValue(int value) {
        super(value);
    }
}
