import com.hib.entities.GuestBook;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

class WebConfig {
    private FreeMarkerEngine freeMarkerEngine;

    private List<GuestBook> records;

    WebConfig() {
        staticFileLocation("/public");

        ipAddress("localhost");
        port(80);

        Configuration freeMarkerConfiguration = new Configuration();

        freeMarkerEngine = new FreeMarkerEngine();
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Main.class, "/public"));
        freeMarkerEngine.setConfiguration(freeMarkerConfiguration);

        records = HibernateUtil.getEntities();

        setupRoutes();
    }

    void setupRoutes() {
        get("/", (request, response) -> {

            Map<Object, Object> map = new HashMap<>();
            map.put("records", records);

            return freeMarkerEngine.render(new ModelAndView(map, "book.ftl"));
        });

        post("/", (request, response) -> {

            String name = request.queryParams("name");
            String text = request.queryParams("text");

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            GuestBook guestBook = new GuestBook(name, dateFormat.format(date), text);

            HibernateUtil.save(guestBook);

            records.add(guestBook);

            Map<Object, Object> map = new HashMap<>();
            map.put("records", records);

            return freeMarkerEngine.render(new ModelAndView(map, "book.ftl"));
        });

    }

}
