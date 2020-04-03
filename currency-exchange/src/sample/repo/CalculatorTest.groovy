package sample.repo

class CalculatorTest extends GroovyTestCase {
    void testCalculate() {

        def c1 = new Currency("dalasi", 1, "GMD", 0.0744)
        def c2 = new Currency("polski_zloty", 1, "PLN", 1)
        def test = new Calculator()


        double result = 0.0744
        assertTrue(test.calculate(1, c1, c2) == result)
    }
}
