package tk.springboot;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.springboot.model.Country;
import tk.springboot.mybatis.mapper.CountryMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestES {
    @Autowired
    private RestClient restClient;
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Autowired
    private RestClientBuilder restClientBuilder;
    @Autowired
    private CountryMapper countryMapper;

    /**
     * 批量添加数据到指定索引
     * @throws IOException
     */
    @Test
    public void createIndex() throws IOException {
        List<Country> countryList = countryMapper.selectAll();
        for(Country country:countryList) {
            Map<String, String> countryMap = new HashMap<>();
            countryMap.put("countrycode", country.getCountrycode());
            countryMap.put("countryname", country.getCountryname());
            IndexRequest indexRequest = new IndexRequest("country").id(country.getId() + "").source(countryMap);

            restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        }
    }

    /**
     * 判断索引是否存在
     * @throws IOException
     */
    @Test
    public void existsIndex() throws IOException {
        GetIndexRequest getRequest = new GetIndexRequest("country");
        getRequest.local(false);
        getRequest.humanReadable(true);
        boolean result = restHighLevelClient.indices().exists(getRequest, RequestOptions.DEFAULT);

        System.out.println(result);
    }

    /**
     * 删除索引
     * @throws IOException
     */
    @Test
    public void delIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("country");
        AcknowledgedResponse deleteIndexResponse = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        boolean result = deleteIndexResponse.isAcknowledged();

        System.out.println(result);
    }

    /**
     * 根据ID删除索引数据
     * @throws IOException
     */
    @Test
    public void delIndexById() throws IOException {
        DeleteRequest request = new DeleteRequest("country","2");
        DeleteResponse response = restHighLevelClient.delete(request,RequestOptions.DEFAULT);
        boolean result = response.isFragment();

        System.out.println(result);
    }

    /**
     * 搜索全部数据
     */
    @Test
    public void search01(){
        SearchRequest searchRequest = new SearchRequest("country");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //sourceBuilder.query(QueryBuilders.termQuery("id", "3"));
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            Arrays.stream(response.getHits().getHits())
                    .forEach(i -> {
                        System.out.println(i.getIndex());
                        System.out.println(i.getSourceAsMap());
                        System.out.println(i.getType());
                    });
            System.out.println("TotalHits: "+response.getHits().getTotalHits());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 精确匹配
     */
    @Test
    public void search02(){
        SearchRequest searchRequest = new SearchRequest("country");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("countrycode", "CN"));
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            Arrays.stream(response.getHits().getHits())
                    .forEach(i -> {
                        System.out.println(i.getIndex());
                        System.out.println(i.getSourceAsMap());
                        System.out.println(i.getType());
                    });
            System.out.println("TotalHits: "+response.getHits().getTotalHits());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 非精确匹配
     */
    @Test
    public void search03(){
        SearchRequest searchRequest = new SearchRequest("country");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("countryname", "lan"));
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            Arrays.stream(response.getHits().getHits())
                    .forEach(i -> {
                        System.out.println(i.getIndex());
                        System.out.println(i.getSourceAsMap());
                        System.out.println(i.getType());
                    });
            System.out.println("TotalHits: "+response.getHits().getTotalHits());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
