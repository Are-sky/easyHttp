package cn.hiles.config.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

/**
 * description
 *
 * @author Helios
 * Time：2023-04-17 20:50
 */
public class Json {
    private static  ObjectMapper myObjectMapper = defaultObjectMapper();

    /**
     * Create a default ObjectMapper instance to avoid the cost of repeatedly creating objects
     * @return default ObjectMapper
     */
    private static ObjectMapper defaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //When deserializing JSON data, if an unknown attribute is encountered, no exception will be thrown.
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    /**
     * Parse a json string to JsonNode
     * @param json json string
     * @return JsonNode
     * @throws JsonProcessingException if the json string is invalid
     */
    public static JsonNode parse(String json) throws JsonProcessingException {
        return myObjectMapper.readTree(json);
    }

    /**
     * Parse a json string to a specific class
     * @param node JsonNode
     * @param clazz class
     * @return object of class
     * @param <A> class
     * @throws JsonProcessingException if the json string is invalid
     */
    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return myObjectMapper.treeToValue(node, clazz);
    }

    /**
     * Convert a Java object into a JsonNode object for generating JSON data in subsequent processing
     * @param object object
     * @return  JsonNode
     * @throws JsonProcessingException if the json string is invalid
     */
    public static JsonNode toJson(Object object) throws JsonProcessingException {
        return myObjectMapper.valueToTree(object);
    }

    /**
     * Serialize a JsonNode object into a JSON string
     * @param node JsonNode
     * @return json string
     * @throws JsonProcessingException if the json string is invalid
     */
    public static String stringify(JsonNode node) throws JsonProcessingException {
        return generateJson(node,false);
    }

    /**
     * Serialize a JsonNode object into a formatted JSON string with better readability
     * @param node JsonNode
     * @return json string
     * @throws JsonProcessingException if the json string is invalid
     */
    public static String stringifyPretty(JsonNode node) throws JsonProcessingException {
        return generateJson(node,true);
    }

    /**
     * Serialize a Java object into a JSON string and choose whether to format the output
     * @param object object
     * @param pretty whether to format the output
     * @return json string
     * @throws JsonProcessingException if the json string is invalid
     */
    private  static  String generateJson(Object object,boolean pretty) throws JsonProcessingException {
        ObjectWriter objectWriter = myObjectMapper.writer();
        if (pretty){
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }
        return objectWriter.writeValueAsString(object);
    }
}
