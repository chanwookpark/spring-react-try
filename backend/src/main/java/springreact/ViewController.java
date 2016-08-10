package springreact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chanwook
 */
@Controller
public class ViewController {

    @Autowired
    Environment env;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index-serverside");
        final String staticHost = env.getProperty("static.host");
        mav.addObject("staticHost", staticHost);
        return mav;
    }
}
