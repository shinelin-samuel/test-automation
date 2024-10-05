package com.shin.observability;

import com.shin.service.ObservabilityService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.actuate.observability.AutoConfigureObservability;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureObservability // Enables observability features like metrics and tracing
public class ObservabilityTest {

    private ObservabilityService observabilityService;
    private MeterRegistry meterRegistry = new SimpleMeterRegistry();

    @BeforeEach
    public void setUp() {
        // Initialize the in-memory meter registry
        observabilityService = new ObservabilityService(meterRegistry);
    }

    @Test
    public void testObservabilityForEndpoint() throws Exception {
        observabilityService.processData();

        double requestCount = meterRegistry.counter("service.process.calls").count();
        Assertions.assertTrue(requestCount > 0, "Service metrics should have been recorded");

    }
}
