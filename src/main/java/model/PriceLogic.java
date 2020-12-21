package model;

import java.math.BigDecimal;

public class PriceLogic {

    public PriceLogic() {
    }

    public BigDecimal PriceLogic(CarSegment carSegment) {
        switch (carSegment) {
            case SEGMENT_A:
                System.out.println("60pln/day");
                break;
            case SEGMENT_B:
                System.out.println("65 pln/day");
                break;
            case SEGMENT_C:
                System.out.println("70 pln/day");
                break;
            case SEGMENT_D:
                System.out.println("75 pln/day");
                break;
            case SEGMENT_E:
                System.out.println("80 pln/day");
                break;
            case SEGMENT_F:
                System.out.println("85 pln/day");
                break;
            case SEGMENT_G:
                System.out.println("90 pln/day");
                break;
            case SEGMENT_H:
                System.out.println("95 pln/day");
                break;
            case SEGMENT_I:
                System.out.println("100 pln/day");
                break;
            case SEGMENT_K:
                System.out.println("120 pln/day");
                break;

        }
        return PriceLogic(carSegment);
    }


    public void priceLogicAdditionalCost(Car car) {
        if (car.isDamaged()) {

        }
    }
}
