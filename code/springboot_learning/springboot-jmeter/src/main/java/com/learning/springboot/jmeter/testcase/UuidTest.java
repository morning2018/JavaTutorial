package com.learning.springboot.jmeter.testcase;

import com.learning.springboot.jmeter.service.UuidGenerator;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class UuidTest extends AbstractJavaSamplerClient {

    @Override
    public void setupTest(JavaSamplerContext context) {
        super.setupTest(context);
    }

    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult results = new SampleResult();
        results.setSampleLabel("UuidTest");
        results.sampleStart();
        UuidGenerator.generateUuid();
        results.setSuccessful(true);
        results.sampleEnd();
        return results;
    }

    @Override
    public void teardownTest(JavaSamplerContext context) {
        super.teardownTest(context);
    }
}
