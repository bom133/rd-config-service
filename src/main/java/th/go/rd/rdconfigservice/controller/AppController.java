package th.go.rd.rdconfigservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@Configuration
@RestController
@RequestMapping("/config")
public class AppController {
	
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	@Value("${application.name}")
    private String applicationName;

    @Value("${build.version}")
    private String buildVersion;

    @Value("${build.timestamp}")
    private String buildTimestamp;
    
    @Autowired
	private MessageSource messageSource; 
    
    @GetMapping(value = "/appinfo")
	public String appInfo() {
    	Object[] obj = {applicationName,buildVersion,buildTimestamp};
    	String msg = messageSource.getMessage("msg.app.info",obj, LocaleContextHolder.getLocale());
    	logger.debug(msg);
		return msg;
	}
    
}
