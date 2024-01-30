package tests;

import data.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("Тест на поиск товаров по названию")
public class EnumsTests extends TestBases {

    @EnumSource(Product.class)
    @ParameterizedTest(name = "Успешный поиск товара по поисковому запросу: {0}")
    @DisplayName("Поиск и проверка товаров")
    @Tag("BLOCKER")
    public void successfulSearchProductTest(Product product) {
        $(".css-1977rpo").setValue(product.description).pressEnter();
        $(".app-catalog-1pwu1hf").$$(".app-catalog-fjtfe3").shouldBe(sizeGreaterThan(0));
    }
}