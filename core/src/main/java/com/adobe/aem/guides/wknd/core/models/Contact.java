package com.adobe.aem.guides.wknd.core.models;

import lombok.Getter;
import lombok.Setter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Setter
@Getter
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Contact {
    @Inject
    private String contactName;

    @Inject
    private String contactEmail;

    @Inject
    private boolean isActive;
}
