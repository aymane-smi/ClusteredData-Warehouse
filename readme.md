# ClusteredData Warehouse

## NOTE

all the project layout(service,repository and model) are generated automaticaly using my tool [spring-resource](https://github.com/aymane-smi/spring-resource)

## API DOCS

### send a single deal

`/api/v1/deal`

|method|payload|response|
| -----|-------|-------|
| `POST`| {id : `string?`, fromCurrency: `String`, toCurrency: `String`, amount: `double` } | {id : `string?`, fromCurrency: `String`, toCurrency: `String`, amount: `double`, deal_timestamp: `LocalDateTime`}|

### send a list of deals(batch save)

`/api/v1/deal/batchSave`

|method|payload|response|
| -----|-------|-------|
| `POST`| {id : `string?`, fromCurrency: `String`, toCurrency: `String`, amount: `double` }[] | {id : `string?`, fromCurrency: `String`, toCurrency: `String`, amount: `double`, deal_timestamp: `LocalDateTime`}[]|

### using swagger

you can use swagger for api documentation by visiting `/swagger-ui/index.html`

you can desactivate swagger in case you are deploing to the prof be changing `SWAGGER_ACTIVATION` in docker-compose to false


## Deploymenet

use only one command `makefile run-project` and voila! the project is runned

- if you want to run it without docker you can replace the config of the application.yml with your own config
- for better docker optimization i used the multstaging in order to reduce the size of the project image

## project managment

for managing the project i used github issue you can see all the closed ticket [here](https://github.com/aymane-smi/ClusteredData-Warehouse/issues?q=is%3Aissue+is%3Aclosed) and the still open one [here](https://github.com/aymane-smi/ClusteredData-Warehouse/issues)