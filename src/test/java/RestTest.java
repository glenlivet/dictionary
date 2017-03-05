import org.glenlivet.dict.domain.json.WordJson;
import org.glenlivet.dict.rest.WordsApiHttpRequestInterceptor;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by glenlivet on 3/5/17.
 */
public class RestTest {

    private String mashapeKey="D6JFLd4SxrmshIIu4saYPb51AxGfp1Rl2f9jsnSeGKs9uJbQks";

    @Test
    @Ignore
    public void test() {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Mashape-Key", "dlxNzzaPwEmshzIJPZFAkPgSbzR8p1lSNnAjsn08umWagrF4VA");
        HttpEntity entity = new HttpEntity(headers);
        WordJson json = restTemplate.exchange("https://wordsapiv1.p.mashape.com/words/girl", HttpMethod.GET, entity, WordJson.class).getBody();
        Assert.assertEquals("girl", json.getWord());
    }
}
