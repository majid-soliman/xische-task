the project contain of two apis.
1-one for creating the exchange invoice
2- for getting the invoice detials using the InvoiceId.
to create an new invoice, you can use the URI: http://localhost:8080/exchangeApi/createInvoice useing the following request body:
{
    "currency":"AED",
    "toCurrency":"OMR",
    "amount":2000,
    "userId":2,
    "password":"bdec1d5f-53da-4825-aecd-ec9f178ec836",
    "invoiceId":52
}
and to get the invoice details , you can use the following URI
http://localhost:8080/exchangeApi/getInvoice 
using the invoiceId as request body {"invoiceId":52}
Use the Api-key :ad01914bfe4ad42eb699c8a9 in the header of the request using the key: API-KEY as the following: API-KEY:ad01914bfe4ad42eb699c8a9 
this api key used to get the currency prices from www.exchangerate-api.com 
in the security side, ihave used the Spring security HttpSecurity to authenticate the authorized URN, and for the caching, i have used th Redis cache, please use the redis server before testing.
the project using MySQL DB called "exchange" and the tables can be created asutomaticlly soon as you run the project.

Used Java 17
MySQL 5.5
Redis for chaching
Post man for testing
