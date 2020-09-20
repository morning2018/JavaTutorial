package com.learning.xml;

import com.learning.xml.entity.SQLCase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class JAXBTest {

    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(SQLCase.class);
        Marshaller marshaller = context.createMarshaller();
        Unmarshaller unmarshaller = context.createUnmarshaller();

        /*SQLCase sql = new SQLCase();
        marshaller.marshal(sql, System.out);
        System.out.println();*/

        String xml = "<sqlcase><caseId>1111</caseId></sqlcase>";
        SQLCase sql2 = (SQLCase) unmarshaller.unmarshal(new StringReader(xml));
        System.out.println(sql2.getCaseId());

    }
}
