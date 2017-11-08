package hello;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    private static final String template = "Catalog Record: %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Catalog postCatalogInfo(@RequestParam(value="name", required=false, defaultValue="Default Resource") String name) {
        return new Catalog(counter.incrementAndGet(), String.format(template, name));
    }

}
