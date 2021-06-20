package com.example.scrum.domain.models.task;

import com.example.applicationsupportstack.domainsupport.valueobjects.ValueObject;

public class EstimatedValue extends ValueObject<Integer> {
    public EstimatedValue(int value) {
        super(value);
    }
}
