package ru.lanit.bpm.yodata.adapter.pageparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;

@Component
public class JsoupPageParser implements PageParser {
    @Override
    public String getUrlContent(String url, String xPath) {
//        HttpClient client = HttpClient.newBuilder().build();
//
//        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("http://ya.ru")).build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        response.headers();
        try{
            Document document = Jsoup.connect(url).get();
            return evaluateXpath(xPath, document);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String evaluateXpath(String xPath, Document document) {
        return Xsoup.compile(xPath).evaluate(document).get();
    }


}
