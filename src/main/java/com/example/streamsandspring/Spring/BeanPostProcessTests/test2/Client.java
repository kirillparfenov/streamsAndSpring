package com.example.streamsandspring.Spring.BeanPostProcessTests.test2;

import org.springframework.stereotype.Component;

@Component
public class Client {
//    @Autowired
//    Developer developer;
}

interface Developer {}

@Component
class JavaDeveloper implements Developer {}

//@Component
//class PythonDeveloper implements Developer {}