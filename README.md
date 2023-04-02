# graphqxl-maven-plugin
This is a Maven plugin to build a GraphQL schema from GraphQXL files. It executes the `graphqxl` command line tool during 
the compile phase on the specified files and generates a GraphQL schema file.


## Usage
This assumes that you have `graphqxl` installed on your system. If not, you can install it with `npm install -g graphqxl`.
Or you can follow the instructions on the [graphqxl](https://github.com/gabotechs/graphqxl) repository.

### Configuration
The plugin has the following configuration options:

