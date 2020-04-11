import io.restassured.http.ContentType
import org.apache.http.HttpException
import spock.lang.Specification
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.specification.RequestSpecification

import static com.test.card_translate.tests.translate.constants.DomenTranslateConstants.DOMEN_TRANSLATE
import static com.test.card_translate.tests.translate.constants.UrlTranslateConstants.URL_TRANSLATE
import static com.test.card_translate.tests.translate.constants.ApiTranslateConstants.*
import static com.test.card_translate.tests.translate.constants.ErrorMessageTranslateConstants.*
import static io.restassured.RestAssured.given
import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.CoreMatchers.hasItem;


class YandexTranslateSpec extends Specification {
   private static RequestSpecification spec

    def setupSpec() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(DOMEN_TRANSLATE + URL_TRANSLATE)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }


    def positive_test() {

        given:
        try {
            given()
                    .spec(spec)
                    .param("key",KEY_TRANSLATE)
                    .param("lang",EN_RU_LANG_TRANSLATE)
                    .param("text",actual)
                    .when().get()
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .and()
                    .body("text",hasItem(expected))
        }
        catch(HttpException e){
            e.printStackTrace()
        }
        where:
        actual            | expected
        "What time is it" | "Сколько времени"
        "how are you"     | "как вы"
        "hello world"     | "Привет мир"
    }

    def negative_test(){
        given:
        try {
            given()
                    .spec(spec)
                    .param("key", key)
                    .param("lang", EN_RU_LANG_TRANSLATE)
                    .param("text", actual)
                    .when().get()
                    .then()
                    .assertThat()
                    .statusCode(403)
                    .and()
                    .body("code", equalTo(INVALID_KEY_CODE))
                    .and()
                    .body("message", equalTo(INVALID_KEY))
        }
        catch(HttpException e){
            e.printStackTrace()
        }
            where:
            actual  | expected | key
            "hello" | "привет" | WRONG_KEY_TRANSLATE
    }
}
