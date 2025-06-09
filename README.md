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
| Language   | Kotlin 1.9+      |
| Build Tool | Gradle + Kotlin DSL |
| Testing    | JUnit 5          |
| CI         | GitHub Actions *(planned)* |
| Linting    | ktlint *(recommended)* |

---

## 📂 Directory Structure

```
CodingChallenges/
├── src/
│   └── main/kotlin/ga/egarcia/codingchallenges/solutions/  ← challenge solutions
├── src/
│   └── test/kotlin/ga/egarcia/codingchallenges/solutions/  ← unit tests
├── build.gradle.kts
└── README.md
```

---

## ✅ Featured Problems

| Problem                                                   | Approach        | Difficulty |
|-----------------------------------------------------------|-----------------|------------|
| [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Sliding Window   | Medium     |
| Binary Tree Right Side View *(coming soon)*               | BFS/DFS         | Medium     |
| Retry with Exponential Backoff *(planned)*                | Coroutine Flow  | Medium     |

> Want to contribute or request a problem to be added? Open an issue or PR.

---

## 🚀 How to Run

```bash
# Run tests
./gradlew test
```

---

## 🙋🏻‍♂️ About the Author

Erick García is a Principal Android Engineer with experience building resilient mobile systems, mentoring engineers, and solving complex platform-level problems in Android.

📫 [e-garcia.dev](https://github.com/e-Garcia)

---

## 📝 License

This repository is licensed under the MIT License.
