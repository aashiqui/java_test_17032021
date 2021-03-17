# java_test_17032021
## Build local

[Demo](https://bank.zubairshaikh.in Demo")


Just run spring boot application main class

## Build prod
Go to project's root directory run the command mvn clean install , It will generate the war file

## Deployment
Deploy the generated war to the external tomcat server

## API Prod

http://ip:port/java_test/api/post-data

## API Local

http://localhost:8080/api/post-data

### Reuqest:
{"bankDetails":"HSBC Canada,5601-2345-3446-5678,Nov-2017\nHSBC Canada,5601-2345-3446-5678,Nov-2017"}

### Response
[
{
    "bank": "HSBC Canada",
    "cardNumber": "5601-xxxx-xxxx-xxxx",
    "expiryDate": "Nov-2017"
}
]
