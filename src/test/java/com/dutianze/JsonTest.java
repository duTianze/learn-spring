package com.dutianze;

import com.jayway.jsonpath.*;
import lombok.Data;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.jayway.jsonpath.Criteria.where;

/**
 * @author: dutianze
 * Date: 2019-11-22
 */
public class JsonTest {

    @Test
    public void test_entity() {
        String jsonStr = new Entity().getName();
        ReadContext ctx =
                JsonPath.using(Configuration.defaultConfiguration()
                                            .addOptions(Option.SUPPRESS_EXCEPTIONS))
                        .parse(jsonStr);
        // list值
        List<String> authors = ctx.read("$.store.book[*].author");
        System.out.println(authors);
        // 单个值
        String author0 = ctx.read("$.store.book[0].author");
        System.out.println(author0);
        String author1 = ctx.read("$.store.book[1].author");
        System.out.println(author1);
        // 指定返回类型 可以转换
        String json = "{\"date_as_long\" : 1411455611975}";
        Date date = JsonPath.parse(json).read("$['date_as_long']", Date.class);
        System.out.println(date);
    }

    /**
     * 返回路径
     */
    @Test
    public void testGetPath() {
        String jsonStr = new Entity().getName();
        ReadContext ctx =
                JsonPath.using(Configuration.defaultConfiguration()
                                            .addOptions(Option.SUPPRESS_EXCEPTIONS)
                                            .addOptions(Option.AS_PATH_LIST))
                        .parse(jsonStr);
        List<String> author0 = ctx.read("$..author");
        System.out.println(author0);
    }

    /**
     * 添加过滤
     */
    @Test
    public void testPredicates() {
        String jsonStr = new Entity().getName();
        ReadContext ctx =
                JsonPath.using(Configuration.defaultConfiguration()
                                            .addOptions(Option.SUPPRESS_EXCEPTIONS))
                        .parse(jsonStr);
        // 内联
        List<Map<String, Object>> books = ctx.read("$.store.book[?(!(@.price < 10 && @.category == 'fiction'))]");
        System.out.println(books);
        // API
        Filter cheapFictionFilter = Filter.filter(
                where("category").is("fiction").and("price").lte(10D)
        );
        List<Map<String, Object>> books2 = ctx.read("$.store.book[?]", cheapFictionFilter);
        System.out.println(books2);
        // 自定义
        Predicate booksWithISBN = ctx1 -> ctx1.item(Map.class).containsKey("isbn");
        List<Map<String, Object>> books3 =
                ctx.read("$.store.book[?].isbn", List.class, booksWithISBN);
        System.out.println(books3);
    }

    @Data
    public static class Entity {
        private String name = "{\n" +
                              "    \"store\": {\n" +
                              "        \"book\": [\n" +
                              "            {\n" +
                              "                \"category\": \"reference\",\n" +
                              "                \"author\": \"Nigel Rees\",\n" +
                              "                \"title\": \"Sayings of the Century\",\n" +
                              "                \"price\": 8.95\n" +
                              "            },\n" +
                              "            {\n" +
                              "                \"category\": \"fiction\",\n" +
                              "                \"author\": \"Evelyn Waugh\",\n" +
                              "                \"title\": \"Sword of Honour\",\n" +
                              "                \"price\": 12.99\n" +
                              "            },\n" +
                              "            {\n" +
                              "                \"category\": \"fiction\",\n" +
                              "                \"author\": \"Herman Melville\",\n" +
                              "                \"title\": \"Moby Dick\",\n" +
                              "                \"isbn\": \"0-553-21311-3\",\n" +
                              "                \"price\": 8.99\n" +
                              "            },\n" +
                              "            {\n" +
                              "                \"category\": \"fiction\",\n" +
                              "                \"author\": \"J. R. R. Tolkien\",\n" +
                              "                \"title\": \"The Lord of the Rings\",\n" +
                              "                \"isbn\": \"0-395-19395-8\",\n" +
                              "                \"price\": 22.99\n" +
                              "            }\n" +
                              "        ],\n" +
                              "        \"bicycle\": {\n" +
                              "            \"color\": \"red\",\n" +
                              "            \"price\": 19.95\n" +
                              "        }\n" +
                              "    },\n" +
                              "    \"expensive\": 10\n" +
                              "}";
    }
}
