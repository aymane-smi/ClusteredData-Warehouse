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