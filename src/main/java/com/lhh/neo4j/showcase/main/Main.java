package com.lhh.neo4j.showcase.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lhh.neo4j.showcase.model.Product;

import javax.transaction.*;

public class Main {

    private static final String CLASSPATH_LOCATION = "classpath:com/lhh/neo4j/showcase/main/related-to-via-test-context.xml";

    public static void main(String[] args) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CLASSPATH_LOCATION);

        Neo4jPersister neo4jPersister = (Neo4jPersister) context.getBean("neo4jPersister");

        //neo4jPersister.createTestData();
        List<Product> list =  neo4jPersister.productRepository.findAllProductsSortedByName();
        System.out.println(list.size());
    }
}
