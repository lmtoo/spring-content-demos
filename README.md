# spring-content bug reproduce


### spring.content.rest.base-uri leading slash missing 

    https://github.com/paulcwarren/spring-content/issues/87
    
    
- step1. start the boot application
- step2. open chrome and navigate to http://localhost:8080/archives/
- step3. open chrome developer tools and switch to network pannel
- step4. upload a file
- step5. watch http://localhost:8080/archives/api/v1/documents/ response