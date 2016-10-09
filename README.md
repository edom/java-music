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
- gui
- gui-awt
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

# User stories

## Big pictures

The user wants to create a composition.

The User wants to create an arrangement.

The User wants to insert rehearsal marks.

The User wants to print the score.

The User wants to write numbered notation for Indonesian choir.

The User wants to rewrite the time signature from 4/4 to 2/2 without changing the actual note duration.

The User wants to assign his own keyboard shortcut.

## Entry

The User wants to enter a G clef.

The User wants to enter a note using the QWERTY keyboard.

## Editing/correction

The User wants to delete the last note.

The User wants to move an object.

# Design

U: The Software provides a Cursor.

U: Pressing the Right arrow moves the Cursor to the next note.

U: Pressing the Left arrow moves the Cursor to the previous note.

U: The Cursor is a static yellow rectangle.

U: The background of the selected staff is #eee.

The background color of the editor is #fff.
