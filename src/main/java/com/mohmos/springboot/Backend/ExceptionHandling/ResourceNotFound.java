package com.mohmos.springboot.Backend.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
    private String resourcaName;
    private String fieldname;
    private Object fieldValue;


    /**
     * creating a custom  error message if employee doesnt exist
     * @param resourcaName take the database nameas string
     * @param fieldname take the field name as string
     * @param fieldValue take the obect value
     */
    public ResourceNotFound(String resourcaName, String fieldname, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourcaName, fieldname, fieldValue));
        this.resourcaName = resourcaName;
        this.fieldname = fieldname;
        this.fieldValue = fieldValue;
    }

    public String getResourcaName() {
        return resourcaName;
    }

    public String getFieldname() {
        return fieldname;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
