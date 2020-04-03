package sample.repo

class CalculatorTestSecond extends GroovyTestCase {
    void testCalculate() {

        def c1 = new Currency("dalasi", 1, "GMD", 0.0744)
        def c2 = new Currency("dolar_jamajski", 1, "JMD", 2)
        def test = new Calculator()


        double result = 0.0372
        assertTrue(test.calculate(1, c1, c2) == result)

    }
}
