package StepDefinition;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class SumTest {

    double a;
    double b;
    double result;

    @Before
    public void sayBefore(){
        System.out.println("Before");
    }

    @After
    public void sayAfter(){
        System.out.println("After");
    }

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