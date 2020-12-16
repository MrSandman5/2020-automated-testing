package org.safonov.mutation;

public class StockService {

    private int qtyOnHand;

    public StockService(final int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    private void isValidQty(final int qty) {
        if (qty < 0) {
            throw new IllegalArgumentException("Quality should be positive!");
        }
    }

    public int add(final int qty) {
        isValidQty(qty);
        qtyOnHand = qtyOnHand + qty;
        return qtyOnHand;
    }

    public int deduct(final int qty) {
        isValidQty(qty);

        final int newQty = qtyOnHand - qty;
        if (newQty < 0) {
            throw new IllegalArgumentException("Out of Stock!");
        } else {
            qtyOnHand = newQty;
        }
        return qtyOnHand;
    }
}
