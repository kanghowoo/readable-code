package cleancode.studycafe.tobe.model.pass;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafePassTypeTest {


    @Test
    @DisplayName("FIXED Type 은 락커 타입이다")
    void fixedIsLockerType() {
        assertTrue(StudyCafePassType.FIXED.isLockerType());
        assertFalse(StudyCafePassType.FIXED.isNotLockerType());
    }

    @Test
    @DisplayName("HOURLY Type 은 락커 타입이 아니다")
    void hourlyIsNotLockerType() {
        assertFalse(StudyCafePassType.HOURLY.isLockerType());
        assertTrue(StudyCafePassType.HOURLY.isNotLockerType());
    }

    @Test
    @DisplayName("WEEKLY Type 은 락커 타입이 아니다")
    void weeklyIsNotLockerType() {
        assertFalse(StudyCafePassType.WEEKLY.isLockerType());
        assertTrue(StudyCafePassType.WEEKLY.isNotLockerType());
    }
}
