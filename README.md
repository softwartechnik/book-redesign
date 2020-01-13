# BuchRedesign

## Build via ant

1. Install Ant via this [Guide](https://ant.apache.org/manual/install.html)
2. Run dist command
3. Find result at `./dist/book-redesign.jar`
4. Browse test Results at `ant-test-results/html/index.html`g

### Build
```shell script
ant dist
```

### Test
```shell script
ant clean test
```

## Build via Gradle

1. Run build command via gradle wrapper
2. Find result at `./build/libs/book-redesign-0.1.0-SNAPSHOT.jar`
3. Browse test results at

### Build
```shell script
./gradlew assemble
```

### Test
```shell script
./gradlew test
```

## Build via Maven

1. Run build command via gradle wrapper
2. Find result at `./build/libs/book-redesign-0.1.0-SNAPSHOT.jar`
3. Browse Test Results at `target/site/surefire-report.html`

### Build
```shell script
mvn clean compile
```

### Test
```shell script
mvn clean test
```