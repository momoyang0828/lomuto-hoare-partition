# CS147 HW2 — Lomuto & Hoare Partition (Quick Sort)

**Name:** Moebius Yang  
**Course:** CS147  
**Assignment:** Homework 2 — Partition Algorithms  

---

## Description

This project implements two Quick Sort partition schemes in Java:

- **Lomuto Partition** (pivot = `arr[high]`)
- **Hoare Partition** (pivot = `arr[low]`)

JUnit 5 unit tests are included to verify correctness using the required arrays:
- Sorted array: `[10, 17, 19, 21, 44, 55, 57, 63, 65, 67]`
- Empty array: `[]`
- Unsorted array: `[84, 3, 7, 1, 9, 6, 2, 5]`

---

## Project Structure

```
.
├── pom.xml
└── src
    ├── main/java/com/example/PartitionAlgorithms.java
    └── test/java/com/example/PartitionAlgorithmsTest.java
```

---

## How to Run Tests

### If Maven works in your terminal
```bash
mvn test
```

### If VSCode terminal does not recognize mvn (Windows)
```powershell
& "C:\Users\momo\Downloads\apache-maven-3.9.12-bin\apache-maven-3.9.12\bin\mvn.cmd" test
```

Expected output:
```
Tests run: 6, Failures: 0
BUILD SUCCESS
```

---

## Partition Behavior

### Lomuto Partition
- Pivot = `arr[high]`
- Returns **final pivot index**
- After partition:
  - Left side `<= pivot`
  - Right side `> pivot`

### Hoare Partition
- Pivot = `arr[low]`
- Returns **split index p**
- After partition:
  - `arr[low..p] <= pivot`
  - `arr[p+1..high] >= pivot`

---

## Notes

- Both partitions are **in-place** (swap elements inside the array).
- Lomuto returns pivot final position; Hoare returns a split point.
- Unit tests check **partition correctness**, not full sorting.
