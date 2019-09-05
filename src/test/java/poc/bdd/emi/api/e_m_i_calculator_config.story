Narrative: EMI Calculator API
    As a user
    I want to call EMI Calculator API
    In order to get my EMI calculation

Scenario: Happy path
Given the Product name is <name>, Price is <price>, PurchaseDate is <purchaseDate>, EMIPerc is <emiPerc>, EMIDuration is <emiDuration>
When the Product is valid
Then the EMI calculated for the product <httpStatus>

Examples:
|name|price|purchaseDate|emiPerc|emiDuration|httpStatus|
|Mobile|7500.0|2019-06-26|9|3|201|     









