package zerobase.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherApplicationTests {

    @Test
    void equalTest(){
        assertEquals(1,1);
    }

    @Test
    void nullTest(){
        assertNull(null);
    }

    @Test
    void trueTest(){
        assertTrue(true);
    }

}
