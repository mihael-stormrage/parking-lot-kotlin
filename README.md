# Parking Lot
Parking lot management program

That's a project I've done while learning on [JetBrains Academy][hyperskill]

## Overview
A parking lot management program that keeps track of vacant spots and parked cars.

```sh
> spot_by_color yellow
Sorry, a parking lot has not been created.
> create 4
Created a parking lot with 4 spots.
> park KA-01-HH-9999 White
White car parked in spot 1.
> park KA-01-HH-3672 White
White car parked in spot 2.
> park Rs-P-N-21 Red
Red car parked in spot 3.
> park Rs-P-N-22 Red
Red car parked in spot 4.
> reg_by_color GREEN
No cars with color GREEN were found.
> reg_by_color WHITE
KA-01-HH-9999, KA-01-HH-3672
> spot_by_color GREEN
No cars with color GREEN were found.
> spot_by_color red
3, 4
> spot_by_reg ABC
No cars with registration number ABC were found.
> spot_by_reg KA-01-HH-3672
2
> spot_by_reg Rs-P-N-21
3
> exit
```

## Requirements
- Download [JDK][openjdk-14] and extract
- Add JDK `/bin` directory to your PATH

## Usage
- Download [release]
- Run where you placed `parking.jar`:
```sh
java -jar parking.jar
```
- Or you can run Kotlin class (see Build)
- Run in `/parking` parent directory:
```sh
kotlin parking.MainKt
```

## Build
- Install [Kotlin compiler][kotlinc], same as JDK (see requirements)
- Run the following from project directory


- To build artifact:
```sh
kotlinc src/parking/Main.kt -include-runtime -d out/artifacts/parking.jar
```
- To build Kotlin class:
```sh
kotlinc src/parking/Main.kt -d out/production/classes
```

[openjdk-14]: http://jdk.java.net/14/
[kotlinc]: https://github.com/JetBrains/kotlin/releases/latest
[hyperskill]: https://hyperskill.org/projects/75
[release]: https://github.com/mihael-stormrage/parking-lot-kotlin/releases
