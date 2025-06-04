package cleancode.minesweeper.tobe.sign;

import java.util.List;

import cleancode.minesweeper.tobe.cell.CellSnapshot;

public class CellSignFinder {

    private static final List<CellSignProvidable> CELL_SIGN_PROVIDERS = List.of(
            new UncheckedCellSignProvider(),
            new EmptyCellSignProvider(),
            new FlagCellSignProvider(),
            new LandMineCellSignProvider(),
            new NumberCellSignProvider()
    );

    public String findCellSignFrom(CellSnapshot snapshot) {
        return CELL_SIGN_PROVIDERS.stream()
                                  .filter(provider -> provider.supports(snapshot))
                                  .findFirst()
                                  .map(provider -> provider.provide(snapshot))
                                  .orElseThrow(() -> new IllegalArgumentException("확인할 수 없는 셀입니다."));
    }
}
