package com.solvd.carina.articlefinder.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.solvd.carina.articlefinder.exception.ReadJsonFailureException;
import com.solvd.carina.articlefinder.exception.WriteToJsonFailureException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

public class JacksonUtils {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.JACKSON_UTILS);

    /*
        Generic methods
    */

    public static <T> T deserializeJson(String json, Class<T> valueType) {
        T readMapperValue = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            readMapperValue = mapper.readValue(json, valueType);

        } catch (IOException e) {
            LOGGER.error("Could not deserialize JSON");
            throw new ReadJsonFailureException("Could not deserialize JSON");
        }
        return readMapperValue;
    }


    public static <T> List<T> parseJsonResource(String resourcePath, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper
                .getTypeFactory()
                .constructCollectionType(ClassConstants.JAVA_UTIL_LIST, clazz);

        try (
                InputStream inputStream = ClassConstants.JACKSON_UTILS
                        .getClassLoader()
                        .getResourceAsStream(resourcePath)
        ) {
            if (inputStream == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }
            return mapper.readValue(inputStream, type);
        } catch (IOException e) {
            LOGGER.error("Error reading resource file: " + resourcePath, e);
            throw new ReadJsonFailureException("Error reading resource file: " + resourcePath + e);
        }
    }

    public static <T> void writeToJSON(String filepath, List<T> items) {
        ObjectMapper mapper = new ObjectMapper();

        SimpleDateFormat dateFormat = new SimpleDateFormat(StringConstants.TIMESTAMP_PATTERN);
        mapper.setDateFormat(dateFormat);

        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

        try {

            String filepathFromResourcesDir =
                    FilepathConstants.RESOURCES_ABSOLUTE_PATH + filepath;

            File jsonToWriteTo = new File(filepathFromResourcesDir);


            writer.writeValue(jsonToWriteTo, items);
        } catch (IOException e) {
            LOGGER.error("Error writing to file: " + filepath, e);
            throw new WriteToJsonFailureException("Error writing to file: " + filepath + e);
        }
    }

    private JacksonUtils() {
        ExceptionUtils.preventUtilityInstantiation();
    }
}
