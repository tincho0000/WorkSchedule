package com.timetracker.app;

import com.workschedule.app.TimeTrackerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TimeTrackerApplication.class)
class TimeTrackerApplicationTests {

	@Test
	void contextLoads() {
		assertEquals(true, true);
	}

}
