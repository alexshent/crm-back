package ua.alexshent.crm.controller.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ua.alexshent.crm.model.Employee;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
https://www.baeldung.com/jackson-custom-serialization
 */

public class EmployeeSerializer extends StdSerializer<Employee> {

    public EmployeeSerializer() {
        this(null);
    }

    public EmployeeSerializer(Class<Employee> t) {
        super(t);
    }

    @Override
    public void serialize(Employee employee, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        // id
        jsonGenerator.writeStringField("id", employee.getId().toString());

        // first name
        jsonGenerator.writeStringField("firstName", employee.getFirstName());

        // last name
        jsonGenerator.writeStringField("lastName", employee.getLastName());

        // full name
        jsonGenerator.writeStringField("name", employee.getFullName());

        // job title
        jsonGenerator.writeStringField("jobTitle", employee.getJobTitle());

        // department string
        //jsonGenerator.writeStringField("departmentString", employee.get);

        // department
        jsonGenerator.writeObjectField("department", employee.getDepartment());

        // notes
        jsonGenerator.writeStringField("notes", employee.getNotes());

        // status
        jsonGenerator.writeObjectField("status", employee.getStatus());

        // office phone
        jsonGenerator.writeStringField("officePhone", employee.getOfficePhone().getNumber());

        // mobile phone
        jsonGenerator.writeStringField("mobilePhone", employee.getMobilePhone().getNumber());

        // primary address string
        jsonGenerator.writeStringField("primaryAddressString", employee.getPrimaryAddress().toString());

        // primary address
        jsonGenerator.writeObjectField("primaryAddress", employee.getPrimaryAddress());

        // primary email
        jsonGenerator.writeStringField("primaryEmail", employee.getPrimaryEmail().getEmail());

        // alternate emails
        jsonGenerator.writeFieldName("alternateEmails");
        List<String> alternateEmails = new ArrayList<>();
        employee.getAlternateEmails().forEach(emailAddress -> alternateEmails.add(emailAddress.getEmail()));
        jsonGenerator.writeArray(alternateEmails.toArray(new String[0]), 0, alternateEmails.size());

        // reports to
        //jsonGenerator.writeObjectField("reportsTo", employee.getReportsTo());
        jsonGenerator.writeStringField("reportsTo", employee.getReportsTo().getFullName());

        // created
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String created = employee.getCreated().format(formatter);
        jsonGenerator.writeStringField("created", created);

        jsonGenerator.writeEndObject();
    }
}
