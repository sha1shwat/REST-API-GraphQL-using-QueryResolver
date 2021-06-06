package com.graphqlmutation.graphql.utility;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;


public class QueryParamWrapper {

    private ObjectMapper mapper;

    public QueryParamWrapper() {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public <T> T getObjectFromJson(String json, Class<T> classOfType) {
        T response = null;
        try {
            if(StringUtils.isNotBlank(json)){
                response = mapper.readValue(json, classOfType);
            }

        } catch (Exception ex) {


        }
        return response;
    }

    public <T> String getJsonFromObject(T inpuTPojo) {
        String json = null;
        try {
            if(inpuTPojo != null){
                json = mapper.writeValueAsString(inpuTPojo);
            }
        } catch (Exception e) {

        }
        return json;

    }

}
