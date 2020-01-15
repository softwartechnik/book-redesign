[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=softwartechnik_book-redesign&metric=alert_status)](https://sonarcloud.io/dashboard?id=softwartechnik_book-redesign)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=softwartechnik_book-redesign&metric=coverage)](https://sonarcloud.io/dashboard?id=softwartechnik_book-redesign)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=softwartechnik_book-redesign&metric=ncloc)](https://sonarcloud.io/dashboard?id=softwartechnik_book-redesign)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=softwartechnik_book-redesign&metric=bugs)](https://sonarcloud.io/dashboard?id=softwartechnik_book-redesign)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=softwartechnik_book-redesign&metric=code_smells)](https://sonarcloud.io/dashboard?id=softwartechnik_book-redesign)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=softwartechnik_book-redesign&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=softwartechnik_book-redesign)

# BuchRedesign

## SonarQube Analyse

Die SonarQube Analyse erfolgt mit SonarCloud und ist [hier](https://sonarcloud.io/dashboard?id=softwartechnik_book-redesign) zu finden.

## Support Matrix

The build systems are configured with the following features:

|     Feature Support    | Ant | Maven | Gradle |
|:----------------------:|:---:|:-----:|:------:|
|          Build         |  ✅  |   ✅   |    ✅   |
|  Test (JUnit Jupiter)  |  ✅  |   ✅   |    ✅   |
| Test Coverage (JaCoCo) |  ❌  |   ✅   |    ✅   |
|           PMD          |  ❌  |   ✅   |    ✅   |
|        SpotBugs        |  ❌  |   ✅   |    ✅   |
|       CheckStyle       |  ❌  |   ✅   |    ✅   |
| SonarQube (SonarCloud) |  ❌  |   ✅   |    ❌   |

Note: Gradle supports SonarQube Report, but it was disabled to ensure there aren't duplicated reports for each build.

## Build Status
|        | Provider | Build Status                                                                                                                                |
|--------|-----------|---------------------------------------------------------------------------------------------------------------------------------------------|
| Master | Travis CI | [![Build Status](https://travis-ci.com/softwartechnik/book-redesign.svg?branch=master)](https://travis-ci.com/softwartechnik/book-redesign) |
| Master | Drone | [![Drone Build Status](http://drone.pipeline/api/badges/SWTD-WS1920-God/BuchRedesign/status.svg?branch=master)](http://drone.pipeline/SWTD-WS1920-God/BuchRedesign) |

### Build via ant

1. Install Ant via this [Guide](https://ant.apache.org/manual/install.html)
2. Run dist command
3. Find result at `./dist/book-redesign.jar`
4. Browse test Results at `ant-test-results/html/index.html`g

#### Build
```shell script
ant dist
```

#### Test
```shell script
ant clean test
```

### Build via Gradle

1. Run build command via gradle wrapper
2. Find result at `./build/libs/book-redesign-0.1.0-SNAPSHOT.jar`
3. Browse test results at

#### Build
```shell script
./gradlew assemble
```

#### Test
```shell script
./gradlew test
```

### Build via Maven

1. Run build command via gradle wrapper
2. Find result at `./build/libs/book-redesign-0.1.0-SNAPSHOT.jar`
3. Browse Test Results at `target/site/surefire-report.html`

#### Build
```shell script
mvn clean compile
```

#### Test
```shell script
mvn clean test
```