Adresses :

GET http://localhost:8080/addresses?city=Paris  
DELETE http://localhost:8080/address/0  
POST http://localhost:8080/addresses  
Content-Type: application/json  
{
"id": 4,
"city": "Paris",
"street": "12 rue de Montcuq",
"postalCode": "75000"
}

Centres :

GET http://localhost:8080/centers?name=Grand%20centre%20de%20vaccination  
GET http://localhost:8080/centers?city=Paris  
DELETE http://localhost:8080/center/0  
POST http://localhost:8080/centers  
Content-Type: application/json  
{
"id": 0,
"name": "Grand centre de vaccination",
"addressId": 4
}

Médecins :

GET http://localhost:8080/doctors?name=Mario  
DELETE http://localhost:8080/doctor/0  
POST http://localhost:8080/doctors  
Content-Type: application/json  
{
"id": 1,
"name": "Gregory House",
"address": {
"id": 3
}
}

Patients :

GET http://localhost:8080/patients?name=Jean  
GET http://localhost:8080/patient/2  
DELETE http://localhost:8080/patient/3  
POST http://localhost:8080/patients  
Content-Type: application/json  
{
"id": 3,
"name": "Jean",
"birthDate": "2020-10-07T00:00:01.084+00:00"
}  
POST http://localhost:8080/patients  
Content-Type: application/json  
{
"id": 2,
"name": "John",
"birthDate": "2019-10-07T00:00:01.084+00:00"
}