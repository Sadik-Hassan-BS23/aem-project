package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.models.FormComponent;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletResourceTypes(resourceTypes = FormComponent.RESOURCE_TYPE, methods = "POST", extensions = "submit", selectors = "json")
public class FormServlet extends SlingAllMethodsServlet {
    private static final Logger log = LoggerFactory.getLogger(FormServlet.class);
    private static final Gson gson = new Gson();

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        try {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            log.info("Form submitted: {} {}", firstName, lastName);
            response.getWriter().write(gson.toJson(new FormResponse("success", "Form submitted successfully")));
        } catch (Exception e) {
            log.error("Error processing form submission", e);
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(gson.toJson(new FormResponse("error", e.getMessage())));
        }
    }

    private static class FormResponse {
        private String status;
        private String message;

        FormResponse(String status, String message) {
            this.status = status;
            this.message = message;
        }
    }
}