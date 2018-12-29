package StepDefinition;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;

public class SumTest {

    double a;
    double b;
    double result;

    @Дано("^два числа (\\d+) и (\\d+)$")
    public void given(double a, double b) {
        this.a = a;
        this.b = b;
        System.out.println("Дано");
    }

    @Когда("^мы складываем их$")
    public void when(){
        result=a+b;
        System.out.println("Когда");
    }

    @Тогда("^получим (\\d+)$")
    public void then(double res){
        System.out.println("Тогда");
        Assert.assertEquals(res,result,0.0001);
    }
}