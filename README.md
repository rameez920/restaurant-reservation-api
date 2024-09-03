# Restaurant Reservation API

## A simple API to look up and make reservations based on a user's dietary restrictions

### Overview
This project was created using Java and SpringBoot and uses H2, an in memory DB. Maven is used to manage dependencies 
and to build the executable for the project. The project also contains SQL scripts to create the schema and insert some test data.

### Endpoints
#### Returns a list of available Restaurants based on diner's dietary restrictions
> GET /restaurants/reservations?startTime="""&dinerIds=[]

#### Creates a Reservation
> POST /restaurants/reservations

    Body
    {
        dinerIds: []
        restaurantId: string
        startTime: YYYY-MM-ddTHH:MM
    }

#### Deletes a reservation
> DELETE /restaurants/reservations?reservationId=""
