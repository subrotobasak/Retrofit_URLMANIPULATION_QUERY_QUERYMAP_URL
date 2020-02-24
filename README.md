# Retrofit_URLMANIPULATION_QUERY_QUERYMAP_URL
Retrofit Tutorial Part 2 - URL MANIPULATION: @QUERY @QUERYMAP


With the @Query annotation, we can also pass arguments that Retrofit will append to the URL as query strings with the correct syntax (question mark, ampersand signs, equal signs...). We can declare and pass single values, we can pass multiple values for the same parameter in form of a List, array or varargs, or we can define a @QueryMap where we can pass any combination of parameters in form of a Map. 
By passing null we can omit a parameter, and to make a primitive int nullable we wrap it into an Integer object.
We will also learn about the @URL annotation, with which we can pass the (endpoint) URL directly as an argument instead of just certain parameters, and we will learn how URLs resolve and why the baseUrl needs a trailing slash in order to work.
