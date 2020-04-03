package sample.repo

class ParseFromXmlTest extends GroovyTestCase {
    void testParse() {
        def pfxml = new ParseFromXml()
        def wc = new WebClient()
        pfxml.parse(wc.getXml())
    }
}
