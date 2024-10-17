package com.adobe.aem.guides.wknd.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

import static com.day.cq.dam.api.handler.AssetHandler.log;

@Component(
        service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Form Submission Servlet",
                "sling.servlet.methods=" + "POST",
                "sling.servlet.extensions=" + "submitForm",
                "sling.servlet.paths=" + "/bin/wknd/formsubmit"
        }
)
public class FormSubmitServlet extends SlingAllMethodsServlet {
    private static final Logger log = LoggerFactory.getLogger(FormSubmitServlet.class);


    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        try {
            // Get form parameters
            String name = request.getParameter("name");
            String age = request.getParameter("age");

            // Check for null or empty parameters
            if (name == null || name.isEmpty() || age == null || age.isEmpty()) {
                response.sendError(SlingHttpServletResponse.SC_BAD_REQUEST, "Name and Age are required.");
                return;
            }

            // Log the form submission
            log.info("Form Submitted - Name: {}, Age: {}", name, age);

            // Redirect to success page with query parameters
            response.sendRedirect("/content/wknd/us/en/success.html?name=" + name + "&age=" + age);

        } catch (Exception e) {
            log.error("Error processing form submission", e);
            response.sendError(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
        }
    }

}
