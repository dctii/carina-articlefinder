package com.solvd.carina.articlefinder.util;

import com.solvd.carina.articlefinder.api.ArticleSearch;
import com.solvd.carina.articlefinder.api.BadArticleSearch;
import com.solvd.carina.articlefinder.api.UnauthorizedArticleSearch;
import com.solvd.carina.articlefinder.bin.AbstractResponse;
import com.solvd.carina.articlefinder.bin.Article;
import com.solvd.carina.articlefinder.bin.ArticleSearchMeta;
import com.solvd.carina.articlefinder.bin.ArticleSearchResponse;
import com.solvd.carina.articlefinder.bin.BadResponse;
import com.solvd.carina.articlefinder.bin.Byline;
import com.solvd.carina.articlefinder.bin.Fault;
import com.solvd.carina.articlefinder.bin.FaultDetail;
import com.solvd.carina.articlefinder.bin.FaultResponse;
import com.solvd.carina.articlefinder.bin.Headline;
import com.solvd.carina.articlefinder.bin.Keyword;
import com.solvd.carina.articlefinder.bin.Legacy;
import com.solvd.carina.articlefinder.bin.MultimediaItem;
import com.solvd.carina.articlefinder.bin.Person;
import com.solvd.carina.articlefinder.bin.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class ClassConstants {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.class);
    private ClassConstants() {
        ExceptionUtils.preventConstantsInstantiation();
    }

    // java.util
    public static final Class<List> JAVA_UTIL_LIST = List.class;

    // com.zebrunner.carina.api.apitools.builder
    public static final Class<com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor> NOT_STRING_VALUES_PROCESSOR =
            com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor.class;

    // com.solvd.carina.articlefinder
    public static final Class<com.solvd.carina.articlefinder.Main> MAIN_ENTRYPOINT = com.solvd.carina.articlefinder.Main.class;

    // com.solvd.carina.articlefinder.api
    public static final Class<ArticleSearch> ARTICLE_SEARCH = ArticleSearch.class;
    public static final Class<BadArticleSearch> BAD_ARTICLE_SEARCH = BadArticleSearch.class;
    public static final Class<UnauthorizedArticleSearch> UNAUTHORIZED_ARTICLE_SEARCH = UnauthorizedArticleSearch.class;

    // com.solvd.carina.articlefinder.bin
    public static final Class<AbstractResponse> ABSTRACT_RESPONSE = AbstractResponse.class;
    public static final Class<Article> ARTICLE = Article.class;
    public static final Class<ArticleSearchMeta> ARTICLE_SEARCH_META = ArticleSearchMeta.class;
    public static final Class<ArticleSearchResponse> ARTICLE_SEARCH_RESPONSE = ArticleSearchResponse.class;
    public static final Class<BadResponse> BAD_RESPONSE = BadResponse.class;
    public static final Class<Byline> BYLINE = Byline.class;
    public static final Class<Fault> FAULT = Fault.class;
    public static final Class<FaultDetail> FAULT_DETAIL = FaultDetail.class;
    public static final Class<FaultResponse> FAULT_RESPONSE = FaultResponse.class;
    public static final Class<Headline> HEADLINE = Headline.class;
    public static final Class<Keyword> KEYWORD = Keyword.class;
    public static final Class<Legacy> LEGACY = Legacy.class;
    public static final Class<MultimediaItem> MULTIMEDIA_ITEM = MultimediaItem.class;
    public static final Class<Person> PERSON = Person.class;
    public static final Class<Response> RESPONSE = Response.class;


    // com.solvd.carina.articlefinder.util
    public static final Class<AnsiCodes> ANSI_CODES = AnsiCodes.class;
    public static final Class<ArrayUtils> ARRAY_UTILS = ArrayUtils.class;
    public static final Class<ArticleSearchResponseConstants> ARTICLE_SEARCH_RESPONSE_CONSTANTS = ArticleSearchResponseConstants.class;
    public static final Class<BigDecimalUtils> BIG_DECIMAL_UTILS = BigDecimalUtils.class;
    public static final Class<BooleanUtils> BOOLEAN_UTILS = BooleanUtils.class;
    public static final Class<CollectionUtils> COLLECTION_UTILS = CollectionUtils.class;
    public static final Class<ClassConstants> CLASS_CONSTANTS = ClassConstants.class;
    public static final Class<ConfigConstants> CONFIG_CONSTANTS = ConfigConstants.class;
    public static final Class<ConfigLoader> CONFIG_LOADER = ConfigLoader.class;
    public static final Class<DateTimeConstants> DATE_TIME_CONSTANTS = DateTimeConstants.class;
    public static final Class<DateTimeUtils> DATE_TIME_UTILS = DateTimeUtils.class;
    public static final Class<ExceptionUtils> EXCEPTION_UTILS = ExceptionUtils.class;
    public static final Class<FacetConstants> FACET_CONSTANTS = FacetConstants.class;
    public static final Class<FilepathConstants> FILEPATH_CONSTANTS = FilepathConstants.class;
    public static final Class<FilterQueryConstants> FILTER_QUERY_CONSTANTS = FilterQueryConstants.class;
    public static final Class<JacksonUtils> JACKSON_UTILS = JacksonUtils.class;
    public static final Class<NumberUtils> NUMBER_UTILS = NumberUtils.class;
    public static final Class<QueryParameter> QUERY_PARAMETER = QueryParameter.class;
    public static final Class<QueryParametersConstants> QUERY_PARAMETERS_CONSTANTS = QueryParametersConstants.class;
    public static final Class<QueryStringBuilder> QUERY_STRING_BUILDER = QueryStringBuilder.class;
    public static final Class<QueryStringUtils> QUERY_STRING_UTILS = QueryStringUtils.class;
    public static final Class<ReflectionUtils> REFLECTION_UTILS = ReflectionUtils.class;
    public static final Class<RegExpConstants> REG_EXP_CONSTANTS = RegExpConstants.class;

    public static final Class<StringConstants> STRING_CONSTANTS = StringConstants.class;
    public static final Class<StringFormatters> STRING_FORMATTERS = StringFormatters.class;

}
