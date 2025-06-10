package cleancode.studycafe.tobe.model.pass.locker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;

class StudyCafeLockerPassTest {

    @Test
    @DisplayName("주어진 passType 과 같은 passType 이다.")
    void isSamePassType_true() {
        //given
        StudyCafeLockerPass pass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 100000);
        //when
        boolean result = pass.isSamePassType(StudyCafePassType.FIXED);
        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("주어진 passType 과 다른 passType 이다.")
    void isSamePassType_false() {
        //given
        StudyCafeLockerPass pass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 100000);
        //when
        boolean result = pass.isSamePassType(StudyCafePassType.HOURLY);
        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("주어진 duration 과 같은 duration 이다.")
    void isSameDuration_true() {
        //given
        StudyCafeLockerPass pass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 100000);
        //when
        boolean result = pass.isSameDuration(30);
        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("주어진 duration 과 다른 duration 이다.")
    void isSameDuration_false() {
        //given
        StudyCafeLockerPass pass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 100000);
        //when
        boolean result = pass.isSameDuration(60);
        //then
        assertFalse(result);
    }

}
