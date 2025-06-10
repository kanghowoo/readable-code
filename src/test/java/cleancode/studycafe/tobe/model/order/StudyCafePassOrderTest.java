package cleancode.studycafe.tobe.model.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;

class StudyCafePassOrderTest {

    @DisplayName("할인이 있는 주문의 총 금액을 계산할 수 있다.")
    @Test
    void getTotalPriceWithDiscount() {
        //given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(
                StudyCafePassType.FIXED, 4, 250_000, 0.1);

        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(
                StudyCafePassType.FIXED, 4, 10_000);

        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

        //when
        int totalPrice = order.getTotalPrice();

        //then
        assertThat(totalPrice).isEqualTo(250_000 + 10_000 - 25_000);
    }

    @DisplayName("할인이 없는 주문의 총 금액을 계산할 수 있다.")
    @Test
    void getTotalPriceWithoutDiscount() {
        //given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(
                StudyCafePassType.FIXED, 4, 250_000, 0);

        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(
                StudyCafePassType.FIXED, 4, 10_000);

        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

        //when
        int totalPrice = order.getTotalPrice();

        //then
        assertThat(totalPrice).isEqualTo(250_000 + 10_000);
    }

    @DisplayName("할인이 있고, 사물함권이 없는 주문의 총 금액을 구할 수 있다.")
    @Test
    void getTotalPriceHasNotLockerPassWithDiscount() {

        //given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(
                StudyCafePassType.FIXED, 4, 250_000, 0.1);

        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, null);

        //when
        int totalPrice = order.getTotalPrice();

        //then
        assertThat(totalPrice).isEqualTo(250_000 - 25_000);
    }

    @DisplayName("할인이 없고, 사물함권도 없는 주문의 총 금액을 구할 수 있다.")
    @Test
    void getTotalPriceHasNotLockerPassWithoutDiscount() {
        //given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(
                StudyCafePassType.FIXED, 4, 250_000, 0);

        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, null);

        //when
        int totalPrice = order.getTotalPrice();

        //then
        assertThat(totalPrice).isEqualTo(250_000);

    }
}
