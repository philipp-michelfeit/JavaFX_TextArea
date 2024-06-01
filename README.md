# Demo project for Squish TextArea bug

## Use pre-built binaries
[https://github.com/philipp-michelfeit/JavaFX_TextArea/releases/tag/v1.0/app.zip](https://github.com/philipp-michelfeit/JavaFX_TextArea/releases/download/v1.0/app.zip)

## Build project
1. mvn clean javafx:jlink
2. mvn process-resources ( workaround for not copying props.properties file correctly through the build-process )

## Run project
1. cd target/app/bin/
2. ./app.bat
