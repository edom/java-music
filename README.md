# The plan

The plan is to write a music notation editor in Java.

## Building and packaging

To build and package all modules:

```
./gradlew distTar
```

That creates `MODULE/build/distributions/MODULE.tar` for each module.

If you want ZIP files instead of TAR files:

```
./gradlew distZip
```

## Opening the project in IntelliJ IDEA

Generate the IntelliJ IDEA project:

```
./gradlew idea
```

Open the generated IntelliJ IDEA project.

## Legal

### Copyright holder

Copyright (c) 2016 Erik Dominikus

### Licenses

The following modules are licensed under Apache License version 2.0:

(There is none yet, but we plan to move as many modules as possible to that Apache license.)

The following modules are licensed under GNU Affero General Public License version 3:

- draw
- draw-awt
- music-notation
- music-notation-editor
- music-notation-editor-swing

The copyright holder reserves the right to change the licenses.

### External libraries and licenses

These include transitive dependencies.

For the versions used, see the `build.gradle` file.

#### MIT

- org.slf4j:slf4j-api

#### LGPL 3.0

- org.audiveris:proxymusic

#### LGPL 2.1

- ch.qos.logback:logback-classic
