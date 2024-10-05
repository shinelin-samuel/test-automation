package com.shin.graphql;

import com.shin.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@GraphQlTest(HomeController.class)
public class GraphQLControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    //TODO: Runtime execution error, need to resolve
    //java: error reading /Users/shinelin/.m2/repository/org/jetbrains/kotlinx/kotlinx-coroutines-core-jvm/1.8.1/kotlinx-coroutines-core-jvm-1.8.1.jar; zip file is empty
    @Test
    void shouldGreetWithSpecificName() {
        this.graphQlTester.document("{ greeting(name: \"Alice\") } ")
                .execute()
                .path("greeting")
                .entity(String.class)
                .isEqualTo("Hello, Alice!");
    }

    @Test
    void shouldGreetWithDefaultName() {
        this.graphQlTester.document("{ greeting } ")
                .execute()
                .path("home/get-profile")
                .entity(String.class)
                .isEqualTo("Hello, Spring!");
    }

}
