package sample.repo

class WebClientTest extends GroovyTestCase {
    void testGetXml() {
        def wbcli = new WebClient()
        wbcli.getXml()
    }
}
