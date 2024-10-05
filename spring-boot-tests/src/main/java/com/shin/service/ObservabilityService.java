package com.shin.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class ObservabilityService {

    private final MeterRegistry meterRegistry;

    public ObservabilityService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public void processData() {
        // Simulate processing and record a metric
        meterRegistry.counter("service.process.calls").increment();
    }
}
