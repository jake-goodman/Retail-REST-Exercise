# myRetail RESTful service

Sample exercise aggregating product data from multiple sources and returns it to the caller. This API will retrieve product names from a RESTful API, and product prices from a local mongodb store.


You can make GET requests to the /product/{id} endpoint. If the product exists, you will be returned a json object containing the title of the object, and if we have the price stored in our database, the price as well. If we do not have the price in our own database, you will only be returned the product's title.


You can make a PUT request to the /product/{id} endpoint. This will add or update the price for this product in our local store. 


### Prerequisites

MongoDB installed locally

```
Installing MongoDB (On a Mac with homebrew): 
$ brew install mongodb

```

### Running

A step by step series of examples that tell you how to get a development env running

From terminal:

```
1. Run MongoDB:
$ mongod

2. Build the jar file (Skip this step if you were provided the jar file)
$ ./gradlew build

3. Run the myRetail-rest-api jar file:
java -jar build/libs/myRetail-rest-api-0.1.0.jar
```

## Use:

NOTE: The following product ids will be automatically populated in your mongodb store: 
13860428, 16696652, 13860429, 13860327, 16696651

GET Product Info:

```
$ curl -X GET localhost:8080/product/{id}
```

PUT Product Info:

```
$ curl -X PUT -d price=100.00 localhost:8080/product/{id}
```

## Example Test:

This demonstrates retrieving an item we do not have the price for, then updating its price, then getting the object again.


1. $ curl -X GET localhost:8080/product/13860419

Response:
```
{"title":"Some girls live from texas (DVD)"}
```


2. $ curl -X PUT -d price=100.00 localhost:8080/product/13860419

Response:
```
{"title":"Some girls live from texas (DVD)","price":100.0}
```
3. $ curl -X GET localhost:8080/product/13860419

Response:
```
{"title":"Some girls live from texas (DVD)","price":100.0}
```

