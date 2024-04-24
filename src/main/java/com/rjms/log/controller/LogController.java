/**
 * 
 */
package com.rjms.log.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

/**
 * @author Pavithra Chandrasekaran
 *
 */
@RestController
@RequestMapping(path = "/rjms")
public class LogController {

	public static final Logger logger = LogManager.getLogger(LogController.class);

	@GetMapping(path = "/info")
	public ResponseEntity<Object> genLogs(@RequestParam("count") int count, @RequestParam("interval") int interval) {
		for (int i = 0; i < count; i++) {
			logger.info("Message count : {}", i+1);
			try {
				Thread.sleep(interval*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ResponseEntity.ok().build();
	}

	@GetMapping(path = "/error")
	public ResponseEntity<Object> genErrorLogs(@RequestParam("count") int count, @RequestParam("interval") int interval) {
		for (int i = 0; i < count; i++) {
			logger.error("Error count : {}", i+1);
			try {
				Thread.sleep(interval*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ResponseEntity.ok().build();
	}

}
