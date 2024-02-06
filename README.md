# Article Finder

### Uses:

- openjdk 11.0.21
- Apache Maven 3.9.6

### Dependencies

- org.apache.logging.log4j/log4j-api v2.21.1
- org.apache.logging.log4j/log4j-core v2.21.1
- org.apache.commons/commons-lang3 v3.12.0
- commons-io/commons-io v2.15.0
- com.fasterxml.jackson.core/jackson-core v.2.16.1
- com.fasterxml.jackson.core/jackson-databind v.2.16.1

### Plugins

- org.apache.maven.plugins/maven-compiler-plugin v3.11.0
- org.codehaus.mojo/exec-maven-plugin v3.1.0

Carina API Assignment:

1. Use Carina for test automation
2. Create 5 api test cases for any open api resource for testing that you find
3. Automate 5 API cases

## How to Use

### Set Up `_config.properties` flile

1. Go to [developer.nytimes.com](developer.nytimes.com), create an account, and then click on "Apps"
   where the user icon is. Create a new app and then get the API key value from there.
2. Rename `_example.config.properties` to `_config.properties` and input the API key value you've created
   at [developer.nytimes.com](developer.nytimes.com) under the `nyt_api_key` parameter.


```text
# _config.properties
# Replace "yourkeyhere" with the key from the 
# NY Times Developers portal where it says 

nyt_api_key=yourkeyhere
nyt_api_url=https://api.nytimes.com
nyt_api_article_search_path=svc/search/v2/articlesearch.json
```

### Run Tests

```shell
# Install will run the test as well
mvn clean install -U

# Run the test again without clean install
mvn test
```
