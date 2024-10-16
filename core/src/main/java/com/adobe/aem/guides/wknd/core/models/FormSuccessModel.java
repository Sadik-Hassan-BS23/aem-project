package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class)
public class FormSuccessModel {
    @Inject
    private SlingHttpServletRequest request;

    public String getName() {
        return request.getParameter("name");
    }

    public String getAge() {
        return request.getParameter("age");
    }
}
