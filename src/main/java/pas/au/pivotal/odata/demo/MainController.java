package pas.au.pivotal.odata.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController
{
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private final String url = "http://services.odata.org/V4/(S(ikjres3r2esakregioq03ll1))/TripPinServiceRW/People";
    private static final JsonParser parser = JsonParserFactory.getJsonParser();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Model model)
    {
        RestTemplate restTemplate = new RestTemplate();
        List<Person> people = new ArrayList<Person>();

        String response = restTemplate.getForObject(url, String.class);

        logger.info("HTTP GET request completed");
        //logger.info(response);

        Map<String, Object> jsonMap = parser.parseMap(response);

        List<Object> valueList = (List<Object>) jsonMap.get("value");
        logger.info("List size " + valueList.size());

        for (Object item: valueList)
        {
            Map m = (Map) item;
            Person p = new Person(
                    (String) m.get("UserName"),
                    (String) m.get("FirstName"),
                    (String) m.get("LastName"),
                    (String) m.get("Gender"),
                    (Long) m.get("Concurrency"));

            logger.info("Person " + p.toString());
            people.add(p);
        }

        model.addAttribute("people", people);

        return "main";
    }
}
