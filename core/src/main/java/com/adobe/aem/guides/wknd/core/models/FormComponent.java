package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = FormComponent.class,
        resourceType = FormComponent.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FormComponent {
    // public static final String RESOURCE_TYPE = ;
    public static final String RESOURCE_TYPE = "/apps/mysite/components/firstForm";

    @ValueMapValue
    private String firstName;

    @ValueMapValue
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    @ValueMapValue
    private String successPagePath;

    public String getSuccessPagePath() {
        return successPagePath;
    }

}
