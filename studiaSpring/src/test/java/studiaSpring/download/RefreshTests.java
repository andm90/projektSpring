package studiaSpring.download;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class RefreshTests {
	
	@Test
	public void checkOutOfcreateDateOfTheDay() {
		
		Refresh tempRefresh = new Refresh(null, null);
		
		new Refresh(null, null);
		String[] stringOfDate = {"2020-11-22"};
		
		Assert.assertEquals(tempRefresh.createDateOfTheDay(stringOfDate), LocalDate.of(2020,11,22));
	}
	@Test
	public void shouldThrownIOExceptionWrongParameters() {
		
		Refresh tempRefresh = new Refresh(null, null);
		try {
			tempRefresh.update();
			fail("Exception wasn't thrown!");
		}catch(IOException e) {
			assertEquals("problem with connect with external web", e.getMessage());
			
		}
	}
}
