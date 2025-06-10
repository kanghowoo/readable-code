package cleancode.studycafe.tobe.model.pass;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPasses;

class StudyCafeSeatPassesTest {

    @DisplayName("좌석권으로 올바른 사물함권을 찾을 수 있다.")
    @Test
    void findLockerPassBy() {
        //given
        List<StudyCafeLockerPass> passList = List.of(
                StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 250_000),
                StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 700_000),
                StudyCafeLockerPass.of(StudyCafePassType.HOURLY, 4, 6_500),
                StudyCafeLockerPass.of(StudyCafePassType.HOURLY, 8, 11_000),
                StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, 2, 100_000),
                StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, 4, 150_000)
        );

        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(passList);

        //when
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(
                StudyCafePassType.FIXED, 4, 200_000, 0.1);

        Optional<StudyCafeLockerPass> lockerPassOptional = lockerPasses.findLockerPassBy(seatPass);

        //then
        assertThat(lockerPassOptional).isNotEmpty();

        StudyCafeLockerPass findLockerPass = lockerPassOptional.get();
        assertThat(findLockerPass.getPassType()).isEqualTo(StudyCafePassType.FIXED);
        assertThat(findLockerPass.getDuration()).isEqualTo(4);
        assertThat(findLockerPass.getPrice()).isEqualTo(250_000);
    }

    @Test
    @DisplayName("findPassBy()에 없는 타입 요청시 빈 리스트 반환")
    void findPassByReturnsEmptyIfNoneFound() {
        var passes = List.of(StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, 4, 150_000));
        StudyCafeSeatPasses seatPasses = StudyCafeSeatPasses.of(passes);

        var filtered = seatPasses.findPassBy(StudyCafePassType.WEEKLY);
        assertTrue(filtered.isEmpty());
    }
}
