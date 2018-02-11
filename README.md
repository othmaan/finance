# Loan 💰 Planner 


<!--### Test cases result
[Preview](static/Test_Results.html)
-->

### Run executable
1. Project is an a IntelliJ IDEA project.
2. Go to `personal-finance/target`.
3. `java -jar personal-finance-0.0.1-SNAPSHOT.jar`


### Example
Request

```
curl -d '{"loanAmount": "5000", "nominalRate": "5", "duration": "24", "startDate": "2018-01-01T00:00:01Z"}' -H "Content-Type: application/json" -X POST http://localhost:8080/planner/generate-plan
```

Response

```
[
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2019-12-11T03:33:08",
        "initialOutstandingPrincipal": "218.37",
        "interest": "0.91",
        "principal": "218.45",
        "remainingOutstandingPrincipal": "0.0"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2019-12-11T03:33:08",
        "initialOutstandingPrincipal": "218.37",
        "interest": "0.91",
        "principal": "218.45",
        "remainingOutstandingPrincipal": "0.0"
    },
    ...
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2019-12-11T03:33:08",
        "initialOutstandingPrincipal": "218.37",
        "interest": "0.91",
        "principal": "218.45",
        "remainingOutstandingPrincipal": "0.0"
    }
    ...
]
```


<!--### Run all test cases
<div style="text-align: center">
<img src="static/all_tests.png" alt="demo" width="60%">
</div>-->

<!--### Run executable
`TBD`-->


<!--### Dependencies
```
Test dependencies:
	1. hamcrest-core
	2. hamcrest-library
	3. junit-4.12
``` -->

### File structure

```
root/src/com/lendico/finance
|
|--- FinanceApplication.java			* Spring Application root
|
|-- JerseyConfig.java			        * Resources configuration
│  
|-- planner/					* Loan planner use case
|        ├── algorithm     	                * All algorithms
|        ├── client     	                * Client request/response
|        ├── model     	                        * Business models
|        ├── operation     	        	* Business operations
|        └── resource                           * Resource endpoint
|        
|
|-- common/					* Contains common classes
|		 |
|		 ├── exception/                 * Exception package    
|        |    └── ApiException.java
|        |
|        ├── protocol/                          * Common interfaces
|        |    ├── BusinessToClient.java
|	     |    └── ClientToBusiness.java
|        |
|        └── util/                              * Utils package
|             ├── Constants.java		    
|             └── Utils.java
|
|
|
|-- test/					* All test cases
|        ├── ...     	
|        └── ...   
|
...
```
