package com.example.applicationsupportstack.domainsupport.aggregate;

import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Collection;

public abstract class AggregateRoot extends AbstractAggregateRoot {
    public Collection<Object> domainEvents() {
        return super.domainEvents();
    }

    public void clearDomainEvents() {
        super.clearDomainEvents();
    }
}
