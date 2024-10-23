package com.adobe.aem.guides.wknd.core.models;

import com.adobe.cq.wcm.core.components.models.Teaser;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Teaser.class,
        resourceType = "wknd/components/customteaser",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomTeaserModel implements Teaser {

    @SlingObject
    private Resource resource;

    @Inject
    private Teaser coreTeaser;

    private String selectedPath;

    @Inject
    public String getSelectedPath() {
        return selectedPath;
    }

    @PostConstruct
    protected void init() {
        if (selectedPath != null && !selectedPath.matches(".*\\.[a-zA-Z]+$")) {
            selectedPath = selectedPath.concat(".html"); // Add .html only if it's not a file or page
        }
    }

    @Override
    public String getTitle() {
        return coreTeaser.getTitle();
    }

    @Override
    public String getDescription() {
        return coreTeaser.getDescription();
    }

    @Override
    public String getLinkURL() {
        return coreTeaser.getLinkURL();
    }

    public String getCustomMessage() {
        return "Custom teaser message!";
    }


}
