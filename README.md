# 🧠 CodingChallenges

A collection of algorithmic coding challenges, data structure implementations, and system design exercises written in **Kotlin**.
This repository serves as a personal preparation toolkit for technical interviews (FAANG-level and beyond), competitive programming practice, and teaching others through clean, idiomatic Kotlin examples.

---

## ✨ Highlights

- ✅ Clean, production-quality Kotlin solutions
- ✅ Extensive JUnit test coverage for each problem
- ✅ Modern techniques like sliding window, recursion, DFS/BFS, dynamic programming, etc.
- ✅ Clear problem annotations, edge case handling, and time/space complexity comments
- ✅ Android-relevant logic patterns (where applicable)

---

## 🧰 Technologies Used

| Stack      | Details          |
|------------|------------------|
| Language   | Kotlin 1.9.23 (with a couple of legacy Java solutions) |
| Platform   | Android application module (`com.android.application`), min SDK 15 / target SDK 34 |
| Build Tool | Gradle (Groovy DSL) + Android Gradle Plugin 8.10.1 |
| Testing    | JUnit 4                                          |
| CI         | GitHub Actions — unit tests + README-updated check required on every PR |
| Linting    | ktlint *(recommended)*                           |

---

## 📂 Directory Structure

```
CodingChallenges/
├── app/
│   ├── src/main/java/ga/egarcia/codingchallenges/
│   │   ├── solutions/hashmap/        ← HashMap problems (e.g. Two Sum)
│   │   ├── solutions/slidingwindow/  ← Sliding window problems
│   │   ├── solutions/binarytree/     ← Tree traversal problems
│   │   ├── solutions/graph/          ← Graph/grid BFS-DFS problems
│   │   ├── solutions/matrix/         ← Matrix indexing/binary search problems
│   │   ├── solutions/roman/          ← Roman numeral conversion problems
│   │   ├── solutions/patterns/       ← Pattern-printing warm-ups
│   │   └── ui/                       ← Minimal Android app shell used to host/demo solutions
│   └── src/test/java/ga/egarcia/codingchallenges/solutions/  ← Unit tests, mirroring the package above
├── build.gradle
├── app/build.gradle
└── README.md
```

> Each new topic (stack, linked list, binary search, graph, heap, backtracking, DP, greedy, design, ...) gets its own package under `solutions/`, matching the pattern above.

---

## ✅ Featured Problems

| Problem                                                   | Approach        | Difficulty |
|-----------------------------------------------------------|-----------------|------------|
| [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Sliding Window   | Medium     |
| [Two Sum](https://leetcode.com/problems/two-sum/)         | HashMap         | Easy       |
| [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/) | DFS + Merge Logic | Medium     |
| [Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | One-pass subtractive lookup | Easy |
| [Number of Islands](https://leetcode.com/problems/number-of-islands/) | Grid BFS Flood-Fill | Medium |
| [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | Multi-source BFS | Medium |
| [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/) | Flattened-Index Binary Search | Medium |
| Diamond Pattern                                            | Nested Loops    | Easy       |

> Want to contribute or request a problem to be added? Open an issue or PR.

---

## 🗺️ Roadmap

Tracked as GitHub issues, in the order they're intended to be tackled — each closes a gap in interview-critical categories not yet covered above:

1. [Valid Parentheses](https://github.com/e-Garcia/CodingChallenges/issues/9) — Stack
2. [Reverse Linked List](https://github.com/e-Garcia/CodingChallenges/issues/10) — Linked List
3. [Search in Rotated Sorted Array](https://github.com/e-Garcia/CodingChallenges/issues/11) — Binary Search
4. [Validate Binary Search Tree](https://github.com/e-Garcia/CodingChallenges/issues/12) — Trees
5. [Kth Largest Element in an Array](https://github.com/e-Garcia/CodingChallenges/issues/14) — Heap
6. [Subsets](https://github.com/e-Garcia/CodingChallenges/issues/15) — Backtracking
7. [House Robber](https://github.com/e-Garcia/CodingChallenges/issues/16) — Dynamic Programming
8. [Jump Game](https://github.com/e-Garcia/CodingChallenges/issues/17) — Greedy
9. [LRU Cache](https://github.com/e-Garcia/CodingChallenges/issues/18) — Design (HashMap + Linked List)

---

## 🚀 How to Run

```bash
# Run unit tests for the app module
./gradlew :app:testDebugUnitTest
```

---

## 🙋🏻‍♂️ About the Author

Erick García is a Principal Android Engineer with experience building resilient mobile systems, mentoring engineers, and solving complex platform-level problems in Android.

📫 [e-garcia.dev](https://github.com/e-Garcia)

---

## 📝 License

This repository is licensed under the MIT License.
