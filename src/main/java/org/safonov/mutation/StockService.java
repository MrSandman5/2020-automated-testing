package org.safonov.mutation;

public class StockService {

    private int quantity;

    public StockService(final int qtyOnHand) {
        this.quantity = qtyOnHand;
    }

    private void isValidQty(final int qty) {
        if (qty < 0) {
            throw new IllegalArgumentException("Quality should be positive!");
        }
    }

    public int add(final int qty) {
        isValidQty(qty);
        quantity = quantity + qty;
        return quantity;
    }

    public int deduct(final int qty) {
        isValidQty(qty);

        final int newQty = quantity - qty;
        if (newQty < 0) {
            throw new IllegalArgumentException("Out of Stock!");
        } else {
            quantity = newQty;
        }
        return quantity;
    }
}
