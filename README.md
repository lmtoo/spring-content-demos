# spring-content bug reproduce


### Property Collection Associations links to 404 

    https://github.com/paulcwarren/spring-content/issues/90
    
    
- step1. start the boot application
- step2. create document metadata
        
         curl -H "Content-Type:application/json" -X POST http://localhost:8080/api/v1/documents/ -d "{}"
         
- step3. upload a file

        curl -F 'file=@/etc/hosts' http://localhost:8080/api/v1/content/1
           
- step4. create a document group 

       curl -X POST http://localhost:8080/api/v1/documentGroup -H "Content-Type:application/json" -d "{\"name\":\"groupName\"}"

- step5. link the group to document
        
       curl -X PUT http://localhost:8080/api/v1/documentGroup/2/entries -H "Content-Type:text/uri-list" -d "http://localhost:8080/api/v1/documents/1"
 
 - step6. navigate to group
 
        curl http://localhost:8080/api/v1/documentGroup/2
 
 - step7. navigate to entries 
    
        curl http://localhost:8080/api/v1/content/2/entries/882ab7b0-545f-4a2a-b727-43d992978d2d



