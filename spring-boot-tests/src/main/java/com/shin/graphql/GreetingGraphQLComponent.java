package com.shin.graphql;

import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GreetingGraphQLComponent {

    @DgsQuery
    public String greeting(String name) {
        return "Hello " + name;
    }
}
