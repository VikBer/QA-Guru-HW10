package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("Тест на поиск товаров по названию")
public class ValueSourceTests extends TestBases {



    @ValueSource(strings = {
            "Iphone", "Samsung", "Xiaomi"
    })
    @ParameterizedTest(name = "Успешный поиск товара по поисковому запросу: {0}")
    @DisplayName("Поиск и проверка товаров")
    @Tag("BLOCKER")
    public void successfulSearchProductTest(String searchProduct) {
        $(".css-1977rpo").setValue(searchProduct).pressEnter();
        $(".app-catalog-1pwu1hf").$$(".app-catalog-fjtfe3").shouldBe(sizeGreaterThan(0));
    }
}