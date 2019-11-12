package com.ada.tool.search.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;

/**
 * @author Ada
 * @ClassName :QueryUtil
 * @date 2019/11/11 22:12
 * @Description:
 */
public class QueryUtil {

    private static String queryStringFilter(String query) {
        return query.replace("/", " ").replace("\\", " ");
    }

    public static Query query(String query, Analyzer analyzer, String... fields) throws ParseException {
        BooleanQuery.setMaxClauseCount(32768);
        /*过滤非法字符*/
        query = queryStringFilter(query);
        MultiFieldQueryParser parser = new MultiFieldQueryParser(fields, analyzer);
        parser.setDefaultOperator(QueryParser.Operator.OR);
        return parser.parse(query);
    }
}
