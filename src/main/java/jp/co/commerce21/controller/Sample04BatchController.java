package jp.co.commerce21.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Sample04BatchController {

	private static final Logger logger = LogManager.getLogger(Sample04BatchController.class);
	
	@RequestMapping(value="/sample04/index", method=RequestMethod.GET)
	public String index(Map<String, Object> model) {
		return "sample04/index";
	}
	
	@Scheduled(cron = "0 0 * * * *", zone = "Asia/Tokyo")
	public void batchCronAnnotation() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		logger.info("@@@@@ cronAnnotation実行日時：" + sdf.format(new Date()) + " @@@@@");
	}
	
	@Scheduled(cron = "${scheduler.cron}", zone = "Asia/Tokyo")
	public void batchCronProperties() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		logger.info("@@@@@ cronProperties実行日時：" + sdf.format(new Date()) + " @@@@@");
	}
	
	@Scheduled(initialDelay = 60000, fixedDelay = 3600000)
	public void batchFixedDelay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		logger.info("##### FixedDelay実行日時：" + sdf.format(new Date()) + " #####");
	}
}
