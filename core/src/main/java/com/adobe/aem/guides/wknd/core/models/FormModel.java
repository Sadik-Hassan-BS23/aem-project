package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FormModel {
    @ValueMapValue
    private String name;

    @ValueMapValue
    private String age;

    public String getName() {
        return name != null ? name : "";
    }

    public String getAge() {
        return age != null ? age : "";
    }
}
