# demo-plain-java

Plain Java Maven project (Java 21).

## Spec
- `groupId`: `com.example`
- `artifactId`: `demo-plain-java`
- `packaging`: `jar`
- Main class: `com.example.App`

## Build
```bash
mvn -B clean package
```

## Run
```bash
java -cp target/demo-plain-java-1.0.0-SNAPSHOT.jar com.example.App
```

## Test
```bash
mvn -B test
```
