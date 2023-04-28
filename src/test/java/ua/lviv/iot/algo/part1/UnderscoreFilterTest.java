package ua.lviv.iot.algo.part1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UnderscoreFilterTest {

    @ParameterizedTest
    @CsvSource(value = {
            "Lorem ipsu_m dolor sit_ amet, consectetur adipiscing elit; 5; [ipsu_m, sit_]",
            "Etiam nunc tortor, lacinia ut leo at, viver_ra sagittis ante; 10; [viver_ra]",
            "Nunc la_oreet nibh mau__ris, si_t amet laoreet risus accumsan id; 6; [mau__ris, si_t]",
            "Cras pulvinar at sapi_en ac su__scipi_t. Mo_rbi non tempus odi_o__, vel vestib_ulum elit; 5; [Mo_rbi, odi_o__]",
            "Aliquam erat v_o_lutpat. In in _libero tincidunt, lobortis leo eg_et, __fermentum est; 8; [eg_et, _libero, v_o_lutpat]",
            "Some words without underscores; 10; []",
            "Different underscore positions _word; 4; [_word]",
            "Different underscore positions _w_ord; 4; [_w_ord]",
            "Different underscore positions wo_rd_; 4; [wo_rd_]",
            "Different underscore positions w_o__rd_; 4; [w_o__rd_]",
            "b__bbb, _eeee, aaaa_, ddd_d, cc_cc; 4; [aaaa_, b__bbb, cc_cc, ddd_d, _eeee]",},
            delimiter = ';')
    public void testSortWordsWithUnderscores(String text, int maxLengthWord, String expected) {
        UnderscoreFilter textToFilter = new UnderscoreFilter(text, maxLengthWord);
        assertEquals(expected, textToFilter.sortWordsWithUnderscores());
    }
}
