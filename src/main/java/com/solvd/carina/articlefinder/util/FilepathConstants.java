package com.solvd.carina.articlefinder.util;

import com.solvd.carina.articlefinder.exception.GetResourcesPathFailureException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URISyntaxException;

public final class FilepathConstants {

    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.FILEPATH_CONSTANTS);
    /*
        From `resources/`
    */
    public static final String RESOURCES_ABSOLUTE_PATH = getAbsolutePathOfResource();

    public static final String CONFIG_PROPERTIES = "_config.properties";
    public static final String TESTNG_SUITES_DIR_IN_RESOURCES_FILEPATH = "testng_suites/";
    public static final String API_DIR_IN_RESOURCES_FILEPATH = "api/";
    public static final String API_ARTICLE_SEARCH_IN_RESOURCES_FILEPATH =
            API_DIR_IN_RESOURCES_FILEPATH + "article_search/";

    /*
        *.json file paths
     */
    public static final String ARTICLE_SEARCH_RS_TEMPLATE_JSON =
            API_ARTICLE_SEARCH_IN_RESOURCES_FILEPATH + "article_search_rs.json";
    public static final String ARTICLE_SEARCH_RS_SCHEMA_JSON =
            API_ARTICLE_SEARCH_IN_RESOURCES_FILEPATH + "article_search_rs_schema.json";

    public static final String ARTICLE_SEARCH_400_RS_TEMPLATE_JSON =
            API_ARTICLE_SEARCH_IN_RESOURCES_FILEPATH + "article_search_400_rs.json";
    public static final String ARTICLE_SEARCH_400_RS_SCHEMA_JSON =
            API_ARTICLE_SEARCH_IN_RESOURCES_FILEPATH + "article_search_400_rs_schema.json";

    public static final String ARTICLE_SEARCH_FAULT_RS_TEMPLATE_JSON =
            API_ARTICLE_SEARCH_IN_RESOURCES_FILEPATH + "article_search_fault_rs.json";
    public static final String ARTICLE_SEARCH_FAULT_RS_SCHEMA_JSON =
            API_ARTICLE_SEARCH_IN_RESOURCES_FILEPATH + "article_search_fault_rs_schema.json";

    /*
        XML Test NG Suites
     */


    private static String getAbsolutePathOfResource() {
        final String FILE_URI_SCHEME = "file:";
        final String MAVEN_COMPILATION_CLASSES_SUBPATH = "target/classes";
        final String SRC_MAIN_RESOURCES_SUBPATH = "src/main/resources";

        try {
            return ClassConstants.FILEPATH_CONSTANTS
                    .getClassLoader()
                    .getResource(StringConstants.EMPTY_STRING)
                    .toURI()
                    .toString()
                    .replace(FILE_URI_SCHEME, StringConstants.EMPTY_STRING)
                    .replace(MAVEN_COMPILATION_CLASSES_SUBPATH, SRC_MAIN_RESOURCES_SUBPATH);
        } catch (URISyntaxException e) {
            throw new GetResourcesPathFailureException("Failed to get absolute resources path:" + e);
        }
    }

    private FilepathConstants() {
        ExceptionUtils.preventConstantsInstantiation();
    }
}
