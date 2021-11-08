package com.demo.catalogservice.service;

import com.demo.catalogservice.repository.GraphQLDataFetcher;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

@Component
public class GraphQLProvider {
    private GraphQL graphQL;
    @Autowired
    GraphQLDataFetcher graphQLDataFetcher;

    @Bean
    public GraphQL graphQL(){
        return graphQL;
    }
    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sd1 = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sd1);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sd1) {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(sd1);
        RuntimeWiring runtimeWiring  = buildWiring();
        SchemaGenerator schemaGenerator =  new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .build();

    }

}
