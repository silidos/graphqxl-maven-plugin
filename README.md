# graphqxl-maven-plugin
This is a Maven plugin to build a GraphQL schema from GraphQXL files. It executes the `graphqxl` command line tool during 
the compile phase on the specified files and generates a GraphQL schema file.


## Usage
This assumes that you have `graphqxl` installed on your system. If not, you can install it with `npm install -g graphqxl`.
Or you can follow the instructions on the [graphqxl](https://github.com/gabotechs/graphqxl) repository.

You can add the plugin to your `pom.xml` file like so:

```xml
<plugin>
                <groupId>io.github.silidos</groupId>
                <artifactId>graphqxl-maven-plugin</artifactId>
                <version>1.0.0</version>
                <executions>
                    <execution>
                        <id>graphqxl-compile</id>
                        <phase>compile</phase>
                        <goals>
                            <goal>graphqxl</goal>
                        </goals>
                        <configuration>
                            <inputFile>${project.basedir}/src/main/resources/schema/schema.graphqxl</inputFile>
                        </configuration>
                    </execution>
                </executions>
</plugin>
```            

### Configuration
The plugin has the following configuration options:

* `inputFile` - The path to the GraphQXL file to compile

