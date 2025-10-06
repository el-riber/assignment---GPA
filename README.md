# GPA to Percentage Range (Switch)

A simple Java console app that accepts a student's GPA and outputs the corresponding percentage range using a `switch` statement.

## How it works
- Reads a GPA from standard input.
- Rounds to **one decimal place** (`HALF_UP`).
- Uses a `switch` on the rounded GPA (scaled by 10) to print the percentage range per the class grading scheme.
- Validates the range **0.0–4.0**.

## Build & Run
```bash
javac GpaToPercentRange.java
java GpaToPercentRange
