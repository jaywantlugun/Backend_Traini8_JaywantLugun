Using H2 Database for storing data

1. configured datasource url in src/main/resource application.properties

	spring.datasource.url=jdbc:h2:mem:testdb

So, to open database navigate to

	http://localhost:8080/h2-console

Use JDBC URL = jdbc:h2:mem:testdb


<-----API----->

2. //GET Request to retrieve all TrainingCenter

	http://localhost:8080/training-center-list


3. //GET Request to retrieve all TrainingCenter with filter according to capacity
	returns all TrainingCenter where capacity greater that passed capacity 

	http://localhost:8080/training-center-list?min_capacity=10


4. //POST Request to add TrainingCenter in database

	http://localhost:8080/training-center


Sample Body for POST Request

{
  "centerName": "center 002kkkk",
  "centerCode": "012312345671",
  "address": {
    "detailedAddress": "jjch",
    "city": "Robertsganj",
    "state": "Uttar Pradesh",
    "pincode": 231216
  },
  "capacity": 190,
  "courses": [
    "course1",
    "course2"
  ],
  "createdOn": "2024-04-25",
  "email": "hello@gmail.com",
  "phoneNumber": "8949477335"
}
















