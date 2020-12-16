package org.safonov.mutation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StockServiceTest {

    @DisplayName("Test deduct stock")
    @Test
    public void testDeduct() {
        final StockService obj = new StockService(100);
        assertEquals(90, obj.deduct(10));
        assertEquals(0, obj.deduct(90));
        assertEquals(0, obj.deduct(0));

        assertThrows(IllegalArgumentException.class, () -> obj.deduct(-1));
        assertThrows(IllegalArgumentException.class, () -> obj.deduct(100));

    }

    @DisplayName("Test add stock")
    @Test
    public void testAdd() {
        final StockService obj = new StockService(100);
        assertEquals(110, obj.add(10));
        assertEquals(110, obj.add(0));

        assertThrows(IllegalArgumentException.class, () -> obj.add(-1));
    }
}
